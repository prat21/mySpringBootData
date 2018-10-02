package com.boot.myspringbootdata.controlleradvice;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.boot.myspringbootdata.model.ExceptionModel;

@Component
@RestControllerAdvice
public class TopicControllerAdvice {

	@ExceptionHandler(NoSuchElementException.class)
	public ExceptionModel handleNoSuchElementException(Exception ex,HttpServletRequest req){
		return new ExceptionModel(ex.getMessage(),req.getRequestURI());
	}
}
