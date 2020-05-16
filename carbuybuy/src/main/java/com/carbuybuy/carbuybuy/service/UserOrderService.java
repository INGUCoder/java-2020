package com.carbuybuy.carbuybuy.service;

import com.carbuybuy.carbuybuy.entity.UserOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserOrderService {

    List<UserOrder> selectAll();

    UserOrder selectById(Integer id);

    List<UserOrder> selectByUserId(String userId);

    void insert(UserOrder userCollect);

}
