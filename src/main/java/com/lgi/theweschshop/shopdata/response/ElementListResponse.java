package com.lgi.theweschshop.shopdata.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ElementListResponse {

    private long total = 0;

    private List<ElementDto> list = new ArrayList<>();
}
