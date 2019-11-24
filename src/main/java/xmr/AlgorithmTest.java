package xmr;

import java.util.Arrays;

/**
 * 排序算法
 * Created by xmr on 2019/10/22.
 */
public class AlgorithmTest {

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
//        mergingSort(arr);
//        radixSort(arr);
        mergeSort(arr,0,7);

//        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序（递归） * *
     * ①. 将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
     * ②. 将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
     * ③. 重复步骤②，直到所有元素排序完毕。
     *
     * @param arr 待排序数组
     */
    public static int[] mergingSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int num = arr.length >> 1;
        int[] leftArr = Arrays.copyOfRange(arr, 0, num);
        int[] rightArr = Arrays.copyOfRange(arr, num, arr.length);
        System.out.println("split two array: " + Arrays.toString(leftArr) + " And " + Arrays.toString(rightArr));
        return mergeTwoArray(mergingSort(leftArr), mergingSort(rightArr));
        //不断拆分为最小单元，再排序合并
    }

    private static int[] mergeTwoArray(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[arr1.length + arr2.length]; //申请额外的空间存储合并之后的数组
        while (i < arr1.length && j < arr2.length) { //选取两个序列中的较小值放入新数组
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) { //序列1中多余的元素移入新数组
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) { //序列2中多余的元素移入新数组
            result[k++] = arr2[j++];
        }
        System.out.println("Merging: " + Arrays.toString(result));
        return result;
    }

    /**
     * 基数排序（LSD 从低位开始） *
     * 基数排序适用于：
     * (1)数据范围较小，建议在小于1000 *
     * (2)每个数值都要大于等于0 *
     * ①. 取得数组中的最大数，并取得位数；
     * ②. arr为原始数组，从最低位开始取每个位组成radix数组；
     * ③. 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     *
     * @param arr 待排序数组
     */
    public static void radixSort(int[] arr) {
        if (arr.length <= 1) {

            return;//取得数组中的最大数，并取得位数
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max = max / 10;
        }
        System.out.println("maxDigit: " + maxDigit);//申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        int base = 10;//从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {
            int[] bktLen = new int[10]; //存储各个桶中存储元素的数量
            // 分配：将所有元素分配到桶中
            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }
            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen[b]; p++) {
                    arr[k++] = buckets[b][p];
                }
            }
            System.out.println("Sorting: " + Arrays.toString(arr));
            base *= 10;
        }
    }

    /**
     * 归并排序的递归方式
     * @param array
     * @param start
     * @param end
     */
    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            //折半成两个小集合，分别进行递归
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            //把两个有序小集合，归并成一个大集合
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        //开辟额外大集合，设置指针
        int[] tempArray = new int[end - start + 1];
        int p1 = start, p2 = mid + 1, p = 0;
        //比较两个小集合的元素，依次放入大集合
        while (p1 <= mid && p2 <= end) {
            if (array[p1] <= array[p2]) {
                tempArray[p++] = array[p1++];
            } else {
                tempArray[p++] = array[p2++];
            }
        }
        //左侧小集合还有剩余，依次放入大集合尾部
        while (p1 <= mid) {
            tempArray[p++] = array[p1++];
        }
        //右侧小集合还有剩余，依次放入大集合尾部
        while (p2 <= end) {
            tempArray[p++] = array[p2++];
        }
        //把大集合的元素复制回原数组
        for (int i = 0; i < tempArray.length; i++) {
            array[i + start] = tempArray[i];
        }
    }
}
