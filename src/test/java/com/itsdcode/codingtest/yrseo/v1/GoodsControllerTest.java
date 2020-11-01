package com.itsdcode.codingtest.yrseo.v1;

import com.itsdcode.codingtest.yrseo.controller.v1.GoodsController;
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
    private GoodsController goodsController;

    private MockMvc mockMvc;

    @Test
    public void findAll() {
        System.out.println(goodsController.findAll());
        assertThat(goodsController.findAll()).isNotNull();
    }

    @Test
    public void mockMvcFindAll() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(goodsController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/goods/test"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}