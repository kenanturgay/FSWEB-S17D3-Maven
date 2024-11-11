package com.workintech.zoo.controller;

import com.workintech.zoo.entity.GENDER;
import com.workintech.zoo.entity.Koala;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/koalas")
public class KoalaController {
    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init() {
        log.info("Start");
        this.koalas=new HashMap<>();

        this.koalas.put(1, new Koala(1,"Goerge", 25.5,2.5, "MALE"));
        this.koalas.put(2, new Koala(2,"Goer", 25.5,2.5, "FEMALE"));
        this.koalas.put(3, new Koala(3,"Goe", 25.5,2.5, "MALE"));
        this.koalas.put(4, new Koala(4,"Gook", 29.5,3.7, "FEMALE"));
        this.koalas.put(5, new Koala(5,"Goce", 25.5,2.5, "MALE"));
        this.koalas.put(6, new Koala(6,"Gocre", 25.5,2.5, "MALE"));
        log.info("End");
    }

    @GetMapping
    public List<Koala> find(){
        return this.koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala find(@PathVariable("id") int id){
        return this.koalas.get(id);
    }

    @PostMapping
    public Koala addKoala(@RequestBody Koala koala){
        this.koalas.put(koala.getId(),koala);
        return this.koalas.get(koala.getId());
    }

    @PutMapping("/{id}")
    public Koala updateKoala(@PathVariable("id") int id, @RequestBody Koala newKoala){
        newKoala.setId(id);
        if(!this.koalas.containsKey(id)){
            koalas.put(id,newKoala);
            return koalas.get(id);
        }else{
            return addKoala(newKoala);
        }

    }

    @DeleteMapping("/{id}")
    public void deleteKoala(@PathVariable("id") int id){
        this.koalas.remove(id);
    }


}
