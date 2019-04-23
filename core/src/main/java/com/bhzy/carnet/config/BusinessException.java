package com.bhzy.carnet.config;

/**
 * 业务异常继承至RuntimeException
 * 在需要抛出RuntimeException异常时使用 
 * 可以避免和空指针异常等RuntimeException混淆
 * @author huangbin
 *
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3267678905796242558L;

	public BusinessException(String message) {
        super(message, new Throwable(message));
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
