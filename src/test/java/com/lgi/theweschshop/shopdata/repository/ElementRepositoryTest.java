package com.lgi.theweschshop.shopdata.repository;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.lgi.theweschshop.shopdata.model.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@DBRider
@DataJpaTest
@RunWith(SpringRunner.class)
public class ElementRepositoryTest {

    @Autowired
    private ElementRepository elementRepository;

    @Test
    @DataSet({"element.yml"})
    public void findElementById() {

        Element element = elementRepository.findElementById(1L).orElseThrow(IllegalArgumentException::new);

        assertNotNull(element);

    }

}