package com.example.demo.mapper;

import com.example.demo.domain.Users;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByAccount(String id);

    Users selectById(String id);

    List<Users> selectByLimit();

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}