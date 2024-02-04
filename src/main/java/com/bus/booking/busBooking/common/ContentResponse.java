package com.bus.booking.busBooking.common;

import java.util.HashMap;
import java.util.Map;

public class ContentResponse <T> extends BaseResponse{
    private Map<String,T> result = new HashMap<>();
    public ContentResponse(String key,T dto,String status, String statusCode, String message) {
        super(status, statusCode, message);
        result.put(key,dto);
    }
}
