package com.xuecheng.manage_cms.dao;

import com.xuecheng.manage_cms.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:Mr.XiongKF
 * @Date:2019/4/21 22:26
 * Study well and make progress every day.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PageServiceTest {
    @Autowired
    PageService pageService;

    @Test
    public void test(){
        String pageHtml = pageService.getPageHtml("5ada97cb68db526124fd79c3");
        System.out.println(pageHtml);
    }
}
