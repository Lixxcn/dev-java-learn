package chain.after;

public class UnknownSword extends Sword {
    public UnknownSword(DuguQuiBai _duguQuiBai) {
        super(_duguQuiBai);
        this.swordName="无名利剑";
        this.swordEffect="凌厉刚猛，无坚不摧";
    }

    public void swordStory()
    {
        if(this.duGuQuiBai.getAge()<=15)
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
