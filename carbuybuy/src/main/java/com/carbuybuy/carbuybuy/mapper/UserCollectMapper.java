package com.carbuybuy.carbuybuy.mapper;


import com.carbuybuy.carbuybuy.entity.UserCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCollectMapper {

    List<UserCollect> selectAll();

    UserCollect selectById(Integer id);

    List<UserCollect> selectByUserId(String userId);

    void insert(UserCollect userCollect);

    UserCollect selectByIdAndUserId(@Param("userId") String userId, @Param("carId") Integer carId);

}
