package com.lgi.theweschshop.shopdata.api.element;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class ElementController {

    @GetMapping(path = "")
    public void getElementList() {

    }
}
