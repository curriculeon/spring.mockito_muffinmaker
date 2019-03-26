package com.zipcodewilmington.bakery.services;

import com.zipcodewilmington.bakery.BakeryApplication;
import com.zipcodewilmington.bakery.controllers.MuffinController;
import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.repositories.BakerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(MuffinService.class)
public class MuffinServiceTest {
    @MockBean
    private MuffinService service;

    private MuffinController controller;

    @Before
    public void setup(){
        this.controller = new MuffinController(service);
    }


    @Test
    public void testCreate() {
        // Given
        HttpStatus expected = HttpStatus.CREATED;
        Muffin expectedMuffin = new Muffin();
        given(service.create(expectedMuffin)).willReturn(expectedMuffin);

        // When
        ResponseEntity<Muffin> response = controller.create(expectedMuffin);
        HttpStatus actual = response.getStatusCode();
        Muffin actualMuffin = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedMuffin, actualMuffin);
    }


    @Test
    public void testShow() {
        // Given
        Long bakerId = 1L;
        HttpStatus expected = HttpStatus.OK;
        Muffin expectedMuffin = new Muffin();
        given(service.show(1L)).willReturn(expectedMuffin);

        // When
        ResponseEntity<Muffin> response = controller.show(bakerId);
        HttpStatus actual = response.getStatusCode();
        Muffin actualMuffin = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedMuffin, actualMuffin);
    }
}
