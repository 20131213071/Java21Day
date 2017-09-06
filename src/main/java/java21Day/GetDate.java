package java21Day;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.DateUtil;

/**
 * @Author chenggang
 * @Date 17/4/25 下午3:22
 */

public class GetDate {
    private  static Date date=new Date();//取当前时间
    private  static Date date1=new Date();//取当前时间
    private  static Date date2=new Date();//取当前时间
    private  static Calendar c = Calendar.getInstance();
    /**
     *获取当前时间
     */
    public static Date getCurrentDate(){
        System.out.println("当前时间为:"+new Date());
        return new Date();
    }

    /**
     * 获取当前时间戳
     * @return
     */
    public static Long getCurrentTime(){
        System.out.println("当前时间戳为:"+new Date().getTime()/1000);
        return new Date().getTime()/1000;
    }

    /**
     * 当前时间之前的时间
     * @param days
     */
    public static Date getBeforeDate(int days){
        c.setTime(date1);
        c.add(c.DATE, -days);//把日期往后增加一天.整数往后推,负数往前移动
        date1=c.getTime(); //这个时间就是日期往后推一天的结果
        System.out.println("当前日期"+days+"天之前的日期:" + date1);
        return date1;
    }

    /**
     * 获取当前日期之前好多天的时间戳
     * @param days
     * @return
     */
    public static Long getBeforeDateTime(int days){
        c.setTime(date2);
        c.add(c.DATE, -days);//把日期往后增加一天.整数往后推,负数往前移动
        date2=c.getTime(); //这个时间就是日期往后推一天的结果
        System.out.println("当前日期"+days+"天之前的时间戳:" + date2.getTime()/1000);
        return date2.getTime()/1000;
    }

    public static void main(String[] args){
    	GetDate.getCurrentDate();
    	GetDate.getBeforeDate(3);
    	GetDate.getBeforeDateTime(6);
    	GetDate.getCurrentTime();
    }
}

