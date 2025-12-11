package cn.lixx.designpatterns.composite;

import cn.lixx.designpatterns.composite.node.CommentNode;
import cn.lixx.designpatterns.composite.node.ElementNode;
import cn.lixx.designpatterns.composite.node.Node;
import cn.lixx.designpatterns.composite.node.TextNode;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		Node root = new ElementNode("school");
		root.add(new ElementNode("classA").add(new TextNode("Tom")).add(new TextNode("Alice")));
		root.add(new ElementNode("classB").add(new TextNode("Bob")).add(new TextNode("Grace"))
				.add(new CommentNode("comment...")));
		System.out.println(root.toXml());
	}
}
