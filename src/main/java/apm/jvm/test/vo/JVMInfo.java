package apm.jvm.test.vo;

import java.io.Serializable;
import java.lang.management.MemoryUsage;

/**
 * Created by smx on 2017/8/29.
 * //定义序列化(object)
 */
public class JVMInfo implements Serializable {
    //serialVersionUID作用是序列化时保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
    private static final long  serialVersionUID = 7593745554626593803L;
    /**
     * JVM 启动时间
     */
    private Long jvmStartTime;
    /**
     * JVM 版本信息
     */
    private String jvmVersion;
    /**
     * jvm名称
     */
    private String jvmName;
    /**
     * 当前线程ID
     */
    private String processId;
    /**
     * 非堆内存使用情况(MB)
     */
    private MemoryUsage nonHeapMemoryUsage;
    /**
     * 堆内存使用情况(MB)
     */
    private MemoryUsage heapMemoryUsage;
    /**
     * 操作系统名称
     */
    private String osName;
    /**
     * 操作系统版本
     */
    private String osVersion;
    /**
     * Java 虚拟机中的内存总量(byte)
     */
    private long totalPhysicalMenory;
    /**
     * Java 虚拟机中可用内存总量(byte)
     */
    private long freePhysicalMenory;

    public long getMaxPhysicalMenory() {
        return MaxPhysicalMenory;
    }

    public void setMaxPhysicalMenory(long maxPhysicalMenory) {
        MaxPhysicalMenory = maxPhysicalMenory;
    }

    /**
     * Java 虚拟机中最大可用内存总量(byte)
     */
    private long MaxPhysicalMenory;
    /**
     * 机器可用内存比例
     */
    private String freePhysicalMenoryRatio;

    public Long getJvmStartTime() {
        return jvmStartTime;
    }

    public void setJvmStartTime(Long jvmStartTime) {
        this.jvmStartTime = jvmStartTime;
    }

    public String getJvmVersion() {
        return jvmVersion;
    }

    public void setJvmVersion(String jvmVersion) {
        this.jvmVersion = jvmVersion;
    }

    public String getJvmName() {
        return jvmName;
    }

    public void setJvmName(String jvmName) {
        this.jvmName = jvmName;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public MemoryUsage getNonHeapMemoryUsage() {
        return nonHeapMemoryUsage;
    }

    public void setNonHeapMemoryUsage(MemoryUsage nonHeapMemoryUsage) {
        this.nonHeapMemoryUsage = nonHeapMemoryUsage;
    }

    public MemoryUsage getHeapMemoryUsage() {
        return heapMemoryUsage;
    }

    public void setHeapMemoryUsage(MemoryUsage heapMemoryUsage) {
        this.heapMemoryUsage = heapMemoryUsage;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public long getTotalPhysicalMenory() {
        return totalPhysicalMenory;
    }

    public void setTotalPhysicalMenory(long totalPhysicalMenory) {
        this.totalPhysicalMenory = totalPhysicalMenory;
    }

    public long getFreePhysicalMenory() {
        return freePhysicalMenory;
    }

    public void setFreePhysicalMenory(long freePhysicalMenory) {
        this.freePhysicalMenory = freePhysicalMenory;
    }

    public String getFreePhysicalMenoryRatio() {
        return freePhysicalMenoryRatio;
    }

    public void setFreePhysicalMenoryRatio(String freePhysicalMenoryRatio) {
        this.freePhysicalMenoryRatio = freePhysicalMenoryRatio;
    }

    public int getProcessors() {
        return processors;
    }

    public void setProcessors(int processors) {
        this.processors = processors;
    }

    public String getSystemUpTime() {
        return systemUpTime;
    }

    public void setSystemUpTime(String systemUpTime) {
        this.systemUpTime = systemUpTime;
    }

    /**
     * CPU内核
     */
    private int processors;

    private String systemUpTime;
}
