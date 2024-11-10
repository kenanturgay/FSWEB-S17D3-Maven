package com.workintech.zoo.controller;


import com.workintech.zoo.entity.GENDER;
import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import com.workintech.zoo.validations.ZooKangarooValidation;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Integer, Kangaroo> kangoroos;

    @PostConstruct
    public void init() {

        log.info("Start");
        this.kangoroos=new HashMap<>();
        this.kangoroos.put(1,new Kangaroo(1,"Bush",0.4,13.7, "Male",true));
        this.kangoroos.put(2,new Kangaroo(2,"Busher",0.4,13.7, "Male",true));
        this.kangoroos.put(3,new Kangaroo(3,"Bushex",0.4,13.7, "Male",true));
        this.kangoroos.put(4,new Kangaroo(4,"Bushfer",0.4,13.7, "Male",true));
        this.kangoroos.put(5,new Kangaroo(5,"Bushger",0.4,13.7, "Male",true));
        log.info("End");
    }

    @GetMapping
    public List<Kangaroo> find(){
        return this.kangoroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo find(@PathVariable("id") Integer id){

        ZooKangarooValidation.isValid(id);
        ZooKangarooValidation.checkKangarooExistence(kangoroos,id,true);

        return this.kangoroos.get(id);
    }

    @PostMapping
    public void addKangaroo(@RequestBody Kangaroo kangaroo){
            ZooKangarooValidation.checkKangarooExistence(kangoroos,kangaroo.getId(),false);
            ZooKangarooValidation.checkKangarooWeight(kangaroo.getWeight());
            kangoroos.put(kangaroo.getId(), kangaroo);
    }

    @PutMapping("/{id}")
    public Kangaroo updateKangaroo(@PathVariable("id") Integer id, @RequestBody Kangaroo newKangaroo){
        ZooKangarooValidation.isValid(id);
        ZooKangarooValidation.checkKangarooWeight(newKangaroo.getWeight());
        newKangaroo.setId(id);

        if(kangoroos.containsKey(id)){
            kangoroos.put(id,newKangaroo);
            return kangoroos.get(id);
        }else{
            return null;
        }


    }



    @DeleteMapping("/{id}")
    public Kangaroo deleteKangaroo(@PathVariable("id") int id){
        ZooKangarooValidation.isValid(id);
        ZooKangarooValidation.checkKangarooExistence(kangoroos,id,true);
        return this.kangoroos.remove(id);
    }
}
