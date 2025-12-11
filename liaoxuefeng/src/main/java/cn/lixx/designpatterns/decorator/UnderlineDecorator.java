package cn.lixx.designpatterns.decorator;

public class UnderlineDecorator extends NodeDecorator {
    public UnderlineDecorator(TextNode target) {
        super(target);
    }

    public String getText() {
        return "<u>" + target.getText() + "</u>";
    }
}
