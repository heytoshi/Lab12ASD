package edu.miu.cs489.tsogt.lab_12.advice;

import edu.miu.cs489.tsogt.lab_12.exception.PatientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class Lab7WebAPIExceptionHandler {

    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handlePublisherNotFoundException(PatientNotFoundException patientNotFoundException) {
        Map<String , String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("errorMessage", patientNotFoundException.getMessage());
        return errorMessageMap;
    }
}
