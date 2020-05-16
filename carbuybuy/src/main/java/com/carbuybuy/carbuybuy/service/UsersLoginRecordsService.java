package com.carbuybuy.carbuybuy.service;

import com.carbuybuy.carbuybuy.entity.UsersLoginRecords;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersLoginRecordsService {

    List<UsersLoginRecords> selectAll();

    UsersLoginRecords selectByUserId(String userId);

    void insert(UsersLoginRecords usersLoginRecords);

    void updateUserLoginRecord(UsersLoginRecords usersLoginRecords);

    void updateIp(UsersLoginRecords  usersLoginRecords);




}
