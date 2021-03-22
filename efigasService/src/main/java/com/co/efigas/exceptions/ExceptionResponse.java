package com.co.efigas.exceptions;


import com.co.efigas.model.ErrorModel;
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
