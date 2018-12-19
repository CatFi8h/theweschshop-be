package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.Element;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ElementRepository extends JpaRepository<Element, Long> {

    @Query("select e from Element e ")
    Page<Element> findAllByPage(Pageable of);

}
