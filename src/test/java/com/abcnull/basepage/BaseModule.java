package com.abcnull.basepage;

import com.abcnull.util.PropertiesReader;

/**
 * 测试模块基础类
 *
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/15 11:21
 */
public class BaseModule {
    /**
     * token
     */
    public String token;

    /**
     * 网页前缀
     */
    public final String hostUrl = PropertiesReader.getKey("serverName");

    /**
     * 有参构造器
     *
     * @param token 身份信息
     */
    public BaseModule(String token) {
        this.token = token;
    }

    /**
     * 无参构造器
     */
    public BaseModule() {
    }
}
