package com.github.curriculeon.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.curriculeon.models.PersistentTypeInterface;
import gitleon.utils.exceptionalfunctionalinterface.ExceptionalFunction;
import gitleon.utils.exceptionalfunctionalinterface.ExceptionalRunnable;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by leon on 12/23/2019.
 */
final public class ShowTest<
        IdType extends Serializable,
        PersistentType extends PersistentTypeInterface<IdType>> {

    private final MockMvc mvc;
    private final String urlTemplate;
    private final CrudRepository<PersistentType, IdType> repo;

    public ShowTest(CrudRepository<PersistentType, IdType> repo, MockMvc mvc, String urlTemplate) {
        this.mvc = mvc;
        this.urlTemplate = urlTemplate;
        this.repo = repo;
    }

    // given
    public void test(IdType givenId, PersistentType entity) {
        entity.verifyIsEntity();
        ObjectMapper jsonWriter = new ObjectMapper();
        String expectedContent = ExceptionalFunction.tryInvoke(jsonWriter::writeValueAsString, entity);
        BDDMockito
                .given(this.repo.findById(givenId))
                .willReturn(Optional.of(entity));

        // when
        ExceptionalRunnable.tryInvoke(() ->
                this.mvc.perform(MockMvcRequestBuilders
                        .get(urlTemplate + givenId))
                        // then
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().string(expectedContent)));
    }
}
