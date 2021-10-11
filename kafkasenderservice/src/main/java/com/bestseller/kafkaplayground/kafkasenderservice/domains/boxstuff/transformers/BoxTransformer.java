package com.bestseller.kafkaplayground.kafkasenderservice.domains.boxstuff.transformers;

import com.bestseller.kafkaplayground.kafkasenderservice.controllers.dto.BoxCreateDto;
import com.bestseller.schema.logistics.Box;
import org.springframework.stereotype.Component;

@Component
public class BoxTransformer {
  public Box toBox(BoxCreateDto dto) {
    return new Box(dto.getPublicId(), dto.getName());
  }
}
