package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.repository.SizeRepository;
import com.lgi.theweschshop.shopdata.service.SizeEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SizeEntityServiceImpl implements SizeEntityService {

    private final SizeRepository sizeRepository;

    @Override
    public Optional<SizeEntity> getSizeEntityByName(String name) {
        return sizeRepository.findSizeEntityByName(name);
    }

    @Override
    public SizeEntity save(SizeEntity size) {
        return sizeRepository.save(size);
    }

}
