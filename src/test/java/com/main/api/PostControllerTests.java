package com.main.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPostbyId() throws Exception {
        mockMvc.perform(get("/post/1")).andExpect(status().isOk());
    }

    @Test
    public void getPostsbyUserId() throws Exception {
        mockMvc.perform(get("/post?userId=2")).andExpect(status().isOk());
    }

    @Test
    public void searchbyTitleOrBody() throws Exception {
        mockMvc.perform(get("/post/search?title=commodi&body=commodi")).andExpect(status().isOk());
    }
}
