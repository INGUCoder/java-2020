package com.carbuybuy.carbuybuy.service;

import com.carbuybuy.carbuybuy.entity.UserCollect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserCollectService {

    List<UserCollect> selectAll();

    UserCollect selectById(Integer id);

    List<UserCollect> selectByUserId(String userId);

    void insert(UserCollect userCollect);

    UserCollect selectByIdAndUserId(String userId, Integer carId);

}
