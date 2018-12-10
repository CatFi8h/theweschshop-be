package com.lgi.theweschshop.shopdata.response;

import com.lgi.theweschshop.shopdata.service.AdminElementService;
import lombok.Data;

import java.util.List;

@Data
public class AdminElementListResponse {

    public List<AdminElementService> elementList;

    public Long itemsTotal;

}
