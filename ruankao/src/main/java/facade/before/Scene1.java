package facade.before;

public class Scene1 {
    static void main(String[] args) {
        TecDep tecDep = new TecDep();
        FinDep finDep = new FinDep();
        PersonDep personDep = new PersonDep();

        tecDep.doWork();
        finDep.doWork();
        ;
        personDep.doWork();
    }
}
