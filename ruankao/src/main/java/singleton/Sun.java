package singleton;

class Sun {
    private static final Sun sun=new Sun();

    public static Sun getInstance()
    {
        return  sun;
    }

    public void active()
    {
        System.out.println("天无二日！！");
    }
}
