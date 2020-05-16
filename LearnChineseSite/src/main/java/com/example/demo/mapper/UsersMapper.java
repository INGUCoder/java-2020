package com.example.demo.mapper;

import com.example.demo.domain.Users;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectAll();

    Users selectByUserName(String userName);

    Users selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}