package com.lgi.theweschshop.shopdata.api.admin;


import com.lgi.theweschshop.shopdata.model.Color;
import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.request.CreateNewElementRequest;
import com.lgi.theweschshop.shopdata.request.GetAdminElementsRequest;
import com.lgi.theweschshop.shopdata.response.*;
import com.lgi.theweschshop.shopdata.service.AdminElementService;
import com.lgi.theweschshop.shopdata.service.dto.AddElementRequestDto;
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

        AddElementRequestDto build = AddElementRequestDto.builder()
                .amount(request.getAmount())
                .color(request.getColor())
                .gender(request.getGender())
                .description(request.getDescription())
                .price(request.getPrice())
                .name(request.getName())
                .type(request.getType())
                .build();

        return adminElementService.addNewElement(build);

    }

    @GetMapping(path = "element")
    @ResponseBody
    public AdminElementResponse getElementById(@Valid @PathVariable Long id) {
        Element element = adminElementService.getElementById(id);
        AdminElementResponse adminElementResponse = new AdminElementResponse();
        adminElementResponse.setId(element.getId());
        adminElementResponse.setGender(element.getGender());
        Type type = element.getType();
        adminElementResponse.setType(new IdNameDto(type.getId(), type.getName()));
        Color color = element.getColor();
        adminElementResponse.setColor(new IdNameDto(color.getId(), color.getName()));
        element.getElementSizeAmounts().stream().map(e -> new SizeAmountResponseDto(new IdNameDto(e.getSize().getId(), e.getSize().getName()), e.getAmount())).collect(Collectors.toList());
        adminElementResponse.setSizeAmount(
                element.getElementSizeAmounts().stream()
                        .map(e -> new SizeAmountResponseDto(new IdNameDto(e.getSize().getId(), e.getSize().getName()), e.getAmount()))
                        .collect(Collectors.toList()));
        return adminElementResponse;
    }

    @DeleteMapping(path = "element")
    public void removeElementById(@Valid @PathVariable Long id) {
        adminElementService.removeElementById(id);
    }


}
