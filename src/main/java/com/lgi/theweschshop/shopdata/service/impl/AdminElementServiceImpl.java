package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.repository.ElementRepository;
import com.lgi.theweschshop.shopdata.service.AdminElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminElementServiceImpl implements AdminElementService {

    @Autowired
    private ElementRepository elementRepository;

    @Override
    public List<Element> getElementListForAdmin() {
        return elementRepository.findAll();
    }
}
