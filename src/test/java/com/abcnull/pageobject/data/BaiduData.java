package com.abcnull.pageobject.data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/15 23:36
 */
public class BaiduData {
    public final static Map<String, String> searchRequest = new HashMap<>();

    public static void initMap() {
        searchRequest.put("api", "");
        searchRequest.put("body", "");
    }
}
