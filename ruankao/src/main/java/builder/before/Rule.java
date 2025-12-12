package builder.before;

public class Rule {
    Integer ownerType = 0;//0：普通 1：包月 2：免费
    String ownerName = null;
    String plate = null;
    Boolean isWeekDays = true;
    Boolean isInGarage = false;
    String startTime = null;
    String endTime = null;
    Integer deadLine = null;

    public Rule(Integer _ownerType,String _ownerName,String _plate, Boolean _isWeekDays, Boolean _isInGarage,String _staetTime,String _endTime,Integer _deadLine)
    {
        this.ownerType = _ownerType;//取值范围检查
        this.ownerName = _ownerName;
        this.plate = _plate;
        this.isWeekDays = _isWeekDays;
        this.isInGarage = _isInGarage;
        this.startTime = _staetTime;
        this.endTime = _endTime;
        this.deadLine = _deadLine;
    }

    public Float CalculateCost()
    {
        //按条件计算费用

        return 0f;
    }
}
