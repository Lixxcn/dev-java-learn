package cn.lixx.designpatterns.composite;

import cn.lixx.designpatterns.composite.composite.Panel;
import cn.lixx.designpatterns.composite.composite.Window;
import cn.lixx.designpatterns.composite.leaf.Button;
import cn.lixx.designpatterns.composite.leaf.CheckBox;
import cn.lixx.designpatterns.composite.leaf.Label;
import cn.lixx.designpatterns.composite.leaf.TextBox;

/**
 * 组合模式客户端测试类
 * 演示如何使用组合模式构建界面控件库
 */
public class CompositeClient {

    public static void main(String[] args) {
        System.out.println("======== Sunny软件公司界面控件库测试 ========\n");

        // ========== 示例1：简单登录窗口 ==========
        System.out.println("【示例1：简单登录窗口】");
        System.out.println("========================================");

        // 创建主窗口
        Window loginWindow = new Window("loginWnd", "用户登录", 400, 300);

        // 创建单元控件
        Label titleLabel = new Label("lblTitle", "欢迎使用系统", "16", true);
        Label userLabel = new Label("lblUser", "用户名：");
        TextBox userTextBox = new TextBox("txtUser", "请输入用户名");
        Label passLabel = new Label("lblPass", "密  码：");
        TextBox passTextBox = new TextBox("txtPass", "请输入密码");
        CheckBox rememberCheckBox = new CheckBox("chkRemember", "记住密码");
        Button loginButton = new Button("btnLogin", "登录", "80", "35");
        Button cancelButton = new Button("btnCancel", "取消", "80", "35");

        // 将控件添加到窗口中
        loginWindow.add(titleLabel);
        loginWindow.add(userLabel);
        loginWindow.add(userTextBox);
        loginWindow.add(passLabel);
        loginWindow.add(passTextBox);
        loginWindow.add(rememberCheckBox);
        loginWindow.add(loginButton);
        loginWindow.add(cancelButton);

        // 显示窗口
        loginWindow.display();

        // 模拟操作
        System.out.println("\n>>> 模拟用户操作:");
        userTextBox.setValue("admin");
        passTextBox.setValue("123456");
        rememberCheckBox.setChecked(true);
        loginButton.click();

        System.out.println("\n\n");

        // ========== 示例2：复杂的注册窗口（使用面板） ==========
        System.out.println("【示例2：复杂注册窗口（包含面板）】");
        System.out.println("========================================");

        // 创建主窗口
        Window registerWindow = new Window("registerWnd", "用户注册", 600, 500);

        // 创建标题标签
        Label regTitleLabel = new Label("regTitle", "新用户注册", "18", true);
        registerWindow.add(regTitleLabel);

        // 创建基本信息面板
        Panel basicPanel = new Panel("panelBasic", "GridLayout");
        basicPanel.setLayout("GridLayout(2,2)");
        basicPanel.add(new Label("lblUsername", "用户名："));
        basicPanel.add(new TextBox("txtUsername", "请输入用户名"));
        basicPanel.add(new Label("lblEmail", "邮箱："));
        basicPanel.add(new TextBox("txtEmail", "请输入邮箱"));
        basicPanel.add(new Label("lblPhone", "手机号："));
        basicPanel.add(new TextBox("txtPhone", "请输入手机号"));

        // 创建密码面板
        Panel passwordPanel = new Panel("panelPassword", "GridLayout");
        passwordPanel.add(new Label("lblPassword", "设置密码："));
        passwordPanel.add(new TextBox("txtPassword", "请输入密码"));
        passwordPanel.add(new Label("lblConfirm", "确认密码："));
        passwordPanel.add(new TextBox("txtConfirm", "请再次输入密码"));

        // 创建选项面板
        Panel optionsPanel = new Panel("panelOptions", "Vertical");
        optionsPanel.add(new CheckBox("chkAgree", "我已阅读并同意用户协议"));
        optionsPanel.add(new CheckBox("chkSubscribe", "订阅新闻邮件"));

        // 创建按钮面板
        Panel buttonPanel = new Panel("panelButtons", "Horizontal");
        buttonPanel.add(new Button("btnSubmit", "提交注册", "100", "40"));
        buttonPanel.add(new Button("btnReset", "重置", "100", "40"));

        // 将所有面板添加到窗口
        registerWindow.add(basicPanel);
        registerWindow.add(passwordPanel);
        registerWindow.add(optionsPanel);
        registerWindow.add(buttonPanel);

        // 显示窗口
        registerWindow.display();

        System.out.println("\n>>> 窗口层级结构:");
        displayTreeStructure(registerWindow, 0);

        System.out.println("\n\n");

        // ========== 示例3：演示组合模式的一致性 ==========
        System.out.println("【示例3：演示组合模式的一致性】");
        System.out.println("========================================");
        System.out.println("\n组合模式的核心优势：");
        System.out.println("1. 客户端可以一致地处理单个对象和组合对象");
        System.out.println("2. 不需要关心处理的是叶子控件还是容器控件");

        System.out.println("\n演示：统一处理控件列表");

        // 创建一个包含各种控件的列表
        Component[] controls = {
                new Button("单独按钮", "点击我"),
                new Label("单独标签", "这是一个标签"),
                new TextBox("单独文本框", "输入内容"),
                new Panel("单独面板", "Flow"),
                new Window("单独窗口", "独立窗口", 300, 200)
        };

        System.out.println("\n统一调用display()方法：");
        for (Component control : controls) {
            System.out.println("\n--- 控件: " + control.getName() + " ---");
            control.display(); // 统一调用，无需区分类型
        }

        System.out.println("\n\n");

        // ========== 示例4：递归遍历控件树 ==========
        System.out.println("【示例4：递归遍历控件树】");
        System.out.println("========================================");

        Window complexWindow = new Window("complexWnd", "复杂窗口示例", 800, 600);

        // 添加一些控件
        complexWindow.add(new Label("lbl1", "标签1"));
        complexWindow.add(new Button("btn1", "按钮1"));

        Panel panel1 = new Panel("panel1", "Vertical");
        panel1.add(new TextBox("txt1", "文本框1"));
        panel1.add(new CheckBox("chk1", "选项1"));

        Panel panel2 = new Panel("panel2", "Horizontal");
        panel2.add(new Button("btn2", "按钮2"));
        panel2.add(new Button("btn3", "按钮3"));

        Panel panel3 = new Panel("panel3", "Grid");
        panel3.add(new Label("lbl2", "标签2"));
        panel3.add(new TextBox("txt2", "文本框2"));

        // 组合面板
        panel1.add(panel2);
        panel2.add(panel3);
        complexWindow.add(panel1);

        System.out.println("\n完整控件树结构：");
        complexWindow.display();

        System.out.println("\n统计信息：");
        System.out.println("总控件数: " + countControls(complexWindow));
        System.out.println("其中容器控件数: " + countContainers(complexWindow));
        System.out.println("其中单元控件数: " + countLeaves(complexWindow));

        // ========== 总结 ==========
        System.out.println("\n\n【总结】");
        System.out.println("========================================");
        System.out.println("组合模式的优势：");
        System.out.println("1. 定义了包含基本对象和组合对象的类层次结构");
        System.out.println("2. 简化了客户端代码，客户端可以一致地使用组合结构和单个对象");
        System.out.println("3. 使得更容易添加新类型的组件（新增叶子或容器）");
        System.out.println("4. 使设计更加通用，符合开闭原则");
        System.out.println("5. 递归构建树形结构，表示'部分-整体'的层次结构");
    }

    /**
     * 显示控件的树形结构
     * 
     * @param component 控件
     * @param level     缩进级别
     */
    private static void displayTreeStructure(Component component, int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("  ");
        }

        String type = component instanceof cn.lixx.designpatterns.composite.composite.Panel ? "面板"
                : component instanceof Window ? "窗口" : "控件";

        System.out.println(indent + "├─ [" + type + "] " + component.getName());

        if (component instanceof Window || component instanceof cn.lixx.designpatterns.composite.composite.Panel) {
            for (Component child : component.getChildren()) {
                displayTreeStructure(child, level + 1);
            }
        }
    }

    /**
     * 统计控件总数
     * 
     * @param component 根控件
     * @return 控件总数
     */
    private static int countControls(Component component) {
        int count = 1; // 计数当前控件
        if (component.getChildren() != null) {
            for (Component child : component.getChildren()) {
                count += countControls(child);
            }
        }
        return count;
    }

    /**
     * 统计容器控件数
     * 
     * @param component 根控件
     * @return 容器控件数
     */
    private static int countContainers(Component component) {
        int count = 0;
        if (component instanceof Window || component instanceof Panel) {
            count = 1;
            if (component.getChildren() != null) {
                for (Component child : component.getChildren()) {
                    count += countContainers(child);
                }
            }
        }
        return count;
    }

    /**
     * 统计叶子控件数
     * 
     * @param component 根控件
     * @return 叶子控件数
     */
    private static int countLeaves(Component component) {
        int count = 0;
        if (!(component instanceof Window) && !(component instanceof Panel)) {
            count = 1;
        } else if (component.getChildren() != null) {
            for (Component child : component.getChildren()) {
                count += countLeaves(child);
            }
        }
        return count;
    }
}