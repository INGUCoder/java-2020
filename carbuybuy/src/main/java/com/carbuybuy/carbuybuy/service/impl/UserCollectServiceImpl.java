package com.carbuybuy.carbuybuy.service.impl;

import com.carbuybuy.carbuybuy.entity.UserCollect;
import com.carbuybuy.carbuybuy.mapper.UserCollectMapper;
import com.carbuybuy.carbuybuy.service.UserCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCollectServiceImpl implements UserCollectService {

    @Autowired
    private UserCollectMapper userCollectMapper;

    @Override
    public List<UserCollect> selectAll() {
        return this.userCollectMapper.selectAll();
    }

    @Override
    public UserCollect selectById(Integer id) {
        return this.userCollectMapper.selectById(id);
    }

    @Override
    public List<UserCollect> selectByUserId(String userId) {
        return this.userCollectMapper.selectByUserId(userId);
    }

    @Override
    public void insert(UserCollect userCollect) {
        this.userCollectMapper.insert(userCollect);
    }

    @Override
    public UserCollect selectByIdAndUserId(String userId, Integer carId) {
        return this.userCollectMapper.selectByIdAndUserId(userId, carId);
    }
}
