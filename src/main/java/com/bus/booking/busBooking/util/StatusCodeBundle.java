package com.bus.booking.busBooking.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:MessagesAndCodes.properties")
@Getter
@Setter
public class StatusCodeBundle {
    @Value("${code.success.common}")
    private String commonSuccessCode;

    @Value("${message.success.bus}")
    private String saveBusSuccessMessage;
}
