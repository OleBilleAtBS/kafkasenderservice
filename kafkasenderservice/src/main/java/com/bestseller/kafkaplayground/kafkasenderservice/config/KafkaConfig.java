package com.bestseller.kafkaplayground.kafkasenderservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

  public static final String BOX_TOPIC = "log_example-box";
  public static final String BOX_CONTENT_TOPIC = "log_example-box-content";

  public KafkaConfig() {
  }

  @Bean
  NewTopic boxTopic() {
    return TopicBuilder.name(BOX_TOPIC)
        .partitions(1)
        .replicas(1)
        .config(TopicConfig.RETENTION_MS_CONFIG, "604800000")
        .config(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_COMPACT)
        .build();
  }

  @Bean
  NewTopic boxContentTopic() {
    return TopicBuilder.name(BOX_CONTENT_TOPIC)
            .partitions(1)
            .replicas(1)
            .config(TopicConfig.RETENTION_MS_CONFIG, "604800000")
            .config(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_COMPACT)
            .build();
  }


}
