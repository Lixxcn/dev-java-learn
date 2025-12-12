package composite;

public class Client {
    static void main(String[] args) {
        Leaf shengshou = new Leaf();
        shengshou.setName("吞金兽");
        shengshou.operation();
        Leaf minghua = new Leaf();
        minghua.setName("名花");
        minghua.operation();
        Leaf ruicao = new Leaf();
        ruicao.setName("瑞草");
        ruicao.operation();

        Composite palace = new Composite();
        palace.setName("36天宫");
        palace.operation();
        Composite qianyunPalace = new Composite();
        qianyunPalace.setName("遣云宫");
        qianyunPalace.operation();

        Composite hall = new Composite();
        hall.setName("72宝殿");
        hall.operation();
        Composite chaohuiHall = new Composite();
        chaohuiHall.setName("朝会殿");
        chaohuiHall.operation();

        Composite heaven = new Composite();
        heaven.setName("天庭");
        heaven.operation();

        heaven.add(palace);
        heaven.add(hall);

        palace.add(qianyunPalace);

        // palace.remove(1);
        hall.add(chaohuiHall);

        qianyunPalace.add(shengshou);
        qianyunPalace.add(minghua);
        qianyunPalace.add(ruicao);

    }

}
