package com.lgi.theweschshop.shopdata.api.client;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.response.ElementDto;
import com.lgi.theweschshop.shopdata.response.ElementListResponse;
import com.lgi.theweschshop.shopdata.service.ElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("shop")
@RequiredArgsConstructor
public class UserElementController {

    private final ElementService elementService;

    @GetMapping("element")
    public ElementDto getElementById(Long id) {
        Element element = elementService.getElementById(id);
        return ElementDto.toElementDto(element);
    }

    @GetMapping("element/list")
    public ElementListResponse getELementList(Integer page, Integer offset) {
        Page<Element> elementList = elementService.getElementList(page, offset);
        long totalElements = elementList.getTotalElements();

        List<ElementDto> collect = elementList.getContent().stream().map(ElementDto::toElementDto).collect(Collectors.toList());
        ElementListResponse elementListResponse = new ElementListResponse();
        elementListResponse.setList(collect);
        elementListResponse.setTotal(totalElements);
        return elementListResponse;
    }


}
