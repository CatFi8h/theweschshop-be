package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.repository.ElementRepository;
import com.lgi.theweschshop.shopdata.service.ElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElementServiceImpl implements ElementService {

    private final ElementRepository elementRepository;

    @Override
    public Element getElementById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        Optional<Element> optionalElement = elementRepository.findElementById(id);
        return optionalElement.orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Page<Element> getElementList(Integer page, Integer offset) {
        PageRequest pageRequest = PageRequest.of(page, offset, new Sort(Sort.Direction.ASC, "id"));
        return elementRepository.findListOfElements(pageRequest);
    }

}
