package com.lgi.theweschshop.shopdata.api.admin;

import com.lgi.theweschshop.shopdata.model.*;
import com.lgi.theweschshop.shopdata.service.AdminElementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdminElementController.class)
@RunWith(SpringRunner.class)
public class AdminElementControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AdminElementService adminElementService;

    @Test
    public void test() throws Exception {

        String name = "name";
        int amount = 10;
        Element element = new Element();
        element.setId(1L);
        element.setColor(new Color(1L, "red"));
        String gender = "male";
        element.setGender(gender);
        element.setName(name);
        Type type = new Type(1L, "type");
        element.setType(type);
        HashSet<ElementSizeAmount> elementSizeAmounts = new HashSet<>();

        ElementSizeAmount sizeAmount = new ElementSizeAmount();
        sizeAmount.setAmount(amount);
        sizeAmount.setElement(element);
        SizeEntity size = new SizeEntity(1L, "XL");
        sizeAmount.setId(1L);
        sizeAmount.setSize(size);
        elementSizeAmounts.add(sizeAmount);

        element.setElementSizeAmounts(elementSizeAmounts);

        given(adminElementService.getElementListForAdmin(anyInt(), anyInt())).willReturn(new PageImpl<>(Collections.singletonList(element)));

        mvc.perform(get("/apiadmin/element/list")
                .param("offset", String.valueOf(10))
                .param("page", String.valueOf(0))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.elementList").exists())
                .andExpect(jsonPath("$.elementList", hasSize(1)))
                .andExpect(jsonPath("$.elementList[0].id", is(1)))
                .andExpect(jsonPath("$.elementList[0].name", is(name)))
                .andExpect(jsonPath("$.elementList[0].gender", is(gender)))
                .andExpect(jsonPath("$.elementList[0].type.id", is(type.getId().intValue())))
                .andExpect(jsonPath("$.elementList[0].type.name", is(type.getName())))
                .andExpect(jsonPath("$.elementList[0].sizeAmount", hasSize(1)))
                .andExpect(jsonPath("$.elementList[0].sizeAmount[0]").exists())
                .andExpect(jsonPath("$.elementList[0].sizeAmount[0].size.id", is(size.getId().intValue())))
                .andExpect(jsonPath("$.elementList[0].sizeAmount[0].size.name", is(size.getName())))
                .andExpect(jsonPath("$.elementList[0].sizeAmount[0].amount", is(amount)))
                .andExpect(jsonPath("$.itemsTotal", is(elementSizeAmounts.size())));

    }

}