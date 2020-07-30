package com.telecom.user.exception;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class OrderExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Internal> handleNullPointerException(NullPointerException ex) {
		Internal errorResponse = new Internal();
		errorResponse.setMessage("Server error");
		errorResponse.setCode(Internal.CodeEnum.INTERNAL);
		return new ResponseEntity<Internal>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<Internal> handleAllException(Exception ex){
		Internal errorResponse = new Internal();
		errorResponse.setMessage("Server error");
		errorResponse.setCode(Internal.CodeEnum.INTERNAL);
		return new ResponseEntity<Internal>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler
	public ResponseEntity<NotFound> handleOrderNotFoundException(OrderNotFoundException ex) {
		NotFound errorResponse = new NotFound();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setCode(NotFound.CodeEnum.NOT_FOUND);
		return new ResponseEntity<NotFound>(errorResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<PermissionDenied> handleUserPermissionNotFoundException(UserPermissionException ex) {
		PermissionDenied errorResponse = new PermissionDenied();
		errorResponse.setMessage(ex.getErrorMessage());
		errorResponse.setCode(PermissionDenied.CodeEnum.PERMISSION_DENIED);
		return new ResponseEntity<PermissionDenied>(errorResponse, HttpStatus.FORBIDDEN);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		InvalidArgument errorResponse = new InvalidArgument();
		Map<String, String> errors=new HashMap<>();
		//ex.getBindingResult().getAllErrors().forEach((error)->{String fieldName=((FieldError)error).getField();String errorMessage=error.getDefaultMessage();errors.put(fieldName, errorMessage);});
		errorResponse.setMessage("Client specified an invalid argument, request body or query param");
		errorResponse.setCode(InvalidArgument.CodeEnum.INVALID_ARGUMENT);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(UserPermissionException.class)
//	public ResponseEntity<PermissionDenied> handleBaseTSLException(UserPermissionException exception,WebRequest request){
//		PermissionDenied errorResponse = new PermissionDenied();
//		errorResponse.setMessage(exception.getMessage());
//		errorResponse.setCode(PermissionDenied.CodeEnum.PERMISSION_DENIED);
//		return new ResponseEntity<PermissionDenied>(errorResponse, HttpStatus.FORBIDDEN);
//	}

}
