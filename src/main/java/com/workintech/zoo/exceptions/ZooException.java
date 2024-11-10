package com.workintech.zoo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;


@Getter
@Setter
public class ZooException extends RuntimeException{


    private HttpStatus httpStatus;

    public ZooException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }


}
