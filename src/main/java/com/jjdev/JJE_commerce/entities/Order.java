package com.jjdev.JJE_commerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jjdev.JJE_commerce.entities.enums.OrderStatus;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;


    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> orderItems = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;


    public Order(){}

    public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        setOrderStatus(orderStatus);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
         if(orderStatus != null){
             this.orderStatus = orderStatus.getCode();
         }
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getTotal(){
        double sum = 0;
        for (OrderItem x : orderItems){
            sum += x.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
