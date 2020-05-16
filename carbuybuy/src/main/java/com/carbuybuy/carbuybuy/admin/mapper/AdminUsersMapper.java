package com.carbuybuy.carbuybuy.admin.mapper;

import com.carbuybuy.carbuybuy.admin.entity.AdminUsers;


import java.util.List;

public interface AdminUsersMapper {

    List<AdminUsers> selectAll();

    AdminUsers selectById(Integer id);

    AdminUsers selectByName(String name);

    void insert(AdminUsers adminUsers);

}
