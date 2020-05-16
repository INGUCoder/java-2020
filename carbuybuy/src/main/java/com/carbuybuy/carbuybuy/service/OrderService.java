package com.carbuybuy.carbuybuy.service;

import com.carbuybuy.carbuybuy.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    List<Orders> selectAll();

    Orders selectById(Integer id);

    void insert(Orders orders);

    Orders selectByOrderId(String orderId);

    void updateOrderStatus(Orders orders);

    void deleteOrder(Orders orders);

}
