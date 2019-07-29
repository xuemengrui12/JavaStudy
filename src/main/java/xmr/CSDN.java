package xmr;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created by xmr on 2018/6/29.
 */
public class CSDN {
    public static void main(String[] args) {
        //创建一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个GET对象
        HttpGet get = new HttpGet("https://blog.csdn.net/xuemengrui12/article/details/78273504");
        //执行请求
        try {
            for (int i = 1; i <= 1000; i++) {

                CloseableHttpResponse response = httpClient.execute(get);
                //取响应的结果
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != HttpStatus.SC_OK) {
                    System.out.print("失败：" + response.getStatusLine());
                }
//                HttpEntity entity = response.getEntity();
//                String string = EntityUtils.toString(entity, "utf-8");
//                System.out.println(string);
                System.out.println("您已经成功刷新了" + i + "次！");
                //关闭httpclient
                response.close();
                Thread.sleep(1000*60);
            }
            httpClient.close();
        } catch (IOException e) {
            System.out.print("请检查网络地址！");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
