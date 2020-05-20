package com.yanchuang.kafkatorocketmq.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by rongshuai on 2020/5/20 19:55
 */
@Component
public class ConsumerListener {

    @KafkaListener(topics = "deviceData")
    public void onMessage(String message){
        //insertIntoDb(buffer);//这里为插入数据库代码
        System.out.println(message);
    }

}
