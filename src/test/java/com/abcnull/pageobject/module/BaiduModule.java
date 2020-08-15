package com.abcnull.pageobject.module;

import com.abcnull.basepage.BaseModule;
import io.restassured.response.Response;

import static com.abcnull.pageobject.data.BaiduData.searchRequest;
import static io.restassured.RestAssured.given;

/**
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/15 23:36
 */
public class BaiduModule extends BaseModule {

    public BaiduModule(String token) {
        super(token);
    }

    /**
     * 百度搜索的接口
     */
    public Response search() {
        return given().when()
                .contentType("application/json")
                .body(searchRequest.get("body"))
                .post("https://www.baidu.com" + searchRequest.get("api") + "?access_token=" + token)
                .then().log().body()
                .extract().response();
    }
}
