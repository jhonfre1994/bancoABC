package com.co.banco.convenios.exceptions;




import com.co.banco.convenios.exceptions.responses.HttpResponseException;
import com.co.banco.convenios.model.ErrorModel;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author jhon
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     * HttpResponseException.
     *
     * @param ex FoundException
     * @param request request
     * @return mensaje de error para HttpResponseException
     */
    @ExceptionHandler(HttpResponseException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(HttpResponseException ex, WebRequest request) {
        HttpStatus status = HttpStatus.valueOf(ex.getStatus());
        ExceptionResponse exceptionResponse = new ExceptionResponse(new ErrorModel(status.getReasonPhrase(), ex.getStatus(), ex.getUrlFail(), ex.getDetail()));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
