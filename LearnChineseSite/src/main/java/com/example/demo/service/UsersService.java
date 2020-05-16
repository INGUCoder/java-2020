package com.example.demo.service;

import com.example.demo.domain.Users;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsersService {
    int deleteByPrimaryKey(String id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String id);

    List<Users> selectAll();

    Users selectByUserName(String userName);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}
