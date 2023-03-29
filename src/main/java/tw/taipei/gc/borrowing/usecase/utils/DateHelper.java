package tw.taipei.gc.borrowing.usecase.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public static Date toDate(String dateString) {
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(Date date) {
        if (date == null) {
            return "";
        }
        return dateFormat.format(date);
    }
}
