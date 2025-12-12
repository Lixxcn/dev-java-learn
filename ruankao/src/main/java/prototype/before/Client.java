package prototype.before;

public class Client {
    static void main(String[] args) {
        for (int i = 1; i <= 1000000000; i++) {
            LiuZongYuan liuZongYuan = new LiuZongYuan();
            liuZongYuan.setNo(i);
            liuZongYuan.wacthHome();
        }
    }

}
