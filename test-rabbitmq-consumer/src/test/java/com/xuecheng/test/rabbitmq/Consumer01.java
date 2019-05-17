package com.xuecheng.test.rabbitmq;

/**
 * @Author:Mr.XiongKF
 * @Date:2019/4/28 21:03
 * Study well and make progress every day.
 */

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 入门程序
 */
public class Consumer01 {
    private static final String QUEUE="hello world";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");//设置虚拟机

        Connection connection = connectionFactory.newConnection();
        //创建会话通道,生产者和mq之间的通信都在此进行
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE,true,false,false,null);
        //实现消费方法
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            //接收消息调用
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //交换机
                String exchange = envelope.getExchange();
                //消息id
                long deliveryTag = envelope.getDeliveryTag();
                //消息内容
                String message = new String(body, "utf-8");
                System.out.println("receive message:"+message);
            }
        };

        //监听对列
        channel.basicConsume(QUEUE,true,defaultConsumer);
    }
}
