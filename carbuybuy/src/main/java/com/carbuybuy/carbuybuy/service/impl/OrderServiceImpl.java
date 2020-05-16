package com.carbuybuy.carbuybuy.service.impl;

import com.carbuybuy.carbuybuy.entity.Orders;
import com.carbuybuy.carbuybuy.mapper.OrdersMapper;
import com.carbuybuy.carbuybuy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public List<Orders> selectAll() {
        return ordersMapper.selectAll();
    }

    @Override
    public Orders selectById(Integer id) {
        return ordersMapper.selectById(id);
    }

    @Override
    public void insert(Orders orders) {
        ordersMapper.insert(orders);
    }

    @Override
    public Orders selectByOrderId(String orderId) {
       return this.ordersMapper.selectByOrderId(orderId);
    }

    @Override
    public void updateOrderStatus(Orders orders) {
        this.ordersMapper.updateOrderStatus(orders);
    }

    @Override
    public void deleteOrder(Orders orders) {

        this.ordersMapper.deleteOrder(orders);
    }


}
