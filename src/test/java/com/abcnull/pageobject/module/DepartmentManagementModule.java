package com.abcnull.pageobject.module;

import com.abcnull.basepage.BaseModule;
import io.restassured.response.Response;

import static com.abcnull.pageobject.data.DepartmentManagementData.createDepartmentRequest;
import static com.abcnull.pageobject.data.DepartmentManagementData.deleteDepartmentRequest;
import static io.restassured.RestAssured.given;

/**
 * 部门管理模块-接口操作
 *
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/15 19:29
 */
public class DepartmentManagementModule extends BaseModule {

    /**
     * 构造器
     *
     * @param token 身份信息
     */
    public DepartmentManagementModule(String token) {
        super(token);
    }

    /**
     * 企业微信创建部门
     *
     * @return Response
     */
    public Response createDepartment() {
        return given().when()
                .contentType("application/json")
                .body(createDepartmentRequest.get("body"))
                .post(hostUrl + createDepartmentRequest.get("api") + "?access_token=" + token)
                .then().log().body()
                .extract().response();
    }

    /**
     * 企业微信删除部门
     *
     * @return Response
     */
    public Response deleteDepartment() {
        return given().when()
                .contentType("application/json")
                .body(deleteDepartmentRequest.get("body"))
                .get(hostUrl + deleteDepartmentRequest.get("api") + "?access_token=" + token + "&" + deleteDepartmentRequest.get("body"))
                .then().log().body()
                .extract().response();
    }
}
