package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {
    private Map<Long, Koala> koalas=new HashMap<>();
    @PostConstruct
    public void init(){
        koalas=new HashMap<>();
    }
//@PostConstruct
//public void init() {
//    this.koalas.put(1L, new Koala(2L,"koala1",20.0,15,"Female"));
//}
    @GetMapping
    public List<Koala> findAll(){
        return koalas.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Koala finId(@PathVariable Long id){
        if (id <= 0) {
            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        if (!koalas.containsKey(id)) {
            throw  new ZooException("Id can't found: "+id ,HttpStatus.NOT_FOUND);
        }
        return koalas.get(id);
    }
    @PostMapping
    public Koala create(@RequestBody Koala koala){
        if(koalas.containsKey(koala.getId())){
            throw new ZooException("A koala with the given ID already exists.",HttpStatus.BAD_REQUEST);
        }
        koalas.put(koala.getId(),koala);
        return koala;
        //return koalas.get(koala.getId());
    }
    @PutMapping("/{id}")
    public Koala update(@PathVariable Long id,@RequestBody Koala koala){
        if(!koalas.containsKey(id)){
            throw new ZooException("Id can't found: "+ id,HttpStatus.NOT_FOUND);
        }
        this.koalas.put(id,koala);
        return this.koalas.get(id);

    }
    @DeleteMapping("/{id}")
    public Koala remove(@PathVariable Long id){
        if(!koalas.containsKey(id)){
            throw new ZooException("Id can't found: "+ id,HttpStatus.NOT_FOUND);
        }
        return this.koalas.remove(id);
    }

}
