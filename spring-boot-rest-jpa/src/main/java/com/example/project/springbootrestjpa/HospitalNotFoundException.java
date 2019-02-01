package com.example.project.springbootrestjpa;

public class HospitalNotFoundException  extends RuntimeException{

	public HospitalNotFoundException() {
        super();
    }

    public HospitalNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public HospitalNotFoundException(final String message) {
        super(message);
    }

    public HospitalNotFoundException(final Throwable cause) {
        super(cause);
    }
	
}
