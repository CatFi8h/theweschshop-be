package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.model.Element;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ElementService {
    Element getElementById(Long id);

    Page<Element> getElementList(Integer page, Integer offset);

}
