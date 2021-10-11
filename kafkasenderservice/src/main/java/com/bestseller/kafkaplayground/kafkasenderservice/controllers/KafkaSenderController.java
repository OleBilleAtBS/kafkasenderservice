package com.bestseller.kafkaplayground.kafkasenderservice.controllers;

import com.bestseller.kafkaplayground.kafkasenderservice.config.KafkaConfig;
import com.bestseller.kafkaplayground.kafkasenderservice.controllers.dto.BoxContentCreateDto;
import com.bestseller.kafkaplayground.kafkasenderservice.controllers.dto.BoxCreateDto;
import com.bestseller.kafkaplayground.kafkasenderservice.domains.boxstuff.transformers.BoxContentTransformer;
import com.bestseller.kafkaplayground.kafkasenderservice.domains.boxstuff.transformers.BoxTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaSenderController {

  @Autowired
  private KafkaTemplate<Long, Object> boxKafkaTemplate;

  @Autowired
  private BoxTransformer boxTransformer;

  @Autowired
  private BoxContentTransformer boxContentTransformer;

  @PostMapping(path = "api/v1/boxes")
  public ResponseEntity<Void> createBox(@RequestBody BoxCreateDto box) {
    boxKafkaTemplate.send(KafkaConfig.BOX_TOPIC, box.getPublicId(), boxTransformer.toBox(box));
    return ResponseEntity.noContent().build();
  }

  @PostMapping(path = "api/v1/boxcontents")
  public ResponseEntity<Void> createBoxContent(@RequestBody BoxContentCreateDto boxcontent) {
    boxKafkaTemplate.send(KafkaConfig.BOX_CONTENT_TOPIC, boxcontent.getPublicId(), boxContentTransformer.toBoxContent(boxcontent));
    return ResponseEntity.noContent().build();
  }
}
