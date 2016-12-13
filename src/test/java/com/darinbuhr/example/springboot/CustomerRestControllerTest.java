package com.darinbuhr.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getCustomer() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/customers/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\"}")));
    }

    @Test
    public void createCustomer() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/customers")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":44,\"firstName\":\"Michael\",\"lastName\":\"Smith\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":4,\"firstName\":\"Michael\",\"lastName\":\"Smith\"}")));
    }

    @Test
    public void updateCustomer() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/customers/2")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":2,\"firstName\":\"Janie\",\"lastName\":\"Doe\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":2,\"firstName\":\"Janie\",\"lastName\":\"Doe\"}")));
    }

    @Test
    public void deleteCustomer() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/customers/3"))
                .andExpect(status().isOk());
    }
}

