package cn.lixx.designpatterns.prototype;

/**
 * 原型模式客户端测试代码
 * 演示浅克隆和深克隆的区别
 */
public class PrototypeClient {
    public static void main(String[] args) {
        System.out.println("🏢 Sunny软件公司销售管理系统 - 原型模式演示");
        System.out.println("================================================\n");

        // 创建原始客户对象
        Address originalAddress = new Address("北京市", "海淀区", "中关村大街1号", "100080");
        Customer originalCustomer = new Customer("张三", 28, "13800138000", originalAddress);

        System.out.println("1. 原始客户信息:");
        System.out.println("   " + originalCustomer);
        System.out.println();

        // ========== 浅克隆测试 ==========
        System.out.println("📋 浅克隆测试:");
        System.out.println("-----------------");
        Customer shallowClone = originalCustomer.clone();

        System.out.println("克隆后 - 原对象: " + originalCustomer);
        System.out.println("克隆后 - 克隆对象: " + shallowClone);
        System.out.println("原对象和克隆对象是否相同: " + (originalCustomer == shallowClone));
        System.out.println("原对象地址和克隆对象地址是否相同: " + (originalCustomer.getAddress() == shallowClone.getAddress()));
        System.out.println("地址对象内容是否相同: " + originalCustomer.getAddress().equals(shallowClone.getAddress()));
        System.out.println();

        // 修改克隆对象的基本属性
        System.out.println("修改克隆对象的基本属性（姓名、年龄）:");
        shallowClone.setName("李四");
        shallowClone.setAge(30);
        System.out.println("原对象: " + originalCustomer);
        System.out.println("克隆对象: " + shallowClone);
        System.out.println();

        // 修改克隆对象的引用属性
        System.out.println("修改克隆对象的引用属性（地址）:");
        shallowClone.getAddress().setStreet("中关村大街2号");
        System.out.println("原对象: " + originalCustomer);
        System.out.println("克隆对象: " + shallowClone);
        System.out.println("⚠️  注意：修改克隆对象的地址，原对象的地址也被改变了！");
        System.out.println();

        // ========== 深克隆测试 ==========
        System.out.println("\n📋 深克隆测试:");
        System.out.println("-----------------");
        Customer deepClone = originalCustomer.deepClone();

        System.out.println("克隆后 - 原对象: " + originalCustomer);
        System.out.println("克隆后 - 克隆对象: " + deepClone);
        System.out.println("原对象和克隆对象是否相同: " + (originalCustomer == deepClone));
        System.out.println("原对象地址和克隆对象地址是否相同: " + (originalCustomer.getAddress() == deepClone.getAddress()));
        System.out.println("地址对象内容是否相同: " + originalCustomer.getAddress().equals(deepClone.getAddress()));
        System.out.println();

        // 修改深克隆对象
        System.out.println("修改深克隆对象的属性:");
        deepClone.setName("王五");
        deepClone.setAge(35);
        deepClone.getAddress().setStreet("中关村大街3号");
        deepClone.getAddress().setCity("朝阳区");
        System.out.println("原对象: " + originalCustomer);
        System.out.println("克隆对象: " + deepClone);
        System.out.println("✅ 注意：修改克隆对象的地址，原对象的地址未受影响！");
        System.out.println();

        // ========== 序列化深克隆测试 ==========
        System.out.println("\n📋 序列化方式深克隆测试:");
        System.out.println("-----------------");
        Customer serializationClone = originalCustomer.deepCloneBySerialization();

        System.out.println("克隆后 - 原对象: " + originalCustomer);
        System.out.println("克隆后 - 克隆对象: " + serializationClone);
        System.out.println("原对象和克隆对象是否相同: " + (originalCustomer == serializationClone));
        System.out.println("原对象地址和克隆对象地址是否相同: " + (originalCustomer.getAddress() == serializationClone.getAddress()));
        System.out.println();

        // 修改序列化克隆对象
        System.out.println("修改序列化克隆对象的属性:");
        serializationClone.setName("赵六");
        serializationClone.setAge(40);
        serializationClone.getAddress().setStreet("中关村大街4号");
        System.out.println("原对象: " + originalCustomer);
        System.out.println("克隆对象: " + serializationClone);
        System.out.println();

        // ========== 总结 ==========
        System.out.println("================================================");
        System.out.println("📚 浅克隆 vs 深克隆 对比总结:");
        System.out.println("1. 浅克隆:");
        System.out.println("   - 只复制基本数据类型和String");
        System.out.println("   - 引用类型只复制引用，共享同一个对象");
        System.out.println("   - 修改引用类型会影响原对象");
        System.out.println("   - 实现简单，性能较好");
        System.out.println("\n2. 深克隆:");
        System.out.println("   - 复制所有数据，包括引用类型的对象");
        System.out.println("   - 完全独立的对象，互不影响");
        System.out.println("   - 需要手动实现或使用序列化");
        System.out.println("   - 实现相对复杂，性能开销较大");
        System.out.println("\n3. 应用场景:");
        System.out.println("   - 浅克隆：对象结构简单，或需要共享部分数据");
        System.out.println("   - 深克隆：对象结构复杂，需要完全独立的副本");
    }
}