package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Long, Kangaroo> kangaroos=new HashMap<>();
    @PostConstruct
    public void init(){
        kangaroos=new HashMap<>();
    }
    @GetMapping
    public List<Kangaroo> findAll(){
        return kangaroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo findId(@PathVariable Long id) {
        if (id <= 0) {
           throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        if (!kangaroos.containsKey(id)) {
             throw  new ZooException("Id can't found: "+id ,HttpStatus.NOT_FOUND);
        }
        return kangaroos.get(id);
    }

    ////////Buraya Tekra bak//////////////////////////////
    @PostMapping
    public Kangaroo create(@RequestBody Kangaroo kangaroo){
        if(kangaroo.getId()<=0){
            throw new ZooException("Id must be greater than 0", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(kangaroos.containsKey(kangaroo.getId())){
            throw new ZooException("A kangaroo with the given ID already exists.",HttpStatus.BAD_REQUEST);
        }
        kangaroos.put(kangaroo.getId(),kangaroo);
        return kangaroos.get(kangaroo.getId());
    }

    @PutMapping("/{id}")
    public Kangaroo update(@PathVariable long id, @RequestBody Kangaroo kangaroo){
        if (id <= 0) {
            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        if(!kangaroos.containsKey(id)){
            throw new ZooException("Id can't found: "+ id,HttpStatus.NOT_FOUND);
        }
      this.kangaroos.put(id,kangaroo);
      return this.kangaroos.get(id);
    }

    @DeleteMapping("/{id}")
    public Kangaroo remove(@PathVariable Long id){
        if (id <= 0) {
            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        if(!kangaroos.containsKey(id)){
            throw new ZooException("Id can't found: "+ id,HttpStatus.NOT_FOUND);
        }
        return this.kangaroos.remove(id);
    }
}
