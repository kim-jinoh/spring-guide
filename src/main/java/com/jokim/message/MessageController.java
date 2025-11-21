package com.jokim.message;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageSource messageSource;

    public MessageController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping
    public String message() {
        String usMsg = messageSource.getMessage("hello_world", null, Locale.US);
        String koreaMsg = messageSource.getMessage("hello_world", null, Locale.KOREA);

        return String.format("default: %s%nkorea: %s", usMsg, koreaMsg);
    }

}
