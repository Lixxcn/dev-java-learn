package cn.lixx.designpatterns.abstractfactory.fastfactory;

import cn.lixx.designpatterns.abstractfactory.service.AbstractFactory;
import cn.lixx.designpatterns.abstractfactory.service.HtmlDocument;
import cn.lixx.designpatterns.abstractfactory.service.WordDocument;

public class FastFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new FastHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new FastWordDocument(md);
	}
}
