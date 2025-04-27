package com.exercise.coincounter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CounterController.class)
class CoinCounterApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() throws Exception {
        var priceInCent = 100;
        mvc.perform(MockMvcRequestBuilders.post("/count?priceInCent=" + priceInCent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].value").value(1))
                .andExpect(jsonPath("$[0].type").value(100));
    }
}
