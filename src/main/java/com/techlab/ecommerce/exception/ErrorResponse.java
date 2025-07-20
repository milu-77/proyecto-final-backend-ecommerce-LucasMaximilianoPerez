package com.techlab.ecommerce.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
 @Setter
public class ErrorResponse   {
    // Getters
    private int status;
    private String message;

    public ErrorResponse(int status, String message) {


        this.status = status;
        this.message = message;
    }

}