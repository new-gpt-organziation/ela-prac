package com.ohgiraffers.elaprac.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MenuControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("상태 확인")
    @Test
    public void healthCheck() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("2번 메뉴 확인")
    @Test
    public void findMenuByCodeTest() throws Exception {
        mockMvc.perform(get("/menus/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.menuName").value("먹밥쿤커요미"))
                .andDo(print());
    }
}