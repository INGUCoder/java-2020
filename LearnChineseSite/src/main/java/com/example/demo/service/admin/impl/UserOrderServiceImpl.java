package com.example.demo.service.admin.impl;

import com.example.demo.domain.UserOrder;
import com.example.demo.mapper.UserOrderMapper;
import com.example.demo.service.admin.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Autowired
    private UserOrderMapper userOrderMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(UserOrder record) {
        return this.userOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(UserOrder record) {
        return 0;
    }

    @Override
    public List<UserOrder> selectByUserId(String userId) {
        return this.userOrderMapper.selectByUserId(userId);
    }

    @Override
    public List<UserOrder> selectAll() {
        return this.userOrderMapper.selectAll();
    }

    @Override
    public UserOrder selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(UserOrder record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserOrder record) {
        return 0;
    }
}
