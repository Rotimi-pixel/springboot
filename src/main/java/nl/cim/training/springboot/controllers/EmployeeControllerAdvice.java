package nl.cim.training.springboot.controllers;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import nl.cim.training.springboot.dto.ErrorResponse;
import nl.cim.training.springboot.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Set;
import java.util.List;


@ControllerAdvice
public class EmployeeControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleEmployeeNotFound(EmployeeNotFoundException nfe) {





        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("EMPLOYEE_NOT_FOUND");
        errorResponse.setErrorMessage(nfe.getMessage());

        return new ResponseEntity<ErrorResponse>(
                errorResponse,
                HttpStatus.BAD_REQUEST
                );


    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErrorResponse> handleConstraintValidationException(ConstraintViolationException nfe) {
        Set<ConstraintViolation<?>> violations = nfe.getConstraintViolations();
        List<String> violationsSting = violations.stream()
                .map(ConstraintViolation::getMessage)
     //           .filter(msg -> StringUtils.isNotBlank(msg))
                .toList();

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("BAD_INPUT");
        errorResponse.setErrorMessage(violationsSting);


        return new ResponseEntity<>(
                errorResponse,
                HttpStatus.BAD_REQUEST
        );
    }
}
