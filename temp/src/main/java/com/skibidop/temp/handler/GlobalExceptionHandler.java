package com.skibidop.temp.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestControllerAdvice //บอกว่าถ้ามันมี error จาก annotation RestController มาที่นี้
public class GlobalExceptionHandler {

    //วิธีที่1เขียนที่เดียว ทำงานกับทุกไฟล์ได้เลยเมื่อมี Error มา
    //มันจะทำงานเองอัตโนมัติถ้ามีการ Error ใน RestController ตาม flowchart
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
        .forEach(error->{
            String ErrorField = error.getField();
            String ErrorMessage = error.getDefaultMessage();
            errors.put(ErrorField, ErrorMessage);
        });

        return ResponseEntity.badRequest().body(errors);
    }

    //วิธีที่2เอาไปใช้เอง throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found");
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(ResponseStatusException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put("message-error",ex.getReason());
        //reason เอามาจาก throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found");
        return ResponseEntity.badRequest().body(errors);
    }




//     POST /user-dto-autowired  กับ {"email": "", "name": "test", "password": "123"}
//          │
//          ▼
//   @Valid เจอ email = "" → fail @NotBlank
//          │
//          ▼
//   Spring throw MethodArgumentNotValidException
//          │
//          ▼
//   Spring หา @ExceptionHandler ที่รับ exception นี้
//          │
//          ▼
//   เจอ! → handleValidationException() ถูกเรียกอัตโนมัติ
//          │
//          ▼
//   ex.getBindingResult().getFieldErrors() ดึง error ทุก field ที่ fail
//          │
//          ▼
//   สร้าง Map: {"email": "Email cannot be null"}
//          │
//          ▼
//   return 400 Bad Request พร้อม body เป็น JSON

    
}
