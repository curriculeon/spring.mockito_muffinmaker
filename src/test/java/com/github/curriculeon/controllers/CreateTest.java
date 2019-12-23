package com.github.curriculeon.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.curriculeon.models.PersistentTypeInterface;
import gitleon.utils.exceptionalfunctionalinterface.ExceptionalFunction;
import gitleon.utils.exceptionalfunctionalinterface.ExceptionalRunnable;
import org.mockito.BDDMockito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.Serializable;

/**
 * Created by leon on 12/23/2019.
 */
public class CreateTest<
        IdType extends Serializable,
        PersistentType extends PersistentTypeInterface<IdType>> {

    private final MockMvc mvc;
    private final String urlTemplate;
    private final CrudRepository<PersistentType, IdType> repo;

    public CreateTest(CrudRepository<PersistentType, IdType> repo, MockMvc mvc, String urlTemplate) {
        this.mvc = mvc;
        this.urlTemplate = urlTemplate;
        this.repo = repo;
    }

    // given
    public void test(PersistentType entity) {
        entity.verifyIsEntity();
        ObjectMapper jsonWriter = new ObjectMapper();
        String expectedContent = ExceptionalFunction.tryInvoke(jsonWriter::writeValueAsString, entity);
        BDDMockito
                .given(this.repo.save(entity))
                .willReturn(entity);

        // when
        ExceptionalRunnable.tryInvoke(() ->
                this.mvc.perform(MockMvcRequestBuilders
                        .post(urlTemplate)
                        .content(expectedContent)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isCreated())  // then
                        .andExpect(MockMvcResultMatchers.content().string(expectedContent)));
    }
}
