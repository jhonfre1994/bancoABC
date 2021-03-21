package com.co.aguaService.exceptions.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResponseException extends RuntimeException {

    private int status;
    private String urlFail;
    private String detail;

    
}
