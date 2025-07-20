package com.techlab.ecommerce.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcceptResponse   {
    // Getters
    private int status;
    private String message;

    public AcceptResponse(int status, String message) {


        this.status = status;
        this.message = message;
    }

}