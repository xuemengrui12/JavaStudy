package xmr.format;

import java.text.MessageFormat;
import java.util.Date;

/**
 * Created by xmr on 2019/8/24.
 */
public class StrFormatTest {
    public static void main(String[] args) {
        String result = MessageFormat.format(
                "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
                5, new Date(), "a disturbance in the Force");
        System.out.println(result);
    }
}
