package com.co.banco.convenios.exceptions.responses;

import com.co.banco.convenios.model.ErrorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResponseException extends RuntimeException {

    private int status;
    private String urlFail;
    private String detail;

    
}
