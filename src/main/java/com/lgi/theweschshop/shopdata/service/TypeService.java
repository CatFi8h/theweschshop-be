package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.model.Type;

import java.util.Optional;

public interface TypeService {
    Optional<Type> findTypeByName(String requestType);

    Type save(Type type);
}
