package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.repositories.BakerRepository;
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


/**
 * @author leon on 8/30/18.
 */
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class BakerControllerTest {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private BakerRepository repository;

    @Test
    public void testShow() throws Exception {
        Long givenId = 1L;
        BDDMockito
                .given(repository.findById(givenId))
                .willReturn(Optional.of(new Baker("New Baker!", null, null)));

        String expectedContent = "{\"id\":null,\"name\":\"New Baker!\",\"employeeId\":null,\"specialty\":null}";
        this.mvc.perform(MockMvcRequestBuilders
                .get("/bakers/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testCreate() throws Exception {
        Baker baker = new Baker("New Baker!", null, null);
        BDDMockito
                .given(repository.save(baker))
                .willReturn(baker);

        String expectedContent="{\"id\":null,\"name\":\"New Baker!\",\"employeeId\":null,\"specialty\":null}";
        this.mvc.perform(MockMvcRequestBuilders
                .post("/bakers/")
                .content(expectedContent)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
            )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
