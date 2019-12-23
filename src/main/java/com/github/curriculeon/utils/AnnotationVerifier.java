package com.github.curriculeon.utils;

import java.lang.annotation.Annotation;
import java.lang.annotation.IncompleteAnnotationException;

/**
 * Created by leon on 12/23/2019.
 */
public interface AnnotationVerifier {
    default void verifyAnnotationPresence(Class<? extends Annotation> annotationType) {
        Class<?> thisClass = this.getClass();
        if (!thisClass.isAnnotationPresent(annotationType)) {
            String errorMessage = "Expected %s to be annotated with %s";
            errorMessage = String.format(errorMessage, thisClass, annotationType);
            throw new Error(new IncompleteAnnotationException(annotationType, errorMessage));
        }
    }
}
