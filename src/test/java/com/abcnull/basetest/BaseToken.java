package com.abcnull.basetest;

import static io.restassured.RestAssured.given;

/**
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/15 18:32
 */
public class BaseToken {
    /**
     * 登录后身份信息
     */
    private String token;

    /**
     * 产生登录身份信息的接口
     */
    private final String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";

    /**
     * 用于产生 token 的方法
     *
     * @param str 请求参数的数组形式
     * @return token
     */
    public String login(CharSequence... str) {
        if (str.length < 2) {
            throw new RuntimeException("产生 token 的接口中传参不全！");
        }
        token = given().when()
                .param("corpid", str[0])
                .param("corpsecret", str[1])
                .get(url)
                .then()
                .log().body()
                .extract()
                .response()
                .path("access_token");
        return token;
    }

    /**
     * 释放 token 资源
     */
    public void releaseToken() {
        if (token != null) {
            token = null;
        }
    }
}
