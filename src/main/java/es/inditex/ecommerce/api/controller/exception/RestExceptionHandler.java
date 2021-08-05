package es.inditex.ecommerce.api.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler( { RuntimeException.class, NullPointerException.class } )
    @ResponseStatus( value = HttpStatus.INTERNAL_SERVER_ERROR )
    @ResponseBody
    public ErrorMessage< String > handleInternalServerError( final Exception e ) {
        return ErrorMessage.< String >builder().error( e.getMessage() ).build();
    }

}

