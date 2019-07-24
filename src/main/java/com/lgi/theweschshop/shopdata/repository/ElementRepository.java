package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.Element;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ElementRepository extends JpaRepository<Element, Long> {

    @Query("select e from Element e where e.isDeleted = false")
    Page<Element> findAllByPage(Pageable pageable);

    @Query("select e from Element e where e.id = :elementId and e.isDeleted = false ")
    Optional<Element> findElementById(@Param("elementId") Long id);

    @Query("select e from Element e where e.isDeleted = false ")
    Page<Element> findListOfElements(Pageable pageable);

    @Query("update Element e set e.isDeleted = true where e.id = :id")
    Element markElementAsDeletedById(@Param("id")Long id);

}
