package com.lgi.theweschshop.shopdata.response;

import lombok.Data;

import java.util.List;

@Data
public class AdminElementResponse {

    private Long id;

    private String name;

    private IdNameDto type;

    private IdNameDto color;

    private String gender;

    private List<SizeAmountResponseDto> sizeAmount;

}
