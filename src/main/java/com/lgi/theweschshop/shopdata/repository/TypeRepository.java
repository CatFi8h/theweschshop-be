package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {

    Optional<Type> findTypeByName(String name);

}
