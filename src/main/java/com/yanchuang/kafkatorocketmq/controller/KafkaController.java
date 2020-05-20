package com.yanchuang.kafkatorocketmq.controller;


import com.yanchuang.kafkatorocketmq.model.KafkaQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rongshuai on 2020/5/20 20:27
 */
@RestController
@RequestMapping(value = "/kafka",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class KafkaController {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/message/send")
    public boolean send(@RequestBody KafkaQueryDto kafkaQueryDto){
        kafkaTemplate.send(kafkaQueryDto.getTopic(),kafkaQueryDto.getContent());
        return true;
    }
}
