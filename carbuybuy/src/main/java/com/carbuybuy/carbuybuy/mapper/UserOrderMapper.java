package com.carbuybuy.carbuybuy.mapper;

import com.carbuybuy.carbuybuy.entity.UserOrder;

import java.util.List;

public interface UserOrderMapper {

    List<UserOrder> selectAll();

    UserOrder selectById(Integer id);

    List<UserOrder> selectByUserId(String userId);

    void insert(UserOrder userCollect);


}
