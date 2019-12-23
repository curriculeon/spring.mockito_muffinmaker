package com.github.curriculeon.controllers;

import com.github.curriculeon.models.Baker;
import com.github.curriculeon.repositories.BakerRepository;
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
    public void testShow() {
        ShowTest<Long, Baker> showTest = new ShowTest<>(repository, mvc, "/bakers/");
        Long givenId = 1L;
        Baker bakerToBeGenerated = new Baker( null, null, null);
        showTest.test(givenId, bakerToBeGenerated);
    }

    @Test
    public void testCreate() throws Exception {
        CreateTest<Long, Baker> createTest = new CreateTest<>(repository, mvc, "/bakers/");
        createTest.test(new Baker("New Baker!", null, null));
    }
}
