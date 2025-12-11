package cn.lixx.designpatterns.builder.html;

public class ParagraphBuilder {

	public String buildParagraph(String line) {
		return "<p>" + line + "</p>";
	}
}
