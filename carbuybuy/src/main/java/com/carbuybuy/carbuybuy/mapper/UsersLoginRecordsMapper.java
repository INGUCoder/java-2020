package com.carbuybuy.carbuybuy.mapper;

import com.carbuybuy.carbuybuy.entity.UsersLoginRecords;

import java.util.List;

public interface UsersLoginRecordsMapper {
    List<UsersLoginRecords> selectAll();

    UsersLoginRecords selectByUserId(String userId);

    void insert (UsersLoginRecords usersLoginRecords);

    void updateUserLoginRecord(UsersLoginRecords  usersLoginRecords);

    void updateIp(UsersLoginRecords  usersLoginRecords);


}
