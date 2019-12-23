package com.github.curriculeon.controllers;


import com.github.curriculeon.models.Muffin;
import com.github.curriculeon.repositories.MuffinRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class MuffinControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MuffinRepository repository;

    @Test
    public void testShow() {
        ShowTest<Long, Muffin> showTest = new ShowTest<>(repository, mvc, "/muffins/");
        Long givenId = 1L;
        Muffin muffinToBeFoundById = new Muffin();
        showTest.test(givenId, muffinToBeFoundById);
    }

    @Test
    public void testCreate() {
        CreateTest<Long, Muffin> createTest = new CreateTest<>(repository, mvc, "/muffins/");
        Muffin muffinToBeGenerated = new Muffin();
        createTest.test(muffinToBeGenerated);
    }
}
