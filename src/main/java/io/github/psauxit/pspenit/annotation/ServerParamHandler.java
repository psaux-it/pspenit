package io.github.psauxit.pspenit.annotation;

import io.github.psauxit.pspenit.payload.Payload;

import java.lang.reflect.Field;
import java.util.Collection;

public interface ServerParamHandler {
    Collection<String> handle(Field field, Payload payload);
}