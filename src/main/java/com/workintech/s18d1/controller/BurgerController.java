package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/workintech")
public class BurgerController {
    BurgerDaoImpl burgerDaoImpl;

    @Autowired
    public BurgerController(BurgerDaoImpl burgerDaoImpl){
        this.burgerDaoImpl = burgerDaoImpl;
    }

    @GetMapping("/burgers")
    public List<Burger> getBurgers(){
        return burgerDaoImpl.findAll();
    }
    @GetMapping("/burgers/{id}")
    public Burger getBurgerById(@PathVariable Integer id){
        return burgerDaoImpl.findById(id);
    }
    @PostMapping("/burgers")
    public Burger addBurger(@RequestBody Burger burger){
        return burgerDaoImpl.save(burger);
    }
    @PutMapping("/burgers/{id}")
    public Burger updateBurger(@PathVariable Integer id, @RequestBody Burger burger){
        Burger oldBurger = burgerDaoImpl.findById(id);
        oldBurger.setVegan(burger.isVegan());
        oldBurger.setName(burger.getName());
        oldBurger.setPrice(burger.getPrice());
        oldBurger.setBreadType(burger.getBreadType());
        oldBurger.setContents(burger.getContents());
        return burgerDaoImpl.save(oldBurger);
    }
    @DeleteMapping("/burgers/{id}")
    public Burger deleteBurger(@PathVariable Integer id){
        return burgerDaoImpl.remove(id);
    }
    @GetMapping("/burgers/findByPrice")
    public List<Burger> findByPrice(@RequestBody double price){
        return burgerDaoImpl.findByPrice(price);
    }
    @GetMapping("/burgers/findByBreadType")
    public List<Burger> findByPrice(@RequestBody BreadType breadType){
        return burgerDaoImpl.findByBreadType(breadType);
    }
    @GetMapping("/burgers/findByContent")
    public List<Burger> findByPrice(@RequestBody String content){
        return burgerDaoImpl.findByContent(content);
    }
}
