package com.example.demo.service.impl;

import com.example.demo.domain.Users;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int insert(Users record) {
        return this.usersMapper.insert(record);
    }

    @Override
    public int insertSelective(Users record) {
        return this.usersMapper.insertSelective(record);
    }

    @Override
    public List<Users> selectByLimit() {
        return this.usersMapper.selectByLimit();
    }

    @Override
    public List<Users> selectAll() {
        return null;
    }

    @Override
    public Users selectByAccount(String account) {
        return usersMapper.selectByAccount(account);
    }

    @Override
    public Users selectById(String id) {
        return usersMapper.selectById(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return usersMapper.updateByPrimaryKeySelective(record);
    }


}
