package com.lgi.theweschshop.shopdata.request;

import lombok.Data;

@Data
public class CreateNewElementRequest {

    private String name;

    private String size;

    private Integer amount;

    private Double price;

    private String color;

    private String description;

    private String type;

    private String gender;


}
