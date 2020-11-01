package com.itsdcode.codingtest.yrseo.v1;

import com.itsdcode.codingtest.yrseo.controller.v1.GoodsSaleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
class GoodsControllerTest {

    @Autowired
    private GoodsSaleController goodsSaleController;

    private MockMvc mockMvc;

    @Test
    public void findAll() {
        System.out.println(goodsSaleController.findAll());
        assertThat(goodsSaleController.findAll()).isNotNull();
    }

    @Test
    public void mockMvcFindAll() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(goodsSaleController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/goodsSale"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}