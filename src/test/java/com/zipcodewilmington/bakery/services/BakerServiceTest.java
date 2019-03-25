package com.zipcodewilmington.bakery.services;


import com.zipcodewilmington.bakery.BakeryApplication;

import com.zipcodewilmington.bakery.controllers.BakerController;
import com.zipcodewilmington.bakery.models.Baker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BakeryApplication.class)
public class BakerServiceTest {
    @MockBean
    private BakerService service;

    private BakerController controller;

    @Before
    public void setup(){
        this.controller = new BakerController(service);
    }


    @Test
    public void testCreate() {
        // Given
        HttpStatus expected = HttpStatus.CREATED;
        Baker expectedBaker = new Baker(null, null, null);
        BDDMockito
                .given(service.create(expectedBaker))
                .willReturn(expectedBaker);

        // When
        ResponseEntity<Baker> response = controller.create(expectedBaker);
        HttpStatus actual = response.getStatusCode();
        Baker actualBaker = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedBaker, actualBaker);
    }


    @Test
    public void testShow() {
        // Given
        Long bakerId = 1L;
        HttpStatus expected = HttpStatus.OK;
        Baker expectedBaker = new Baker(bakerId, null, null, null);
        BDDMockito.
                given(service.show(1L))
                .willReturn(expectedBaker);

        // When
        ResponseEntity<Baker> response = controller.show(bakerId);
        HttpStatus actual = response.getStatusCode();
        Baker actualBaker = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedBaker, actualBaker);
    }

}
