package com.lgi.theweschshop.shopdata.api.admin;


import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.request.GetAdminElementsRequest;
import com.lgi.theweschshop.shopdata.response.AdminElementListResponse;
import com.lgi.theweschshop.shopdata.response.AdminElementResponse;
import com.lgi.theweschshop.shopdata.service.AdminElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(path = "/apiadmin")
@RestController
public class AdminElementController {

    @Autowired
    private AdminElementService adminElementService;

    @ResponseBody
    @GetMapping(path = "element/list")
    public AdminElementListResponse getElementListForAdminUser(@Valid GetAdminElementsRequest request) {

        List<Element> elementList = adminElementService.getElementListForAdmin(request.getOffset(), request.getPage());

        List<AdminElementResponse> collect = elementList.stream().map(Element::toAdminElementResponse).collect(Collectors.toList());

        AdminElementListResponse adminElementListResponse = new AdminElementListResponse();

        adminElementListResponse.setElementList(collect);

        adminElementListResponse.setItemsTotal(collect.size());

        return adminElementListResponse;
    }


}
