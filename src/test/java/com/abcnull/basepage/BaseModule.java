package com.abcnull.basepage;

/**
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/15 11:21
 */
public class BaseModule {

    public String token;

    /**
     * 网页前缀
     */
    public final String prefixUrl = "https://qyapi.weixin.qq.com";

    public BaseModule(String token) {
        this.token = token;
    }
}
