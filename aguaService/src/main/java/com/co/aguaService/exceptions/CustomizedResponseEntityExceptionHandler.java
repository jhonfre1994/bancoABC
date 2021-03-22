package com.co.aguaService.exceptions;




import com.co.aguaService.exceptions.responses.HttpResponseException;
import com.co.aguaService.model.ErrorModel;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${spring.application.name}")
    private String serviceName;

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
        ExceptionResponse exceptionResponse = new ExceptionResponse(new ErrorModel(status.getReasonPhrase(), ex.getStatus(), ex.getUrlFail(), "Error en el servicio " + serviceName ));
        return new ResponseEntity<>(exceptionResponse, status);
    }

}
