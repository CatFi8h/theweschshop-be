package com.lgi.theweschshop.shopdata.service;

import com.lgi.theweschshop.shopdata.model.SizeEntity;

import java.util.Optional;

public interface SizeEntityService {
    Optional<SizeEntity> getSizeEntityByName(String name);

    SizeEntity save(SizeEntity size);
}
