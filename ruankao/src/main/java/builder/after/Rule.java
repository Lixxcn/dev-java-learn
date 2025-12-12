package builder.after;

public class Rule {
    private Integer ownerType = 0;//0：普通 1：包月 2：免费
    private String ownerName = null;
    private String plate = null;
    private Boolean isWeekDays = true;
    private Boolean isInGarage = false;
    private String startTime = null;
    private String endTime = null;
    private Integer deadLine = 0;

    public Rule(Builder builder)
    {
        this.ownerType = builder.ownerType;
        this.ownerName = builder.ownerName;
        this.plate = builder.plate;
        this.isWeekDays = builder.isWeekDays;
        this.isInGarage = builder.isInGarage;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.deadLine = builder.deadLine;
    }

    public static class Builder
    {
        Integer ownerType = 0;
        String ownerName = null;
        String plate = null;
        Boolean isWeekDays = true;
        Boolean isInGarage = false;
        String startTime = null;
        String endTime = null;
        Integer deadLine = 0;

        public Builder(Integer _ownerType)
        {
            this.ownerType = _ownerType;
        }

        public Builder SetOwnerName(String _ownerName)
        {
            this.ownerName = _ownerName;
            return this;
        }

        public Builder SetPlate(String _plate)
        {
            this.plate = _plate;
            return this;
        }

        public Builder SetIsWeekDays(Boolean _isWeekDays)
        {
            this.isWeekDays = _isWeekDays;
            return this;
        }

        public Builder SetIsInGarage(Boolean _isInGarage)
        {
            this.isInGarage = _isInGarage;
            return this;
        }

        public Builder SetStartTime(String _startTime)
        {
            this.startTime = _startTime;
            return this;
        }

        public Builder SetEndTime(String _endTime)
        {
            this.endTime = _endTime;
            return this;
        }

        public Builder SetDeadLine(Integer _deadLine)
        {
            this.deadLine = _deadLine;
            return this;
        }

        public Rule Build()
        {
            return new Rule(this);
        }
    }

    public Float CalculateCost()
    {
        //按条件计算费用
        return 0f;
    }
}
