package chain.before;

public class Client {
    static void main(String[] args) {
        DuguQuiBai duguQuiBai = new DuguQuiBai();
        duguQuiBai.setAge(28);
        Integer age = duguQuiBai.getAge();

        if (age <= 15) {
            UnknownSword unknownSowrd = new UnknownSword(duguQuiBai);
            unknownSowrd.swordStory();
        } else if (age > 15 && age <= 30) {
            SoftSword softSword = new SoftSword(duguQuiBai);
            softSword.swordStory();
        } else if (age > 30 && age <= 40) {
            HeavySword heavySword = new HeavySword(duguQuiBai);
            heavySword.swordStory();
        } else {
            WoodenSword woodenSowrd = new WoodenSword(duguQuiBai);
            woodenSowrd.swordStory();
        }
    }

}
