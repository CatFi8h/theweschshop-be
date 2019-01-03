package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.repository.TypeRepository;
import com.lgi.theweschshop.shopdata.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Optional<Type> findTypeByName(String typeName) {
        return typeRepository.findTypeByName(typeName);
    }

    @Override
    public Type save(Type type) {
        return typeRepository.save(type);
    }

}
