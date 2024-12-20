package com.debnath.Order.Service.Service.Impl;

import com.debnath.Order.Service.Service.OrdersService;
import com.debnath.Order.Service.dto.ItemDto;
import com.debnath.Order.Service.dto.OrdersDto;
import com.debnath.Order.Service.entity.Orders;
import com.debnath.Order.Service.mapper.ItemMapper;
import com.debnath.Order.Service.mapper.OrdersMapper;
import com.debnath.Order.Service.repository.OrdersRepository;
import com.debnath.Order.Service.util.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<OrdersDto> getAllOrders() {
        List<Orders> ordersList=ordersRepository.findAll();
        return ordersList.stream().map((list)-> OrdersMapper.mapToOrdersDto(list)).collect(Collectors.toList());
    }

    @Override
    public OrdersDto getOrders(Long id) {
        Orders orders=ordersRepository.findById(id).orElseThrow(()-> new RuntimeException("OrderId Not Found...!"));
        return  OrdersMapper.mapToOrdersDto(orders);
    }

    @Override
    public OrdersDto createOrder(OrdersDto ordersDto) {
        if(ordersRepository.findById(ordersDto.getId()).isPresent()){
            throw new RuntimeException("Order with same Id is Present");
        }
        Orders orders=OrdersMapper.mapToOrders(ordersDto);
        orders.setStatus(Status.PENDING);
        List<Double> totalPrice=ordersDto.getItemList().stream().map((list)-> list.getPrice()).collect(Collectors.toList());
        double sum=totalPrice.stream().mapToDouble(Double::doubleValue).sum();
        orders.setTotalPrice(sum);
        Orders saved=ordersRepository.save(orders);
        return OrdersMapper.mapToOrdersDto(saved);
    }

    @Override
    public OrdersDto updateOrders(OrdersDto ordersDto) {

        Orders orders=ordersRepository.findById(ordersDto.getId()).orElseThrow(()->new RuntimeException("Order Doesn't Exist"));
        //if order is pending then only can be changed
        if(orders.getStatus().equals("PENDING")) {
            orders.setItemList(ordersDto.getItemList().stream().map((list) -> ItemMapper.mapToItem(list)).collect(Collectors.toList()));
            //Adding Price
            List<Double> price = ordersDto.getItemList().stream().map((list) -> list.getPrice()).collect(Collectors.toList());
            double sum = price.stream().mapToDouble(Double::doubleValue).sum();
            orders.setTotalPrice(sum);
        }
        else {
            throw new RuntimeException("Order Status is"+orders.getStatus());
        }
        Orders saved=ordersRepository.save(orders);
        return OrdersMapper.mapToOrdersDto(saved);
    }

    @Override
    public Boolean deleteOrders(Long id) {
        Orders orders=ordersRepository.findById(id).orElseThrow(()->new RuntimeException("Order Doesn't Exists"));
        ordersRepository.delete(orders);

        return ordersRepository.findById(id).isEmpty();
    }


}
