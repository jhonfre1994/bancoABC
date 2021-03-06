package com.co.banco.convenios.exceptions;

import com.co.banco.convenios.model.ErrorModel;
import java.util.Date;
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
