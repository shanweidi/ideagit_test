package cn.xiaoshan.dao;

import cn.xiaoshan.domain.Role;

import java.util.List;

public interface RoleDao {

    // 查询所有角色,同时显示有该角色的用户信息
    List<Role> findAll();
}
