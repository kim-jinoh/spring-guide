package com.jokim.convert;

import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component

public class EventFormatter implements Formatter<ConvertedEventByFormatter>{

    @Override
    public ConvertedEventByFormatter parse(String text, Locale locale) {
        return new ConvertedEventByFormatter(Integer.parseInt(text));
    }

    @Override
    public String print(ConvertedEventByFormatter event, Locale locale) {
        return evnet.toString();
    }
}
