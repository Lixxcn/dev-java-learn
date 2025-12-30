package cn.lixx.designpatterns.chainofresponsibility;

/**
 * Concrete Handler: General Manager (总经理)
 * Handles leave requests for >= 10 days and < 30 days.
 * Rejects requests for >= 30 days.
 */
public class GeneralManager extends Leader {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() >= 10 && request.getLeaveDays() < 30) {
            System.out.println("General Manager " + name + " approved leave for " + request.getEmployeeName() + 
                               " (Days: " + request.getLeaveDays() + ", Reason: " + request.getReason() + ")");
        } else if (request.getLeaveDays() >= 30) {
            System.out.println("General Manager " + name + " REJECTED leave for " + request.getEmployeeName() + 
                               " (Days: " + request.getLeaveDays() + ", Reason: " + request.getReason() + ")");
            System.out.println("Reason: Leave duration exceeds the maximum limit of 30 days.");
        } else {
            // Should usually not reach here if the chain is set up correctly for < 10 days, 
            // but for safety, pass it on or do nothing.
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
