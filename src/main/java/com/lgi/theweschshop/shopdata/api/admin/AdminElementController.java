package com.lgi.theweschshop.shopdata.api.admin;


import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.ElementSizeAmount;
import com.lgi.theweschshop.shopdata.response.AdminElementListResponse;
import com.lgi.theweschshop.shopdata.response.AdminElementResponse;
import com.lgi.theweschshop.shopdata.service.AdminElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/admin")
public class AdminElementController {

    @Autowired
    private AdminElementService adminElementService;

    @GetMapping(path = "element/list")
    public AdminElementListResponse getElementListForAdminUser() {
        List<Element> elementList = adminElementService.getElementListForAdmin();

        elementList.stream().map(this::toAdminElementResponse).collect(Collectors.toList())

        AdminElementResponse adminElementResponse = new AdminElementResponse();

        AdminElementListResponse adminElementListResponse = new AdminElementListResponse();


        return adminElementListResponse;
    }

    private AdminElementResponse toAdminElementResponse(Element e) {
        AdminElementResponse response = new AdminElementResponse();
        Set<ElementSizeAmount> elementSizeAmounts = e.getElementSizeAmounts();
        response.setAmount(elementSizeAmounts);


        response.setColor(e.get);

        return null;
    }


}
