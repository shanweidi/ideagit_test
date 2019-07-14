package cn.xiaoshan.dao;

import cn.xiaoshan.domain.User;

import java.util.List;

public interface UserDao {

    // 这是远程dev分支的UserDao
    List<User> findAll();
}
