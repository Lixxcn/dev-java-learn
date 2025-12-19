package cn.lixx.designpatterns.simplefactory.exception;

/**
 * 不支持的图形异常
 * 当尝试创建不支持的图形时抛出
 */
public class UnSupportedShapeException extends RuntimeException {
    public UnSupportedShapeException(String message) {
        super(message);
    }

    public UnSupportedShapeException(String message, Throwable cause) {
        super(message, cause);
    }
}