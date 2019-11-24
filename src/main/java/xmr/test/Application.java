package xmr.test;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/2/21.
 */
public class Application {
    public static void main(String[] args) {
//        Collection<String> list=new ArrayList<>();
//        for (int i=0;i<8;i++)
//            list.add("list"+i);
//        Iterator iterator=list.iterator();
//        while (iterator.hasNext())
//            System.out.println(iterator.next());
//
//        Collection<Integer> list1=new LinkedList<>();
//        for (int i=0;i<8;i++)
//            list1.add(new Integer(i));
//        Iterator<Integer> iterator1=list1.iterator();
//        while (iterator1.hasNext())
//            System.out.println(iterator1.next());

        Scanner scanner=new Scanner(System.in);

        System.out.println("请输入第一个数");
        double numA=scanner.nextDouble();
        System.out.println("请输入第二个数");
        double numB=scanner.nextDouble();
        System.out.println("请输入运算符");
        String operate=scanner.next();

        double result=0;
        switch (operate){
            case "+":
                result=numA+numB;
                break;
            case "-":
                result=numA-numB;
                break;
            case "*":
                result=numA*numB;
                break;
            case "/":
                result=numA/numB;
                break;
        }
        System.out.println("最后结果为："+result);
    }
}


