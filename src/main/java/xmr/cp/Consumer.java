package xmr.cp;

import java.util.Queue;

/**
 * Created by xmr on 2019/8/3.
 */
public class Consumer {
    private Queue<Object> queue;
    private int maxSize;

    public Consumer(Queue<Object> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }
    public Object get(){
        Object ret = null;
        synchronized (queue) {
            while(queue.isEmpty()){
                System.out.println("Queue is Empty");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //1 做移除元素操作
            ret = queue.remove();
            System.out.println("删除元素："+ret);
            queue.notify();
        }
        return ret;
    }
}
