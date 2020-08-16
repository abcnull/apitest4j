package com.abcnull.pageobject.data;

import java.util.HashMap;
import java.util.Map;

/**
 * 部门管理模块-接口传参
 *
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/15 19:30
 */
public class DepartmentManagementData {
    /**
     * 创建部门接口
     */
    public final static Map<String, String> createDepartmentRequest = new HashMap<String, String>() {
        {
            put("api", "/cgi-bin/department/create");
            put("body",
                    "    {\n" +
                            "       \"name\": \"广州研发中心\",\n" +
                            "       \"name_en\": \"RDGZ\",\n" +
                            "       \"parentid\": 1,\n" +
                            "       \"order\": 1,\n" +
                            "       \"id\": 2\n" +
                            "    }");
        }
    };

    /**
     * 删除部门接口
     */
    public final static Map<String, String> deleteDepartmentRequest = new HashMap<String, String>() {
        {
            put("api", "/cgi-bin/department/delete");
            put("body", "id=2");
        }
    };
}
