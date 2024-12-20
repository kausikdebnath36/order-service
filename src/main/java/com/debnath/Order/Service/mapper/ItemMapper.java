package com.debnath.Order.Service.mapper;

import com.debnath.Order.Service.dto.ItemDto;
import com.debnath.Order.Service.entity.Item;

import java.util.stream.DoubleStream;

public class ItemMapper {
    public static Item mapToItem(ItemDto itemDto) {
        return new Item(
             itemDto.getId(),
             itemDto.getName(),
             itemDto.getCategory(),
             itemDto.getDescription(),
             itemDto.getPrice()
        );
    }

    public static ItemDto mapToItemDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getCategory(),
                item.getDescription(),
                item.getPrice()
        );
    }
}
