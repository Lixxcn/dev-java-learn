package chain.before;

public abstract class Sword {
    protected String swordName="";
    protected String swordEffect="";

    private DuguQuiBai duGuQuiBai=null;

    public Sword(DuguQuiBai _duguQuiBai)
    {
        this.duGuQuiBai=_duguQuiBai;
    }

    public void swordStory()
    {
        System.out.println(this.duGuQuiBai.getName());
        System.out.println(this.duGuQuiBai.getAge());
        System.out.println(this.swordName);
        System.out.println(this.swordEffect);
    }
}
