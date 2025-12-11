package cn.lixx.designpatterns.decorator;

public class ItalicDecorator extends NodeDecorator {
    public ItalicDecorator(TextNode target) {
        super(target);
    }

    public String getText() {
        return "<i>" + target.getText() + "</i>";
    }
}
