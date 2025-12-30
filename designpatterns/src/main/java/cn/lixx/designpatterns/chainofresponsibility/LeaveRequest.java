package cn.lixx.designpatterns.chainofresponsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Leave Request Class
 * Encapsulates the details of a leave request.
 */
@Data
@AllArgsConstructor
public class LeaveRequest {
    private String employeeName;
    private int leaveDays;
    private String reason;
}
