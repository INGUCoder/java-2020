package com.example.demo.mapper;

import com.example.demo.domain.Admin;

import java.util.List;

public interface AdminMapper {
    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByUserName(String userName);

    List<Admin> selectAll();

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Admin admin);

    Admin selectById(String id);
}