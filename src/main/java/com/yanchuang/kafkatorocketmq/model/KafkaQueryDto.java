package com.yanchuang.kafkatorocketmq.model;


import lombok.Data;

import java.io.Serializable;

/**
 * Created by rongshuai on 2020/5/20 20:29
 */
@Data
public class KafkaQueryDto implements Serializable {
    private static final long serialVersionUID = 6528333704975556470L;

    private String topic;

    private String content;
}
