package com.example.demo.service.admin;

import com.example.demo.domain.UserUgc;

import java.util.List;

public interface UGCService {

    int deleteByPrimaryKey(String id);

    int insert(UserUgc record);

    int insertSelective(UserUgc record);

    List<UserUgc> selectAll();

    List<UserUgc> selectByUserId(String userId);

    List<UserUgc> selectByStatus();

    UserUgc selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserUgc record);

    int updateByPrimaryKey(UserUgc record);
}
