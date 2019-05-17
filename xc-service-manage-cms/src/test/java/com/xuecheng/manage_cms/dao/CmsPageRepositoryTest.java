package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * Fighting
 *
 * @Author Mr.XiongKF
 * @Date 2018/11/21
 * If you don't work hard, no one can give you the life you want!
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    CmsPageRepository cmsPageRepository;

    //查询全部
    @Test
    public void testFindAll() {
        List<CmsPage> list = cmsPageRepository.findAll();
        System.out.println(list);
    }

    //分页查询
    @Test
    public void testFindPage() {
        //分页参数
        int page = 0;//从0开始
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);
    }

    //修改
    @Test
    public void testUpdate() {
        Optional<CmsPage> optional = cmsPageRepository.findById("5a754adf6abb500ad05688d9");
        if (optional.isPresent()) {
            CmsPage cmsPage = optional.get();
            cmsPage.setPageName("测试页面");
            cmsPageRepository.save(cmsPage);
        }
    }

    @Test
    public void testFindPageByExanple() {
        //分页参数
        int page = 1;
        int size = 10;
        PageRequest pageable = PageRequest.of(page, size);
        //条件值对象
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
       //cmsPage.setTemplateId("5a962bf8b00ffc514038fafa");
        //cmsPage.setPageName("10101.html");
        //条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        //定义Example
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        Page<CmsPage> cmsPages = cmsPageRepository.findAll(example, pageable);
        List<CmsPage> content = cmsPages.getContent();
        System.out.println(content);
    }
}
