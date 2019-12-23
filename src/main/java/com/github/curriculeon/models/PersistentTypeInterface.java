package com.github.curriculeon.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.curriculeon.utils.AnnotationVerifier;
import gitleon.utils.exceptionalfunctionalinterface.ExceptionalFunction;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by leon on 12/23/2019.
 */
public interface PersistentTypeInterface<IdType extends Serializable> extends AnnotationVerifier {
    default void verifyIsEntity() {
        AnnotationVerifier.super.verifyAnnotationPresence(Entity.class);
    }

    default String toJsonString() {
        return ExceptionalFunction.tryInvoke(new ObjectMapper()::writeValueAsString, this);
    }
}
