package ru.sbt.synapse.reactproject.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundClientException.class)
    public String notFoundClient(NotFoundClientException exception){
        log.error(exception.getMessage());
        return exception.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundProductException.class)
    public String notFoundProduct(NotFoundProductException exception){
        log.error(exception.getMessage());
        return exception.getMessage();
    }
}
