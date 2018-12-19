package com.lgi.theweschshop.shopdata.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SizeAmountResponseDto {

    private IdNameDto size;

    private Integer amount;

}
