package com.ltc.dao;

import com.ltc.bean.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    /*
   * 新增用户
   * */
    void addUser(User user);

    /*
    * 新增用户
    * 返回用户id
    *
    */
    void addUserByCached(User user);

    /**
     * 删除
     */
    void deleteUser(Serializable id);

    /**
     * 修改
     */
    void updateUser(User user);


    /**
     *   查询所有
     */
    List<User> selectAllUsers();

    /**
     查询所有返回map集合
     */
    Map<String,Object> selectAllByMap();

    /**
     查询指定id的学生
     */
    User selectUserStudentById(Serializable id);
    /**
     根据姓名模糊查询
     */
    List<User> selectByName(String name);
}
