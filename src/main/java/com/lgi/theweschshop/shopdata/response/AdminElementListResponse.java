package com.lgi.theweschshop.shopdata.response;

import lombok.Data;

import java.util.List;

@Data
public class AdminElementListResponse {

    public List<AdminElementResponse> elementList;

    public Long itemsTotal;

}
