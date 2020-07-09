package com.mindtree.newzz.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mindtree.newzz.exception.NewzzException;
import com.mindtree.newzz.utils.dto.ErrorDTO;
import com.mindtree.newzz.utils.dto.ResponseDTO;


@RestControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public final ResponseEntity<ResponseDTO<?>> handleException(NewzzException newzzException, WebRequest req) {
		ErrorDTO error = new ErrorDTO();
		
		error.setMessage(newzzException.getMessage());
		return new ResponseEntity<ResponseDTO<?>>(new ResponseDTO<ErrorDTO>(null, error, false), HttpStatus.BAD_REQUEST);
	}

}

