package com.abcnull.testcase;

import com.abcnull.basetest.BaseTest;
import com.abcnull.pageobject.module.BaiduModule;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/15 23:38
 */
public class BaiduTest extends BaseTest {
    private BaiduModule baiduModule;

    @Test(description = "百度搜索", priority = 1)
    public void testSearch() {
        baiduModule = new BaiduModule();
        Assert.assertTrue(baiduModule.search().getBody().asString().contains("百度搜索"));
    }

    @Test(description = "其他操作", priority = 2)
    public void testOther() {
        // todo : 测试百度其他接口
    }
}
