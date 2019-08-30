package xmr;


import okhttp3.*;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 */
public class HsHttpRequest {
    private String[] url = {"https://blog.csdn.net/xuemengrui12/article/details/78530594"
            , "https://blog.csdn.net/xuemengrui12/article/details/82709208"
            , "https://blog.csdn.net/xuemengrui12/article/details/83718678"
            , "https://blog.csdn.net/xuemengrui12/article/details/87906861"
            , "https://blog.csdn.net/xuemengrui12/article/details/82457514"
            , "https://blog.csdn.net/xuemengrui12/article/details/82454910"
            , "https://blog.csdn.net/xuemengrui12/article/details/81104953"
            , "https://blog.csdn.net/xuemengrui12/article/details/82708326"
            , "https://blog.csdn.net/xuemengrui12/article/details/98783715"
            , "https://blog.csdn.net/xuemengrui12/article/details/82707342"
            , "https://blog.csdn.net/xuemengrui12/article/details/79997036"};

    OkHttpClient client = new OkHttpClient();
    Random random = new Random();

    private void start() {
        while (true) {
            int index = random.nextInt(11);
            refreshUrl(url[index]);
            System.out.println("refresh " + index);
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(30)+60);
//                Thread.sleep((random.nextInt(60)+30) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void refreshUrl(String url) {
         Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {

            }

            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    System.out.println("success");
                }
                response.close();
            }
        });
        request=null;
    }

    public static void main(String[] args) {
        new HsHttpRequest().start();
    }
}
