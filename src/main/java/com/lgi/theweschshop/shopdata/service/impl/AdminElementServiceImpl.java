package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.ElementSizeAmount;
import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.repository.ElementRepository;
import com.lgi.theweschshop.shopdata.response.IdDto;
import com.lgi.theweschshop.shopdata.service.AdminElementService;
import com.lgi.theweschshop.shopdata.service.SizeEntityService;
import com.lgi.theweschshop.shopdata.service.TypeService;
import com.lgi.theweschshop.shopdata.service.dto.AddElementRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AdminElementServiceImpl implements AdminElementService {

    private final ElementRepository elementRepository;

    private final SizeEntityService sizeEntityService;

    private final TypeService typeService;

    @Override
    public Page<Element> getElementListForAdmin(Integer offset, Integer page) {
        Pageable pageable = PageRequest.of(page, offset);

        return elementRepository.findAllByPage(pageable);
    }

    @Override
    public IdDto addNewElement(AddElementRequestDto elementDto) {

        Element element = new Element();

        String requestSize = elementDto.getSize();

        SizeEntity size = sizeEntityService.getSizeEntityByName(requestSize)
                .orElseGet(() -> sizeEntityService.save(new SizeEntity(requestSize)));

        ElementSizeAmount elementSizeAmount = new ElementSizeAmount(elementDto.getAmount(), element, size);
        element.setElementSizeAmounts(new HashSet<>(Collections.singletonList(elementSizeAmount)));

        String requestType = elementDto.getType();

        Type type = typeService.findTypeByName(requestType).orElseGet(() -> typeService.save(new Type(elementDto.getType())));

        element.setCreationDate(LocalDateTime.now());

        element.setType(type);

        element.setGender(elementDto.getGender());

        Element savedElement = elementRepository.save(element);

        return new IdDto(savedElement.getId());
    }

    @Override
    public Element getElementById(long id) {
        return elementRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void removeElementById(long id) {

        Element element = elementRepository.markElementAsDeletedById(id);
        if (element == null) {
            throw new NoSuchElementException();
        }

    }

}
