package com.xuecheng.manage_cms.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Author:Mr.XiongKF
 * @Date:2019/4/21 15:29
 * Study well and make progress every day.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTemplateTest {
    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testRestTemplate(){
        ResponseEntity<Map> restTemplates = restTemplate.getForEntity("http://localhost:31001/cms/config/getmodel/5a795d82dd573c3574ee3360", Map.class);
        Map body = restTemplates.getBody();
        System.out.println(body);

    }

}
