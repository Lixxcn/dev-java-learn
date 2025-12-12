package decorator.after;

public class DepressedFeeling extends Decorator{

    public DepressedFeeling(Human _human) {
        super(_human);
    }

    private void depressedFeeling()
    {
        System.out.println("悲欢离合总无情。一任阶前、点滴到天明。");
    }

    protected void feeling()
    {
        super.feeling();
        this.depressedFeeling();
    }
}
