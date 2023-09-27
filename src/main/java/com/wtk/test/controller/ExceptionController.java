//package com.wtk.test.controller;
//
//import com.wtk.test.exception.NotFoundException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//@Slf4j
//public class ExceptionController {
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<?> notFoundException() {
//        log.info("\n\n:::::==In Controller Advice Not Found Exception==:::::\n\n");
//        return ResponseEntity.notFound().build();
//    }
//}
