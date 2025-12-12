package chain.after;

public class Client {
    static void main(String[] args) {
        DuguQuiBai duguQUiBai = new DuguQuiBai();
        duguQUiBai.setAge(35);

        UnknownSword unknown = new UnknownSword(duguQUiBai);
        SoftSword soft = new SoftSword(duguQUiBai);
        HeavySword heavy = new HeavySword(duguQUiBai);
        WoodenSword wooden = new WoodenSword(duguQUiBai);

        unknown.setNext(soft);
        soft.setNext(heavy);
        heavy.setNext(wooden);

        unknown.swordStory();
    }

}
