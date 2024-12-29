package com.jjdev.JJE_commerce.services;

import com.jjdev.JJE_commerce.entities.Order;
import com.jjdev.JJE_commerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> user = orderRepository.findById(id);
        return user.get();
    }
}
