package com.carbuybuy.carbuybuy.service.impl;

import com.carbuybuy.carbuybuy.entity.Users;
import com.carbuybuy.carbuybuy.mapper.UsersMapper;
import com.carbuybuy.carbuybuy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> selectAll() {

        return usersMapper.selectAll();
    }

    @Override
    public void addUser(Users users) {
        usersMapper.insert(users);
    }

    @Override
    public Users selectByName(String name) {
        return usersMapper.selectByName(name);
    }

    @Override
    public Users selectByPhone(String phone) {
        return usersMapper.selectByPhone(phone);
    }

    @Override
    public Users selectByUserId(String userId) {
        return usersMapper.selectByUserId(userId);
    }

    @Override
    public void updatePoints(Users users) {
        usersMapper.updatePoints(users);
    }

    @Override
    public void updateOrders(Users users) {
        this.usersMapper.updateOrders(users);
    }

    @Override
    public void updateCollects(Users users) {
        this.usersMapper.updateCollects(users);
    }

    @Override
    public void updatePassword(Users users) {
        this.usersMapper.updatePassword(users);
    }

    @Override
    public void updatePhone(Users users) {
        this.usersMapper.updatePhone(users);
    }

    @Override
    public void updateStatus(Users users) {
        this.usersMapper.updateStatus(users);
    }

    @Override
    public void deleteUser(Users users) {
        this.usersMapper.deleteUser(users);
    }
}
