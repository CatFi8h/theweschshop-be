package com.lgi.theweschshop.shopdata.api.admin;


import com.lgi.theweschshop.shopdata.response.AdminElementResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/admin")
public class AdminElementController {


    @GetMapping(path = "element/list")
    public AdminElementResponse getElementListForAdminUser(){
        return new AdminElementResponse();
    }

}
