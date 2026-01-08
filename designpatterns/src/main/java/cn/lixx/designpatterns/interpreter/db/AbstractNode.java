package cn.lixx.designpatterns.interpreter.db;

/**
 * 抽象表达式
 */
public interface AbstractNode {
    String interpret(DBContext context);
}