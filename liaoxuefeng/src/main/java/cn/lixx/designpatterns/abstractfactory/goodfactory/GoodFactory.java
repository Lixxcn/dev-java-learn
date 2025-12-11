package cn.lixx.designpatterns.abstractfactory.goodfactory;

import cn.lixx.designpatterns.abstractfactory.service.AbstractFactory;
import cn.lixx.designpatterns.abstractfactory.service.HtmlDocument;
import cn.lixx.designpatterns.abstractfactory.service.WordDocument;

public class GoodFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new GoodHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new GoodWordDocument(md);
	}
}
