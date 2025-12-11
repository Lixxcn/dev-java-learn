package cn.lixx.designpatterns.abstractfactory;

import java.io.IOException;
import java.nio.file.Paths;

import cn.lixx.designpatterns.abstractfactory.fastfactory.FastFactory;
import cn.lixx.designpatterns.abstractfactory.goodfactory.GoodFactory;
import cn.lixx.designpatterns.abstractfactory.service.AbstractFactory;
import cn.lixx.designpatterns.abstractfactory.service.HtmlDocument;
import cn.lixx.designpatterns.abstractfactory.service.WordDocument;

/**
 * Learn Java from https://liaoxuefeng.com/books/java/design-patterns/creational/abstract-factory/index.html
 * 
 * 抽象工厂模式实现的关键点是定义工厂接口和产品接口，
 * 但如何实现工厂与产品本身需要留给具体的子类实现，
 * 客户端只和抽象工厂与抽象产品打交道。
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws IOException {
		AbstractFactory fastFactory = new FastFactory();
		HtmlDocument fastHtml = fastFactory.createHtml("#Hello\nHello, world!");
		System.out.println(fastHtml.toHtml());
		fastHtml.save(Paths.get("./liaoxuefeng/src/main/java/cn/lixx/designpatterns/abstractfactory/output", "fast.html"));
		WordDocument fastWord = fastFactory.createWord("#Hello\nHello, world!");
		fastWord.save(Paths.get("./liaoxuefeng/src/main/java/cn/lixx/designpatterns/abstractfactory/output", "fast.doc"));

		AbstractFactory goodFactory = new GoodFactory();
		HtmlDocument goodHtml = goodFactory.createHtml("#Hello\nHello, world!");
		System.out.println(goodHtml.toHtml());
		goodHtml.save(Paths.get("./liaoxuefeng/src/main/java/cn/lixx/designpatterns/abstractfactory/output", "good.html"));
		WordDocument goodWord = goodFactory.createWord("#Hello\nHello, world!");
		goodWord.save(Paths.get("./liaoxuefeng/src/main/java/cn/lixx/designpatterns/abstractfactory/output", "good.doc"));
	}
}
