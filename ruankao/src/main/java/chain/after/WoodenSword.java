package chain.after;

public class WoodenSword extends Sword {
    public WoodenSword(DuguQuiBai _duguQuiBai) {
        super(_duguQuiBai);
        this.swordName="木剑";
        this.swordEffect="不滞于物，草木竹石均可为剑";
    }

    public void swordStory()
    {
        if(this.duGuQuiBai.getAge()>40)
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
