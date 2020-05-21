package com.yanchuang.kafkatorocketmq.kafka;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by rongshuai on 2020/5/20 19:55
 */
@Component
public class ConsumerListener {
    @Autowired
    DefaultMQProducer defaultMQProducer;

    @KafkaListener(topics = "deviceData")
    public void onMessage(String message){
        Message sendMsg = new Message("deviceDate",message.getBytes());
        try {
            defaultMQProducer.send(sendMsg);
        } catch (Exception e){
            System.out.println("mq消息发送异常");
            e.printStackTrace();
        }
        System.out.println(message);
    }

}
