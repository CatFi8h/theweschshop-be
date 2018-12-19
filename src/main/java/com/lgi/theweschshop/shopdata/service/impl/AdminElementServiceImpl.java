package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.repository.ElementRepository;
import com.lgi.theweschshop.shopdata.response.AdminElementListResponse;
import com.lgi.theweschshop.shopdata.service.AdminElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminElementServiceImpl implements AdminElementService {

    @Autowired
    private ElementRepository elementRepository;

    @Override
    public List<Element> getElementListForAdmin(Integer offset, Integer page) {
        Pageable pageable = PageRequest.of(offset, page);

        Page<Element> allByPage = elementRepository.findAllByPage(pageable);

        List<Element> content = allByPage.getContent();

        Long totalElements = allByPage.getTotalElements();

        AdminElementListResponse adminElementListResponse = new AdminElementListResponse();

        return content;
    }

}
