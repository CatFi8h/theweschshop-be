package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.model.Element;

import java.util.List;

public interface AdminElementService {
    List<Element> getElementListForAdmin(Integer offset, Integer page);
}
