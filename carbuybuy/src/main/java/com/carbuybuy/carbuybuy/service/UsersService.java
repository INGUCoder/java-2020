package com.carbuybuy.carbuybuy.service;

import com.carbuybuy.carbuybuy.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {
    //查询所有用户信息
    List<Users> selectAll();

    //插入新用户
    void addUser(Users users);

    //查询用户 根据账号
    Users selectByName(String name);

    //查询用户根据手机号
    Users selectByPhone(String phone);

    //根据userId查询用户
    Users selectByUserId(String userId);

    void updatePoints(Users users);

    void updateOrders(Users users);

    void updateCollects(Users users);

    void updatePassword(Users users);

    void updatePhone(Users users);

    //更新用户状态
    void updateStatus(Users users);

    //删除用户
    void deleteUser(Users users);


}
