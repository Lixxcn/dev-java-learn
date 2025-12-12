package decorator.after;

public class AmbitiousFeeling extends Decorator{

    public AmbitiousFeeling(Human _human)
    {
        super(_human);
    }

    private void ambitiousFeeling()
    {
        System.out.println("烈士暮年，壮心不已！");
    }

    protected void feeling()
    {
        super.feeling();
        this.ambitiousFeeling();
    }

}
