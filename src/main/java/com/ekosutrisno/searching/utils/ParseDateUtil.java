package com.ekosutrisno.searching.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Eko Sutrisno
 * Thursday, 04/03/2021 15:05
 */
public class ParseDateUtil {

    public static Date getDate(String dateString) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));

        Date result = null;

        try {
            result = format.parse(dateString);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        return result;
    }
}
