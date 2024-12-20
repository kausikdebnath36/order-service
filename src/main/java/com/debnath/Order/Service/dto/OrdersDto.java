package com.debnath.Order.Service.dto;

import com.debnath.Order.Service.util.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersDto {
    private Long id;

    private List<ItemDto> itemList;

    private Status status;

    private  double totalPrice;


}
