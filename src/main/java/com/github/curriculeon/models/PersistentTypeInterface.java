package com.github.curriculeon.models;

import com.github.curriculeon.utils.AnnotationVerifier;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by leon on 12/23/2019.
 */
public interface PersistentTypeInterface<IdType extends Serializable> extends AnnotationVerifier {
    default void verifyIsEntity() {
        AnnotationVerifier.super.verifyAnnotationPresence(Entity.class);
    }
}
