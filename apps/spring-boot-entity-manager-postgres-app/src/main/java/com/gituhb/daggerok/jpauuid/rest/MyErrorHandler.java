package com.gituhb.daggerok.jpauuid.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.util.Collections.singletonMap;

@Log4j2
@RestControllerAdvice
public class MyErrorHandler {

  @ExceptionHandler(Throwable.class)
  public ResponseEntity on(Throwable throwable) {
    log.error("fallback {}", throwable.getLocalizedMessage());
    return ResponseEntity.badRequest()
                         .body(singletonMap("error", throwable.getLocalizedMessage()));
  }
}
