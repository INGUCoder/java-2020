package com.example.demo.mapper;

import com.example.demo.domain.UserUgc;
import com.example.demo.service.admin.UGCService;

import java.util.List;

public interface UserUgcMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserUgc record);

    int insertSelective(UserUgc record);

    List<UserUgc> selectAll();

    List<UserUgc> selectByUserId(String userId);

    UserUgc selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserUgc record);

    int updateByPrimaryKey(UserUgc record);

    List<UserUgc> selectByStatus();
}