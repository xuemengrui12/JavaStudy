package executor.callable;

import java.util.concurrent.Callable;

/**
 * 真实数据
 */
public class RealData implements Callable<String> {

    private String result;

    public RealData(String result) {
        this.result = result;
    }

    public String call() {
        System.out.println("根据" + result + "进行查询，这是一个很耗时的操作..");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("操作完毕，获取结果");
        result = "查询结果";
        return result;
    }


}
