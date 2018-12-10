package com.lgi.theweschshop.shopdata.api.admin;

import com.lgi.theweschshop.shopdata.service.AdminElementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
class AdminElementControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AdminElementService adminElementService;

    @Test
    public void test() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/admin/element/list").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

}