package com.abcnull.pageobject.module;

import com.abcnull.basepage.BaseModule;
import io.restassured.response.Response;

import static com.abcnull.pageobject.data.BaiduData.searchRequest;
import static io.restassured.RestAssured.given;

/**
 * 百度接口操作
 *
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/15 23:36
 */
public class BaiduModule extends BaseModule {
    /**
     * 有参构造器
     *
     * @param token 身份信息
     */
    public BaiduModule(String token) {
        super(token);
    }

    /**
     * 无参构造器
     */
    public BaiduModule() {
        super();
    }

    /**
     * 百度搜索
     *
     * @return Response
     */
    public Response search() {
        return given().when()
                .headers("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36")
                .get("https://www.baidu.com" + searchRequest.get("api") + "?" + searchRequest.get("body"))
                .then()
                .extract().response();
    }
}
