package com.co.aguaService.exceptions;


import com.co.aguaService.model.ErrorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jhon
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private ErrorModel errors;
}
