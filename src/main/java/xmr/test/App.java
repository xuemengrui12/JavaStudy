package xmr.test;

/**
 * Created by xmr on 2018/2/8.
 */
public class App {
    private static class InnerClz{

    }
    public static void main(String[] args) {

        App.InnerClz clz1=new InnerClz();
        App.InnerClz clz2=new InnerClz();
        System.out.println(clz1.equals(clz2));

    }
}
