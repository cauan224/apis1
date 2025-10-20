package com.example.aula20.expecion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
    public class GlobalException {
        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<Map<String, Object>>illegalArgumentExeption(IllegalArgumentException erro){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("mensagem",erro.getMessage(),"sucesso",false));
        }
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, Object>>methoArgumentNotValidException(MethodArgumentNotValidException erro){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("mensagem",erro.getFieldErrors().get(0).getDefaultMessage(),"sucesso",false));
        }

    }
