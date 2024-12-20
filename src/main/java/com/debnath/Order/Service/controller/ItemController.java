package com.debnath.Order.Service.controller;

import com.debnath.Order.Service.Service.Impl.ItemServiceImpl;
import com.debnath.Order.Service.dto.ItemDto;
import com.debnath.Order.Service.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/order")
public class ItemController {   

    private ItemServiceImpl itemService;

    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    @RequestMapping("/getItem/all")
    public List<ItemDto> getAllItem(){
        return itemService.getAllItem();
    }

    @GetMapping
    @RequestMapping("/getItem")
    public ItemDto getItem(@RequestParam(name="id") Long id){
        return itemService.getItem(id);
    }

    @PostMapping
    public ItemDto addItem(@RequestBody ItemDto itemDto){
        return itemService.createItem(itemDto);
    }

    @PutMapping
    public ItemDto updateItem(@RequestBody ItemDto itemDto){
        return itemService.updateItem(itemDto);
    }

    @DeleteMapping
    public Boolean deleteItem(Long id){
        return itemService.deleteItem(id);
    }
}
