package facade.after;

import facade.before.Department;

public class TecDep implements Department {
    public void doWork()
    {
        System.out.println("本部门从事技术工作！");
    }
}
