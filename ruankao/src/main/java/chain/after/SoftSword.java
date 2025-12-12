package chain.after;

public class SoftSword extends Sword {
    public SoftSword(DuguQuiBai _duguQuiBai) {
        super(_duguQuiBai);
        this.swordName="紫薇软剑";
        this.swordEffect="三十岁前所用，误伤义不祥";
    }

    public void swordStory()
    {
        if(this.duGuQuiBai.getAge()>15 && this.duGuQuiBai.getAge()<=30)
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
