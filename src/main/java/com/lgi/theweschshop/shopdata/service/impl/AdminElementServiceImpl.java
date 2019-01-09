package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.ElementSizeAmount;
import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.repository.ElementRepository;
import com.lgi.theweschshop.shopdata.request.CreateNewElementRequest;
import com.lgi.theweschshop.shopdata.response.IdDto;
import com.lgi.theweschshop.shopdata.service.AdminElementService;
import com.lgi.theweschshop.shopdata.service.SizeEntityService;
import com.lgi.theweschshop.shopdata.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Service
public class AdminElementServiceImpl implements AdminElementService {

    @Autowired
    private ElementRepository elementRepository;

    @Autowired
    private SizeEntityService sizeEntityService;

    @Autowired
    private TypeService typeService;

    @Override
    public Page<Element> getElementListForAdmin(Integer offset, Integer page) {
        Pageable pageable = PageRequest.of(page, offset);

        return elementRepository.findAllByPage(pageable);
    }

    @Override
    public IdDto addNewElement(CreateNewElementRequest request) {

        Element element = new Element();

        String requestSize = request.getSize();

        SizeEntity size = sizeEntityService.getSizeEntityByName(requestSize)
                .orElseGet(() -> sizeEntityService.save(new SizeEntity(requestSize)));

        ElementSizeAmount elementSizeAmount = new ElementSizeAmount(request.getAmount(), element, size);
        element.setElementSizeAmounts(new HashSet<>(Arrays.asList(elementSizeAmount)));

        String requestType = request.getType();

        Type type = typeService.findTypeByName(requestType).orElseGet(() -> typeService.save(new Type(request.getType())));

        element.setCreationDate(LocalDateTime.now());

        element.setType(type);

        element.setGender(request.getGender());

        Element savedElement = elementRepository.save(element);

        return new IdDto(savedElement.getId());
    }

    @Override
    public Element getElementById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        Optional<Element> optionalElement = elementRepository.findById(id);
        Element element = optionalElement.orElseThrow(IllegalArgumentException::new);
        return element;
    }

    @Override
    public void removeElementById(Long id) {
        Optional<Element> optionalElement = elementRepository.findById(id);
        optionalElement.get().setIsDeleted(true);

    }

}
