package cn.lixx.designpatterns.chainofresponsibility;

/**
 * Concrete Handler: Manager (经理)
 * Handles leave requests for >= 3 days and < 10 days.
 */
public class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() >= 3 && request.getLeaveDays() < 10) {
            System.out.println("Manager " + name + " approved leave for " + request.getEmployeeName() + 
                               " (Days: " + request.getLeaveDays() + ", Reason: " + request.getReason() + ")");
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
