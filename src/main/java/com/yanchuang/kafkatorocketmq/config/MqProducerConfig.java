package com.yanchuang.kafkatorocketmq.config;

import lombok.Data;
import lombok.ToString;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rongshuai on 2020/5/21 8:50
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "rocketmq.producer")
public class MqProducerConfig {
    public static final Logger LOGGER = LoggerFactory.getLogger(MqProducerConfig.class);

    private String groupName;
    private String namesrvAddr;
    // 消息最大值
    private Integer maxMessageSize;
    // 消息发送超时时间
    private Integer sendMsgTimeOut;
    // 失败重试次数
    private Integer retryTimesWhenSendFailed;

    /**
     * mq 生成者配置
     * @return
     * @throws MQClientException
     */
    @Bean
    public DefaultMQProducer defaultProducer() throws MQClientException {
        LOGGER.info("defaultProducer 正在创建---------------------------------------");
        LOGGER.info("当前地址为：{}",namesrvAddr);
        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setVipChannelEnabled(false);
        producer.setMaxMessageSize(maxMessageSize);
        producer.setSendMsgTimeout(sendMsgTimeOut);
        producer.setRetryTimesWhenSendAsyncFailed(retryTimesWhenSendFailed);
        producer.start();
        LOGGER.info("rocketmq producer server 开启成功----------------------------------");
        return producer;
    }

}
