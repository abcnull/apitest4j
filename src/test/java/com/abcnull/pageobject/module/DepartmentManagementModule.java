package com.abcnull.pageobject.module;

import com.abcnull.basepage.BaseModule;
import io.restassured.response.Response;

import static com.abcnull.pageobject.data.DepartmentManagementData.createDepartmentRequest;
import static io.restassured.RestAssured.given;

/**
 * 部门管理模块-接口操作
 *
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/15 19:29
 */
public class DepartmentManagementModule extends BaseModule {

    public DepartmentManagementModule(String token) {
        super(token);
    }

    public Response createDepartment() {
        return given().when()
                .contentType("application/json")
                .body(createDepartmentRequest.get("body"))
                .post(prefixUrl + createDepartmentRequest.get("api") + "?access_token=" + token)
                .then().log().body()
                .extract().response();
    }
}
