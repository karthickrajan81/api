package com.main.api;

import static org.mockito.ArgumentMatchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import com.main.api.entities.Person;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.*;
import com.google.gson.Gson;
import java.util.HashMap;

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
    public void getPersonByIdReturnsPerson() throws Exception {
        mockMvc.perform(get("/person/1")).andExpect(status().isOk());
    }

    @Test
    public void addPersonReturnsCreatesNewPerson() throws Exception {
        Person person = new Person("Test", "Test");
        Gson gson = new Gson();

        mockMvc.perform(post("/person/add").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(person)))
                .andExpect(status().isCreated());
    }

    @Test
    public void getPersonbyNameReturnListOfPerson() throws Exception {

        mockMvc.perform(get("/person/name?firstName=Steve&lastName=Jobs")).andExpect(status().isOk())
                .andExpect(content().json("[{'id':1,'firstName':'Steve','lastName':'Jobs'}]"));

    }

    @Test
    public void testupdatePerson() throws Exception {
        Map<String, String> person = new HashMap<>();
        person.put("id", "1");
        person.put("firstName", "Steeeve");
        person.put("lastName", "Jobs");

        Gson gson = new Gson();

        String output = gson.toJson(person);

        mockMvc.perform(put("/person/update").contentType(MediaType.APPLICATION_JSON).content(output))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletePerson() throws Exception {
        mockMvc.perform(delete("/person/1")).andExpect(status().isOk());
    }

}
