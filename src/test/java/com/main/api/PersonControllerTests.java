package com.main.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.main.api.entities.Person;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllPersonReturnsList() throws Exception {
        mockMvc.perform(get("/person/all")).andExpect(status().isOk());
    }

    @Test
    public void getPersonByIdReturnsPersonObject() throws Exception {
        mockMvc.perform(get("/person/1")).andExpect(status().isOk());
    }

    @Test
    public void addPersonReturnsCreatesNewPersonObject() throws Exception {
        Person person = new Person("Test", "Test");
        Gson gson = new Gson();

        mockMvc.perform(post("/person/add").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(person)))
                .andExpect(status().isOk());
    }

}
