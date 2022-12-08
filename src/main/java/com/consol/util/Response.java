package com.consol.util;

import lombok.Data;

@Data
public class Response {
    
    private String message;
    private int status;

    public Response(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
