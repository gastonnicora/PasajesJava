package com.gastonnicora.pasajes.exception;

public class ValidationException extends RuntimeException {
	private final String field;
	
    public ValidationException(String field,String mensaje) {
        super(mensaje);
        this.field = field;
    }
    public String getField() {
        return field;
    }
}