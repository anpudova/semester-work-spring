package ru.kpfu.itis.controller;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.exception.EntityNotFoundException;
import ru.kpfu.itis.model.response.ExceptionResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleBadRequest(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        return isException(request, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ExceptionHandler({EntityNotFoundException.class, UsernameNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object handleEntityNotFound(HttpServletRequest req) {
        return isException(req, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleServerError(HttpServletRequest req){
        return isException(req, HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    private Object isException(HttpServletRequest req, int status, String message) {
        if (isAjax(req)) {
            return new ExceptionResponse(status, Collections.singletonList(message));
        } else {
            return createMaV(status, message);
        }
    }

    private ModelAndView createMaV(int status, String message) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("status", status);
        mav.addObject("message", message);
        mav.setViewName("err");
        return mav;
    }

    private boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With")));
    }

}
