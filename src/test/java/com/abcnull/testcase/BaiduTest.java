package com.abcnull.testcase;

import com.abcnull.basetest.BaseTest;
import com.abcnull.pageobject.module.BaiduModule;
import org.testng.annotations.Test;

/**
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/15 23:38
 */
public class BaiduTest extends BaseTest {
    private BaiduModule baiduModule;

    @Test
    public void testSearch() {
        baiduModule = new BaiduModule(token);
        baiduModule.search();
    }

    @Test
    public void testOther() {
        // todo : 测试其他接口
    }
}
