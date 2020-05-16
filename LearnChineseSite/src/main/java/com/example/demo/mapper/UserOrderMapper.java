package com.example.demo.mapper;

import com.example.demo.domain.UserOrder;

import java.util.List;

public interface UserOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserOrder record);

    int insertSelective(UserOrder record);
    List<UserOrder> selectByUserId(String userId);

    List<UserOrder> selectAll();

    UserOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserOrder record);

    int updateByPrimaryKey(UserOrder record);
}