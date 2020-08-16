package com.abcnull.pageobject.data;

import java.util.HashMap;
import java.util.Map;

/**
 * 百度页面的接口数据
 *
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/15 23:36
 */
public class BaiduData {
    /**
     * 百度搜索接口
     */
    public final static Map<String, String> searchRequest = new HashMap<String, String>() {
        {
            put("api", "/s");
            put("body", "ie=utf-8&mod=1&isbd=1&isid=c14f7efd0006907e&ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=%E4%BD%A0%E5%A5%BD%E5%90%97&oq=%25E4%25BD%25A0%25E5%25A5%25BD%25E5%2590%2597&rsv_pq=c14f7efd0006907e&rsv_t=633bCupruvuTqq5a%2FIeNgLydu%2FX6jxUKyqoSFEO33a9vYo%2FYr7LuXdcdFew&rqlang=cn&rsv_enter=0&rsv_dl=tb&rsv_btype=t&rsv_sug=1&bs=%E4%BD%A0%E5%A5%BD%E5%90%97&rsv_sid=undefined&_ss=1&clist=&hsug=&f4s=1&csor=3&_cr1=30144");
        }
    };
}
