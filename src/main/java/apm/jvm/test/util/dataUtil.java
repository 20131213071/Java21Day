package apm.jvm.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Administrator on 2017/8/29.
 */
public class dataUtil {
    /*
    * 格式化获取当前系统时间
    * param formate:yyyy-MM-dd HH:mm:ss
    * */
    public void getCurrentDate(String formate){
        //设置日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formate);
        //输出当前时间
        System.out.println(simpleDateFormat.format(new Date()));
    }
    /*
    * 时间戳/当前时间转换，timestamp：1473048265——>2016-09-05 16:06:42
    *
    * */
    public void switchDate(String formate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formate);
        Long time = new Long(1234568);
        String currentdate = "2017-08-29 15:28:38";
        try{
            Date date = simpleDateFormat.parse(currentdate);
            System.out.println("获取的时间戳为："+date.getTime());//ms level

            String currenttime = simpleDateFormat.format(time);
            System.out.println("当前时间戳转换为："+currenttime);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        dataUtil dataUtil = new dataUtil();
        dataUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss");
        dataUtil.switchDate("yyyy-MM-dd HH:mm:ss");
    }

}
