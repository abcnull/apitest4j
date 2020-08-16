package com.abcnull.basetest;

import com.abcnull.util.PropertiesReader;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

/**
 * 产生 token 的测试基类
 *
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/15 18:32
 */
@Slf4j
public class BaseToken {
    /**
     * 登录后身份信息
     */
    private String token;

    /**
     * 用于产生 token 的方法
     *
     * @param str 请求参数的数组形式
     * @return token
     */
    public String login(CharSequence... str) {
        // 若参数小于两个
        if (str.length < 2) {
            throw new RuntimeException("产生 token 的接口中传参不全！");
        }
        // 若参数为 null 则返回 token 为 null
        if (str[0] == null || str[1] == null) {
            log.warn("token 信息为空！请检查你的 corpid 和 corpsecret 是否填写！");
            log.info("若直接运行测试类，请在 BaseTest 的 @Optional 中填写自己的默认 corpid 和 corpsecret 信息，若运行 xml 文件则需要在 testng.xml 填写自己的 corpid 和 corpsecret 以便产生属于自己的 token，鉴于安全考虑库主不会将自己的 token 信息放置于此框架中");
            return null;
        }
        // 接口请求返回 token
        token = given().when()
                .param("corpid", str[0])
                .param("corpsecret", str[1])
                .get(PropertiesReader.getKey("serverName") + PropertiesReader.getKey("tokenPath"))
                .then()
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
