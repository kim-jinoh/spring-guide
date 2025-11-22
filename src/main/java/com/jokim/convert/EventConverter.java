package com.jokim.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class EventConverter {

    @Component
    public static class StringToEventConverter implements Converter<String, ConvertedEventByConverter> {
        @Override
        public ConvertedEventByConverter convert(String source) {
            return new ConvertedEventByConverter(Integer.parseInt(source));
        }
    }

    // EventToStringConverter 생성 하면 될 듯
}
