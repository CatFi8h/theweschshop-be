package com.lgi.theweschshop.shopdata.api.admin;


import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.request.CreateNewElementRequest;
import com.lgi.theweschshop.shopdata.request.GetAdminElementsRequest;
import com.lgi.theweschshop.shopdata.response.AdminElementListResponse;
import com.lgi.theweschshop.shopdata.response.AdminElementResponse;
import com.lgi.theweschshop.shopdata.response.IdDto;
import com.lgi.theweschshop.shopdata.service.AdminElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

        Page<Element> elementList = adminElementService.getElementListForAdmin(request.getOffset(), request.getPage());

        List<Element> content = elementList.getContent();

        Long totalElements = elementList.getTotalElements();

        List<AdminElementResponse> collect = content.stream().map(Element::toAdminElementResponse).collect(Collectors.toList());

        AdminElementListResponse adminElementListResponse = new AdminElementListResponse();

        adminElementListResponse.setElementList(collect);

        adminElementListResponse.setItemsTotal(totalElements);

        return adminElementListResponse;
    }

    @PostMapping(path = "element/add")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public IdDto addElement(@Valid CreateNewElementRequest request) {

        return adminElementService.addNewElement(request);

    }


}
