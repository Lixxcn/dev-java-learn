package cn.lixx.designpatterns.interpreter;

public class InterpreterClient {
    public static void main(String[] args) {
        String statement = "a + b - c";
        
        // 1. Create Context
        Context ctx = new Context();
        ctx.assign("a", 100);
        ctx.assign("b", 20);
        ctx.assign("c", 40);

        // 2. Parse and Build AST
        Calculator calculator = new Calculator();
        calculator.build(statement);

        // 3. Interpret
        int result = calculator.compute(ctx);

        System.out.println("Statement: " + statement);
        System.out.println("Result: " + result); // Expect 80
    }
}
