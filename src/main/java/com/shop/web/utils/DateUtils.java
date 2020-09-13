package com.shop.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {



    public static final long ONE_DAY = 24 * 60 * 60 * 1000;
    public static final String FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String FORMAT_1 = "yyyy-MM-dd'T'HH:mm:ss.SSS Z";

    public static String getDateString(Date date,String format){


        SimpleDateFormat formatter = new SimpleDateFormat(format);

        return formatter.format(date);
    }

    public static String getDateString(Date date) {


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return formatter.format(date);
    }

    public static Date getDateByFormat(Date date,String format){


        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateS = formatter.format(date);

      try {
          return formatter.parse(dateS);
      }catch (Exception e){
          return new Date();
      }
    }


}
