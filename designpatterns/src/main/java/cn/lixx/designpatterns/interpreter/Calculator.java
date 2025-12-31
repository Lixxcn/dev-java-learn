package cn.lixx.designpatterns.interpreter;

import java.util.Stack;

/**
 * Calculator
 * Helper class to parse the expression string and build the Abstract Syntax
 * Tree (AST).
 * Not strictly part of the pattern, but essential for usage.
 */
public class Calculator {
    private Node expression;

    public void build(String expressionStr) {
        Node left = null;
        Node right = null;
        Stack<Node> stack = new Stack<>();

        String[] charArray = expressionStr.split(" ");

        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case "+":
                    // Pop left operand, next token is right operand
                    left = stack.pop();
                    right = new ValueNode(charArray[++i]);
                    stack.push(new AddNode(left, right));
                    break;
                case "-":
                    left = stack.pop();
                    right = new ValueNode(charArray[++i]);
                    stack.push(new SubNode(left, right));
                    break;
                default:
                    // It's a variable
                    stack.push(new ValueNode(charArray[i]));
                    break;
            }
        }
        this.expression = stack.pop();
    }

    public int compute(Context context) {
        return this.expression.interpret(context);
    }
}

/**
 * 这段代码是在解析一个类似逆波兰表达式或者特定格式的表达式。当它遇
 * 到操作符（如 + 或
 * -）时，它不仅需要处理当前的操作符，还需要立即获取下一个元素作为
 * 右操作数 (right operand)。
 * 
 * 1. 消耗下一个元素：++i 会先将 i 加 1，然后读取 charArray
 * 中的下一个字符串作为右操作数。
 * 2. 跳过下一次循环：因为 i 已经被加了
 * 1（指向了右操作数的位置），当 switch 语句结束，for 循环执行
 * i++ 后，i 就会指向右操作数之后的下一个元素。
 * 
 * 如果不这样做，下一次循环时 i
 * 就会指向那个已经被作为“右操作数”消耗掉的数字/变量，导致重复处理
 * 或逻辑错误。
 * 
 * 举个例子：
 * 假设输入字符串是 "a + b"，分割后数组为 ["a", "+", "b"]。
 * 
 * 1. i=0: 读取 "a"，走 default 分支，压入栈。循环结束 i 变为 1。
 * 2. i=1: 读取 "+", 走 case "+" 分支。
 * left 弹出 "a"。
 * 执行 right = new ValueNode(charArray[++i]);。这里 ++i 让
 * i 变成了 2，并且读到了 "b"。
 * 将结果压入栈。
 * 3. 循环继续: for 循环执行 i++，i 变为 3。
 * 4. 循环条件检查: 3 < 3 为 false，循环结束。
 * 
 * 如果没有那个 ++i，循环会在下一轮处理
 * "b"，把它当成一个新的变量再次压入栈，这显然是不对的。
 * 
 * 注意风险：
 * 这种写法虽然巧妙，但如果表达式格式不正确（例如以操作符结尾，如
 * "a +"），++i 会导致 ArrayIndexOutOfBoundsException。
 */