package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Util {
    public static String getDate(){
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return formatter.format(date);
    }

    public static int getRundomNum(){
        Random random = new Random();
        int tmp = random.nextInt(1000);
        return tmp;
    }
}
