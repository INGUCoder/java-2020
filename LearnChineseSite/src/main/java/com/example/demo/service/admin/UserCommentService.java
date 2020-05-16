package com.example.demo.service.admin;

import com.example.demo.domain.UserComment;

import java.util.List;

public interface UserCommentService {

    int deleteByPrimaryKey(String id);

    int insert(UserComment record);

    int insertSelective(UserComment record);

    UserComment selectByPrimaryKey(String id);

    List<UserComment> selectAllByStatus();

    int updateByPrimaryKeySelective(UserComment record);

    int updateByPrimaryKey(UserComment record);

    List<UserComment> selectAll();

}
