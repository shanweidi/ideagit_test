package cn.xiaoshan.dao;

import cn.xiaoshan.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();
}
