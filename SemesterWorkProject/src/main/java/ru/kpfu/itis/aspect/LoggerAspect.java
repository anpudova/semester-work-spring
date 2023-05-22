package ru.kpfu.itis.aspect;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;

@Log4j
@Aspect
@Component
public class LoggerAspect {

    private final String LOG_FORMAT = "Exception: %s with cause: %s and message: %s";

    @Before("@annotation(org.springframework.web.bind.annotation.ExceptionHandler)  args(java.lang.Throwable, ..)")
    public void logMethod(JoinPoint joinPoint) {

        Throwable throwable = (Throwable) joinPoint.getArgs()[0];
        ResponseStatus annotation = AnnotationUtils.findAnnotation(throwable.getClass(), ResponseStatus.class);

        Class<?> clazz = throwable.getClass();

        if(annotation != null && annotation.value().value() < HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            log.info(String.format(LOG_FORMAT, clazz, throwable.getCause(), throwable.getMessage()));
        } else {
            log.warn(String.format(LOG_FORMAT, clazz, throwable.getCause(), throwable.getMessage()));
        }
    }
}
