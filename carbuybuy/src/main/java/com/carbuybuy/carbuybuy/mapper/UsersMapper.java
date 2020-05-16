package com.carbuybuy.carbuybuy.mapper;
import com.carbuybuy.carbuybuy.entity.Users;

import java.util.List;

public interface UsersMapper {

    List<Users> selectAll();

    int insert(Users users);

    Users selectByName(String name);

    Users selectByPhone(String phone);

    Users selectByUserId(String userId);

    void updatePoints(Users users);

    void updateOrders(Users users);

    void updateCollects(Users users);

    void updatePassword(Users users);

    void updatePhone(Users users);

    void updateStatus(Users users);

    void deleteUser(Users users);

}