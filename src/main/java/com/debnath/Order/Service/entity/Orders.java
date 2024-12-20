package com.debnath.Order.Service.entity;

import com.debnath.Order.Service.util.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Item> itemList;

    @Column(name = "status", nullable=false, length = 20, columnDefinition = "varchar(20) default 'PENDING'")
    private Status status;

    private  double totalPrice;



}
