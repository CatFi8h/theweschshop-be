package com.lgi.theweschshop.shopdata.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class GetAdminElementsRequest {

    @NonNull
    private Integer offset;

    @NonNull
    private Integer page;

}
