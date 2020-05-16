package com.example.demo.service.admin.impl;

import com.example.demo.domain.Admin;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int insert(Admin record) {
        return this.adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return this.adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByUserName(String userName) {
        return this.adminMapper.selectByUserName(userName);
    }

    @Override
    public List<Admin> selectAll() {
        return this.adminMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return this.adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Admin selectById(String id) {
        return this.adminMapper.selectById(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin admin) {
        return this.adminMapper.updateByPrimaryKeySelective(admin);
    }

}
