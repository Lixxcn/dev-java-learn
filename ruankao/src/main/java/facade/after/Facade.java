package facade.after;

public class Facade {

    private static AdmDep admDep=new AdmDep();
    private static FinDep finDep=new FinDep();
    private static PersonDep personDep=new PersonDep();
    private static SaleDep saleDep=new SaleDep();
    private static TecDep tecDep=new TecDep();


    public static void tecCost()
    {
        tecDep.doWork();
        finDep.doWork();
        personDep.doWork();
    }

    public static void salePerformance()
    {
        saleDep.doWork();
        personDep.doWork();
    }

    public static void nonProductDep()
    {
        admDep.doWork();
        finDep.doWork();
        personDep.doWork();
    }
}
