package com.project.utils;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowserTypeConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) {
        assertEquals(BrowserType.class, targetType, "Can only convert to BrowserType");
        return BrowserType.valueOf(source.toString().toUpperCase());
    }
}
