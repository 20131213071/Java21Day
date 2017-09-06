package java21Day;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TT {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.parse("2017-05-24 10:15:00").getTime() - 8*60*60*1000);
        System.out.println(format.parse("2017-05-27 17:17:00").getTime() - 8*60*60*1000);
       
/*        System.out.println(format.parse("2017-05-26 08:00:00").getTime());
        System.out.println(format.parse("2017-05-26 08:30:00").getTime());*/
        
        System.out.println(format.format(new Date(1495563300000l)));
        System.out.println(format.format(new Date(1495847820000l)));
    }
}



/*String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
.format(new java.util.Date(1495674900000L* 1000));
System.out.println(date);*/