package com.lgi.theweschshop.shopdata.service.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddElementRequestDto {
    private String name;

    private String size;

    private int amount;

    private double price;

    private String color;

    private String description;

    private String type;

    private String gender;
}
