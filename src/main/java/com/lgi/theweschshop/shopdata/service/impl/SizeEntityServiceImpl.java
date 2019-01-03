package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.repository.SizeRepository;
import com.lgi.theweschshop.shopdata.service.SizeEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SizeEntityServiceImpl implements SizeEntityService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public Optional<SizeEntity> getSizeEntityByName(String name) {
        return sizeRepository.findSizeEntityByName(name);
    }

    @Override
    public SizeEntity save(SizeEntity size) {
        return sizeRepository.save(size);
    }

}
