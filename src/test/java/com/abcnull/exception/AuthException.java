package com.abcnull.exception;

/**
 * 身份认证的接口请求异常
 *
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/17 11:00
 */
public class AuthException extends RuntimeException {
    /**
     * 构造器
     */
    public AuthException() {
        super();
    }

    /**
     * 有参构造器
     *
     * @param str 异常信息
     */
    public AuthException(String str) {
        super(str);
    }
}
