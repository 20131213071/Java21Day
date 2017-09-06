package apm.jvm.test.service;


import apm.jvm.test.vo.JVMInfo;
import com.sun.management.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.*;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.util.List;

/**
 * JVM test
 * Created by smx on 2017/8/29.
 */
public class JvmService {
    public static final Logger logger = LoggerFactory.getLogger(JvmService.class);
    JVMInfo jvmInfo = new JVMInfo();

    public  JVMInfo getJVMInfo(){
        try{
            //获取JVM启动时间，版本，名称，当前PDI
            RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
            jvmInfo.setJvmName(runtimeMXBean.getName());
            jvmInfo.setJvmStartTime(runtimeMXBean.getStartTime());
            jvmInfo.setProcessId(runtimeMXBean.getName().split("@")[0]);
            //获取JVM内存使用状况，包括堆内存和非堆内存
            MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
            jvmInfo.setHeapMemoryUsage(memoryMXBean.getHeapMemoryUsage());
            jvmInfo.setNonHeapMemoryUsage(memoryMXBean.getNonHeapMemoryUsage());
            //堆内使用率，堆外使用率
            MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
            memoryUsage.getInit();
            memoryUsage.getMax();
            memoryUsage.getUsed();
            //操作系统及硬件信息：系统名称、版本，CPU内核，机器总内存、可用内存、可用内存占比
            OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
            jvmInfo.setOsName(operatingSystemMXBean.getName());
            jvmInfo.setOsVersion(operatingSystemMXBean.getVersion());
            jvmInfo.setProcessors(operatingSystemMXBean.getAvailableProcessors());
            //获取运行时内存情况
            jvmInfo.setTotalPhysicalMenory(Runtime.getRuntime().totalMemory()/(1024*1024*1024));
            jvmInfo.setFreePhysicalMenory(Runtime.getRuntime().freeMemory());
            jvmInfo.setMaxPhysicalMenory(Runtime.getRuntime().maxMemory());
            //获取GC的次数以及花费时间之类的信息
            List<GarbageCollectorMXBean> garbageCollectorMXBean =ManagementFactory.getGarbageCollectorMXBeans();
            for(GarbageCollectorMXBean GB :garbageCollectorMXBean){
                GB.getCollectionCount();
                GB.getCollectionTime();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return  jvmInfo;
    }


}
