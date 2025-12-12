package prototype.after;

public class Client {
    static void main(String[] args) throws CloneNotSupportedException {
        LiuZongYuan liuZongYuan = new LiuZongYuan();

        for (int i = 1; i <= 1000000000; i++) {
            LiuZongYuan liuZongYuanCloned = liuZongYuan.clone();
            liuZongYuanCloned.setNo(i);
            liuZongYuanCloned.wacthHome();
        }
    }

}
