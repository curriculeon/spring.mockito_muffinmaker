package com.zipcodewilmington.bakery;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcodewilmington.bakery.Models.Baker;
import com.zipcodewilmington.bakery.Repositories.BakerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


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
                .given(repository.findOne(givenId))
                .willReturn(new Baker("New Baker!", null, null));

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
                .post("/bakers/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
