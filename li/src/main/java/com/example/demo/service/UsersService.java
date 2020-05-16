package com.example.demo.service;

import com.example.demo.domain.Users;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UsersService {
    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByLimit();

    List<Users> selectAll();

    Users selectByAccount(String account);

    Users selectById(String id);

    int updateByPrimaryKeySelective(Users record);
}
