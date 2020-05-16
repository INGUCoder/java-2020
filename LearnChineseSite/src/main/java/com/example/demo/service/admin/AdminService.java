package com.example.demo.service.admin;

import com.example.demo.domain.Admin;

import java.util.List;

public interface AdminService {
    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByUserName(String userName);

    List<Admin> selectAll();

    int deleteByPrimaryKey(String id);

    Admin selectById(String id);

    int updateByPrimaryKeySelective(Admin admin);

}
