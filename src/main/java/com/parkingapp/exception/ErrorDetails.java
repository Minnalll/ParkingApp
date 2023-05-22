package com.parkingapp.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.validation.FieldError;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String details;
	
}
