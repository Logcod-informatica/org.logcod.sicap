package calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ConfigCalendar {

    public static Calendar setFormatarDateCalendar(String dateView){
        try{
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dateView));
            return calendar;
        }catch (Exception e){
            return  null;
        }


    }

    public static String setFormatarDateCalendar(Calendar calendar){
        try{
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
             return format.format(calendar);
        }catch (Exception e){
            return  null;
        }


    }
}
