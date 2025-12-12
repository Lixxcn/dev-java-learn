package proxy;

public class Alient {
    static void main(String[] args) {
        DigitalStudent digitalStudent = new DigitalStudent(new Student());
        digitalStudent.answer("请叙述你所在星球生物进化的基本原理，是自然淘汰型还是基因突变型？");
        digitalStudent.answer("请简要说明恒星能量的来源？");

    }

}
