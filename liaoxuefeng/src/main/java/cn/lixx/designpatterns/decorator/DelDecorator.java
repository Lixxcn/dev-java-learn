package cn.lixx.designpatterns.decorator;

public class DelDecorator extends NodeDecorator {
    public DelDecorator(TextNode target) {
        super(target);
    }

    public String getText() {
        return "<del>" + target.getText() + "</del>";
    }
}
