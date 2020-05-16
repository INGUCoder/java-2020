package com.carbuybuy.carbuybuy.service.impl;

import com.carbuybuy.carbuybuy.entity.UsersLoginRecords;
import com.carbuybuy.carbuybuy.mapper.UsersLoginRecordsMapper;
import com.carbuybuy.carbuybuy.service.UsersLoginRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersLoginRecordsServiceImpl implements UsersLoginRecordsService {

    @Autowired
    private UsersLoginRecordsMapper usersLoginRecordsMapper;

    @Override
    public List<UsersLoginRecords> selectAll() {
        return usersLoginRecordsMapper.selectAll();
    }

    @Override
    public UsersLoginRecords selectByUserId(String userId) {
        return usersLoginRecordsMapper.selectByUserId(userId);
    }

    @Override
    public void insert(UsersLoginRecords usersLoginRecords) {
        usersLoginRecordsMapper.insert(usersLoginRecords);
    }

    @Override
    public void updateUserLoginRecord(UsersLoginRecords  usersLoginRecords) {
        usersLoginRecordsMapper.updateUserLoginRecord(usersLoginRecords);
    }

    @Override
    public void updateIp(UsersLoginRecords usersLoginRecords) {
        this.usersLoginRecordsMapper.updateIp(usersLoginRecords);
    }

}
