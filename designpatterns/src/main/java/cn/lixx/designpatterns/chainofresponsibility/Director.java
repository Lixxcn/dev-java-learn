package cn.lixx.designpatterns.chainofresponsibility;

/**
 * Concrete Handler: Director (主任)
 * Handles leave requests for less than 3 days.
 */
public class Director extends Leader {

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 3) {
            System.out.println("Director " + name + " approved leave for " + request.getEmployeeName() + 
                               " (Days: " + request.getLeaveDays() + ", Reason: " + request.getReason() + ")");
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
