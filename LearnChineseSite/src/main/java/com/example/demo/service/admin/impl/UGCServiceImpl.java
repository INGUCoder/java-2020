package com.example.demo.service.admin.impl;

import com.example.demo.domain.UserUgc;
import com.example.demo.mapper.UserUgcMapper;
import com.example.demo.service.admin.UGCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UGCServiceImpl implements UGCService {
    @Autowired
    private UserUgcMapper userUgcMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return this.userUgcMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserUgc record) {
        return this.userUgcMapper.insert(record);
    }

    @Override
    public int insertSelective(UserUgc record) {
        return 0;
    }

    @Override
    public List<UserUgc> selectAll() {
        return this.userUgcMapper.selectAll();
    }

    @Override
    public List<UserUgc> selectByUserId(String userId) {
        return this.userUgcMapper.selectByUserId(userId);
    }

    @Override
    public List<UserUgc> selectByStatus() {
        return this.userUgcMapper.selectByStatus();
    }

    @Override
    public UserUgc selectByPrimaryKey(String id) {
        return this.userUgcMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserUgc record) {
        return this.userUgcMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserUgc record) {
        return 0;
    }
}
