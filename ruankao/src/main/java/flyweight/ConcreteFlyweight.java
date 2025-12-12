package flyweight;

public class ConcreteFlyweight {
    private String alarmName="";
    public String getAlarmName()
    {
        return this.alarmName;
    }
    public void setAlarmName(String _alarmName)
    {
        this.alarmName=_alarmName;
    }

    private String alarmType="";
    public String getAlarmType()
    {
        return this.alarmType;
    }
    public void setAlarmType(String _alarmType)
    {
        this.alarmType=_alarmType;
    }

    private String alarmDesc="";
    public String getAlarmDesc()
    {
        return this.alarmDesc;
    }
    public void setAlarmDesc(String _alarmDesc)
    {
        this.alarmDesc=_alarmDesc;
    }
}
