package com.bestseller.kafkaplayground.kafkasenderservice.controllers.dto;

import lombok.Data;

@Data
public class BoxContentCreateDto {
  private Long publicId;
  private Long boxPublicId;
  private String name;
}
