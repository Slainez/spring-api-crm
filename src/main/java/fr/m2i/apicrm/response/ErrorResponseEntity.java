
package fr.m2i.apicrm.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ErrorResponseEntity {
    
    public static ResponseEntity<Object> build(String error , int status,String path , HttpStatus httpStatus) {
        return new ResponseEntity<>(new ErrorResponse(error,status,path) , new HttpHeaders(),httpStatus) ;
    }
}
