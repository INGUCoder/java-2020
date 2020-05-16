package com.carbuybuy.carbuybuy.admin.service;

import com.carbuybuy.carbuybuy.admin.entity.AdminUsers;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminUsersService {

    List<AdminUsers> selectAll();

    AdminUsers selectById(Integer id);

    AdminUsers selectByrName(String name);

    void insert(AdminUsers adminUsers);



}
