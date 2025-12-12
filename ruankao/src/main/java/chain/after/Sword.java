package chain.after;

public abstract class Sword {
    protected String swordName="";
    protected String swordEffect="";

    protected Sword next=null;
    public Sword getNext()
    {
        return this.next;
    }
    public void setNext(Sword _sword)
    {
        this.next=_sword;
    }

    protected DuguQuiBai duGuQuiBai=null;

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
