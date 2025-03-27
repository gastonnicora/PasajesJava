package com.gastonnicora.pasajes.exception;



import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ MethodArgumentNotValidException.class, HttpMessageNotReadableException.class })
	public ResponseEntity<Map<String, String>> handleValidationExceptions(Exception ex) {
		Map<String, String> errores = new HashMap<>();

		if (ex instanceof MethodArgumentNotValidException) {

			((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors()
					.forEach((FieldError error) -> errores.put(error.getField(), error.getDefaultMessage()));
		} else if (ex instanceof HttpMessageNotReadableException) {

			errores.put("nacimiento", "Formato de fecha inválido. Use el formato yyyy-MM-dd");
		}
		return ResponseEntity.badRequest().body(errores);
	}
		
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(ValidationException ex) {
	    Map<String, String> errores = new HashMap<>();
	    errores.put(ex.getField(), ex.getMessage());  
	    return ResponseEntity.badRequest().body(errores);  
	}

}
