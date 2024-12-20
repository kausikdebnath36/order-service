package com.debnath.Order.Service.Service.Impl;

import com.debnath.Order.Service.Service.ItemService;
import com.debnath.Order.Service.dto.ItemDto;
import com.debnath.Order.Service.entity.Item;
import com.debnath.Order.Service.mapper.ItemMapper;
import com.debnath.Order.Service.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<ItemDto> getAllItem() {
        List<Item> items=itemRepository.findAll();
        return items.stream().map(list-> ItemMapper.mapToItemDto(list)).collect(Collectors.toList());
    }

    @Override
    public ItemDto getItem(Long id) {
        Item item=itemRepository.findById(id).orElseThrow(()->new RuntimeException("Item Doesn't Exist"));
        return ItemMapper.mapToItemDto(item);
    }

    @Override
    public ItemDto createItem(ItemDto itemDto) {
        Item item=ItemMapper.mapToItem(itemDto);
        Item saved=itemRepository.save(item);
        log.info("Item created",itemDto);
        return ItemMapper.mapToItemDto(saved);
    }

    @Override
    public ItemDto updateItem(ItemDto itemDto) {
        Item item=itemRepository.findById(itemDto.getId()).orElseThrow(()->new RuntimeException("No such Item Exists!"));
        item.setName(itemDto.getName());
        item.setCategory(itemDto.getCategory());
        item.setDescription(itemDto.getDescription());
        item.setPrice(itemDto.getPrice());
        Item saved= itemRepository.save(item);
        log.info("Item updated",saved);
        return ItemMapper.mapToItemDto(saved);
    }

    @Override
    public Boolean deleteItem(Long id) {
        Item item=itemRepository.findById(id).orElseThrow(()->new RuntimeException("No such Item Exists!"));
        log.info("Deleting",item);
        itemRepository.delete(item);
        return itemRepository.findById(id).isEmpty();
    }
}
