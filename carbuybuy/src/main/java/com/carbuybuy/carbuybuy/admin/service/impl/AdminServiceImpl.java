package com.carbuybuy.carbuybuy.admin.service.impl;

import com.carbuybuy.carbuybuy.admin.entity.AdminUsers;
import com.carbuybuy.carbuybuy.admin.mapper.AdminUsersMapper;
import com.carbuybuy.carbuybuy.admin.service.AdminUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminUsersService {

    @Autowired
    private AdminUsersMapper adminUsersMapper;

    @Override
    public List<AdminUsers> selectAll() {
        return this.adminUsersMapper.selectAll();
    }

    @Override
    public AdminUsers selectById(Integer id) {
        return this.adminUsersMapper.selectById(id);
    }

    @Override
    public AdminUsers selectByrName(String name) {
        return this.adminUsersMapper.selectByName(name);
    }


    @Override
    public void insert(AdminUsers adminUsers) {
        this.adminUsersMapper.insert(adminUsers);
    }
}
