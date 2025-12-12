package prototype.after;

public class LiuZongYuan implements Cloneable {
    private int no=0;

    public int getNo()
    {
        return this.no;
    }

    public void setNo(int _no)
    {
        this.no=_no;
    }

    @Override
    public LiuZongYuan clone() throws CloneNotSupportedException {
        LiuZongYuan liuZongYuan=null;
        try {
            liuZongYuan=(LiuZongYuan)super.clone();
        }catch (CloneNotSupportedException e)
        {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return liuZongYuan;
    }

    public void wacthHome()
    {
        System.out.println("第"+String.valueOf(this.no)+"号柳宗元在望故乡");
    }
}
