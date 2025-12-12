package facade.before;

public class Scene2 {
    static void main(String[] args) {
        SaleDep saleDep = new SaleDep();
        PersonDep personDep = new PersonDep();

        saleDep.doWork();
        personDep.doWork();
    }

}
