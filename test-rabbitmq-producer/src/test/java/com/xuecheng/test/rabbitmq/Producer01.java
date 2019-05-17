package com.xuecheng.test.rabbitmq;

/**
 * @Author:Mr.XiongKF
 * @Date:2019/4/28 20:34
 * Study well and make progress every day.
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 入门程序
 */
public class Producer01 {

    private static final String QUEUE="hello world";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");//设置虚拟机
        Connection connection=null;
        Channel channel=null;
        try {
            connection = connectionFactory.newConnection();
            //创建会话通道,生产者和mq之间的通信都在此进行
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE,true,false,false,null);//声明队列
            //消息内容
            String message="hello world 心梦无痕";
            channel.basicPublish("",QUEUE,null,message.getBytes());
            System.out.println("send to mq"+message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
