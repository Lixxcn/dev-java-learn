package decorator.before;

class DepressedOldAge extends OldAge{
    protected void feeling()
    {
        super.feeling();
        System.out.println("悲欢离合总无情。一任阶前、点滴到天明。");
    }

}
