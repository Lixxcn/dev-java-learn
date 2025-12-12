package composite;

public class Leaf extends Component{

    @Override
    public void operation() {
        System.out.println("我是："+super.getName());
    }
}
