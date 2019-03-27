package com.zipcodewilmington.bakery.controllers;


import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.repositories.MuffinRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class MuffinControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MuffinRepository repository;

    @Test
    public void testShow() throws Exception {
        Long givenId = 1L;
        BDDMockito
                .given(repository.findById(givenId))
                .willReturn(Optional.of(new Muffin("blueberry")));

        String expectedContent = "{\"id\":null,\"flavor\":\"blueberry\"}";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/muffins/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testCreate() throws Exception {
        Muffin muffin = new Muffin("blueberry");
        BDDMockito
                .given(repository.save(muffin))
                .willReturn(muffin);

        String expectedContent = "{\"id\":null,\"flavor\":\"blueberry\"}";
        this.mvc.perform(MockMvcRequestBuilders
                .post("/muffins/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(expectedContent)
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
