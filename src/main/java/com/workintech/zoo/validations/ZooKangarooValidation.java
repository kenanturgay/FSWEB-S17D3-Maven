package com.workintech.zoo.validations;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooKangarooValidation {
    public static void isValid(Integer id) {
        if(id<=0 || id == null){
            throw new ZooException("Is is not valid: " + id, HttpStatus.BAD_REQUEST);
        }

    }


    public static void checkKangarooExistence(Map<Integer, Kangaroo> kangoroos, Integer id, boolean existence) {

        if(existence){
            if(!kangoroos.containsKey(id)){
                throw new ZooException("Zoo with given id is not found " + id , HttpStatus.NOT_FOUND);
            }
        }else{
            if(kangoroos.containsKey(id)){
                throw new ZooException("Zoo with given id is already exists " + id , HttpStatus.BAD_REQUEST);
            }
        }
    }

    public static void checkKangarooWeight(Double weight) {

        if((weight == null) || (weight <= 0)){
            throw new ZooException("Weight is not valid: " + weight, HttpStatus.BAD_REQUEST);
        }
    }
}
