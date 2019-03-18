package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.Element;
import com.lgi.theweschshop.shopdata.model.SizeEntity;
import com.lgi.theweschshop.shopdata.model.Type;
import com.lgi.theweschshop.shopdata.repository.ElementRepository;
import com.lgi.theweschshop.shopdata.response.IdDto;
import com.lgi.theweschshop.shopdata.service.SizeEntityService;
import com.lgi.theweschshop.shopdata.service.TypeService;
import com.lgi.theweschshop.shopdata.service.dto.AddElementRequestDto;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AdminElementServiceImplTest {

    @Mock
    private ElementRepository elementRepository;
    @Mock
    private SizeEntityService sizeEntityService;
    @Mock
    private TypeService typeService;

    @InjectMocks
    AdminElementServiceImpl adminElementService;

    @Before
    public void init() {

    }

    @Test
    public void testAddNewElementToAdmin() {

        final long ELEMENT_ID = 1L;

        when(sizeEntityService.getSizeEntityByName(anyString())).thenReturn(Optional.of(new SizeEntity()));
        when(typeService.findTypeByName(anyString())).thenReturn(Optional.of(new Type()));
        Element element = new Element();
        element.setId(ELEMENT_ID);
        when(elementRepository.save(any(Element.class))).thenReturn(element);

        AddElementRequestDto elementDto = AddElementRequestDto.builder()
                .price(1)
                .type("type")
                .name("name")
                .description("description")
                .gender("gender")
                .color("color")
                .amount(12)
                .size("xl")
                .build();

        IdDto idDto = adminElementService.addNewElement(elementDto);
        assertNotNull(idDto);
        assertEquals(new Long(ELEMENT_ID), idDto.getId());

    }
}