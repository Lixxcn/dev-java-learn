package cn.lixx.designpatterns.chainofresponsibility;

public class LeaveClient {
    public static void main(String[] args) {
        // 1. Create Handlers
        Leader director = new Director("Alice");
        Leader manager = new Manager("Bob");
        Leader generalManager = new GeneralManager("Charlie");

        // 2. Build the Chain of Responsibility
        // Director -> Manager -> General Manager
        director.setNextLeader(manager);
        manager.setNextLeader(generalManager);

        // 3. Create Requests
        LeaveRequest req1 = new LeaveRequest("John", 2, "Sick leave"); // Should be handled by Director
        LeaveRequest req2 = new LeaveRequest("Mary", 5, "Family trip"); // Should be handled by Manager
        LeaveRequest req3 = new LeaveRequest("Steve", 15, "Surgery recovery"); // Should be handled by GM
        LeaveRequest req4 = new LeaveRequest("David", 45, "World tour"); // Should be rejected by GM

        // 4. Process Requests
        System.out.println("--- Processing Request 1 ---");
        director.handleRequest(req1);

        System.out.println("\n--- Processing Request 2 ---");
        director.handleRequest(req2);

        System.out.println("\n--- Processing Request 3 ---");
        director.handleRequest(req3);

        System.out.println("\n--- Processing Request 4 ---");
        director.handleRequest(req4);
    }
}
