package chain.after;

public class HeavySword extends Sword {
    public HeavySword(DuguQuiBai _duguQuiBai) {
        super(_duguQuiBai);
        this.swordName="重剑";
        this.swordEffect="无锋，大巧不工";
    }

    public void swordStory()
    {
        if(this.duGuQuiBai.getAge()>30 && this.duGuQuiBai.getAge()<=40)
        {
            super.swordStory();
        }
        else if(this.next!=null)
        {
            this.next.swordStory();
        }
        else
        {
            return;
        }
    }
}
