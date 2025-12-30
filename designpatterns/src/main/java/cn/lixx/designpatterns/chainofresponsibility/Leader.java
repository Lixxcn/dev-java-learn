package cn.lixx.designpatterns.chainofresponsibility;

/**
 * Abstract Handler: Leader
 * Defines the interface for handling requests and maintains a reference to the next handler.
 */
public abstract class Leader {
    protected String name;
    protected Leader nextLeader; // Successor

    public Leader(String name) {
        this.name = name;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    /**
     * Abstract method to handle the leave request.
     * Concrete handlers must implement this.
     * @param request The leave request to handle.
     */
    public abstract void handleRequest(LeaveRequest request);
}
