package com.bestseller.kafkaplayground.kafkasenderservice.domains.boxstuff.transformers;

import com.bestseller.kafkaplayground.kafkasenderservice.controllers.dto.BoxContentCreateDto;
import com.bestseller.kafkaplayground.kafkasenderservice.controllers.dto.BoxCreateDto;
import com.bestseller.schema.logistics.Box;
import com.bestseller.schema.logistics.BoxContent;
import org.springframework.stereotype.Component;

@Component
public class BoxContentTransformer {
  public BoxContent toBoxContent(BoxContentCreateDto dto) {
    return new BoxContent(dto.getPublicId(), dto.getBoxPublicId(), dto.getName());
  }
}
