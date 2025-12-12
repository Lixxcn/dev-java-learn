package flyweight;

import java.util.Date;

public class UnsharedConcreteFlyweight {
    private String monitorSite="";
    public String getMonitorSite()
    {
        return this.monitorSite;
    }
    public void setMonitorSite(String _monitorSite)
    {
        this.monitorSite=_monitorSite;
    }

    private String deviceNo="";
    public String getDeviceNo()
    {
        return this.deviceNo;
    }
    public void setDeviceNo(String _deviceNo)
    {
        this.deviceNo=_deviceNo;
    }

    private Date alarmTime=new Date();
    public Date getAlarmTime()
    {
        return this.alarmTime;
    }
    public void setAlarmTime(Date _date)
    {
        this.alarmTime=_date;
    }
}
