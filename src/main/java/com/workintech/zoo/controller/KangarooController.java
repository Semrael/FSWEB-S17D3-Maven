package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import jakarta.annotation.PostConstruct;
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

        }
        if (!kangaroos.containsKey(id)) {

        }
        return kangaroos.get(id);
    }

    @PostMapping
    public Kangaroo create(@RequestBody Kangaroo kangaroo){
        kangaroos.put(kangaroo.getId(),kangaroo);
        return kangaroos.get(kangaroo.getId());
    }

    @PutMapping("/id")
    public Kangaroo update(@PathVariable long id, @RequestBody Kangaroo kangaroo){
      this.kangaroos.replace(id,kangaroo);
      return this.kangaroos.get(id);
    }

    @DeleteMapping("/{id}")
    public Kangaroo remove(@PathVariable Long id){
        return this.kangaroos.remove(id);
    }
}
