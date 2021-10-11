package com.bestseller.kafkaplayground.kafkasenderservice.controllers.dto;

import lombok.Data;

@Data
public class BoxCreateDto {
  private Long publicId;
  private String name;
}
