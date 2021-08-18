package com.dms.config.handler;

import com.dms.api.dto.common.Response;
import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExcptionHandler {

  private static Logger logger = LoggerFactory.getLogger(GlobalExcptionHandler.class);

  @ExceptionHandler({RuntimeException.class})
  public ResponseEntity<Object> BadRequestException(final RuntimeException ex) {
    logger.warn("error", ex);
    Response response = new Response(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({AccessDeniedException.class})
  public ResponseEntity<Object> handleAccessDeniedException(final AccessDeniedException ex) {
    logger.warn("error", ex);
    Response response = new Response(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value(),
        ex.getMessage(), null);
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }


  @ExceptionHandler({SQLException.class})
  public ResponseEntity<Object> handleSQLException(final SQLException ex) {
    logger.warn("error", ex);
    Response response = new Response(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value(),
        ex.getMessage(), null);
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<Object> handleAll(final Exception ex) {
    logger.info(ex.getClass().getName());
    logger.error("error", ex);
    Response response = new Response(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
