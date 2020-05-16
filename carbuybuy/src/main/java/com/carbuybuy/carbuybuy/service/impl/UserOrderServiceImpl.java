package com.carbuybuy.carbuybuy.service.impl;

import com.carbuybuy.carbuybuy.entity.UserOrder;
import com.carbuybuy.carbuybuy.mapper.UserOrderMapper;
import com.carbuybuy.carbuybuy.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public List<UserOrder> selectAll() {
        return this.userOrderMapper.selectAll();
    }

    @Override
    public UserOrder selectById(Integer id) {
        return this.userOrderMapper.selectById(id);
    }

    @Override
    public List<UserOrder> selectByUserId(String userId) {
        return this.userOrderMapper.selectByUserId(userId);
    }

    @Override
    public void insert(UserOrder userCollect) {
        this.userOrderMapper.insert(userCollect);
    }
}
