package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import jakarta.annotation.PostConstruct;
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
    @GetMapping
    public List<Koala> findAll(){
        return koalas.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Koala finId(@PathVariable Long id){
        if(id<=0){

        }
        if(!koalas.containsKey(id)){

        }
        return koalas.get(id);
    }
    @PostMapping
    public Koala create(@RequestBody Koala koala){
        koalas.put(koala.getId(),koala);
        return koalas.get(koala.getId());
    }
    @PutMapping("/{id}")
    public Koala update(@PathVariable Long id,@RequestBody Koala koala){
        this.koalas.replace(id,koala);
        return this.koalas.get(id);

    }
    @DeleteMapping("/{id}")
    public Koala remove(@PathVariable Long id){
        return this.koalas.remove(id);
    }

}
