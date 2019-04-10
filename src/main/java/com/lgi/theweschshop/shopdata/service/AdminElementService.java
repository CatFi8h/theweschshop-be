package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.request.CreateNewElementRequest;
import com.lgi.theweschshop.shopdata.response.IdDto;
import com.lgi.theweschshop.shopdata.service.dto.AddElementRequestDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminElementService {
    Page<Element> getElementListForAdmin(Integer offset, Integer page);

    IdDto addNewElement(AddElementRequestDto request);

    Element getElementById(long id);

    void removeElementById(long id);

}
