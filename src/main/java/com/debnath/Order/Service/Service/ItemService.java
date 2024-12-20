package com.debnath.Order.Service.Service;

import com.debnath.Order.Service.dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAllItem();

    ItemDto getItem(Long id);

    ItemDto createItem(ItemDto itemDto);

    ItemDto updateItem(ItemDto itemDto);

    Boolean deleteItem(Long id);
}
