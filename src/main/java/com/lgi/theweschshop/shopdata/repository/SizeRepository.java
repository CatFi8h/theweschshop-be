package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SizeRepository extends JpaRepository<SizeEntity, Long> {

    Optional<SizeEntity> findSizeEntityByName(String name);

}
