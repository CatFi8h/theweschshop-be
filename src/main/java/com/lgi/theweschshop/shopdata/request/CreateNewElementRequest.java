package com.lgi.theweschshop.shopdata.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateNewElementRequest {

    @NotNull
    private String name;

    @NotNull
    private String size;

    @NotNull
    private Integer amount;

    @NotNull
    private Double price;

    private String color;

    private String description;

    @NotNull
    private String type;

    @NotNull
    private String gender;


}
