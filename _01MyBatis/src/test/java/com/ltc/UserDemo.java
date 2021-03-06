package com.ltc;

import com.ltc.bean.User;
import com.ltc.dao.UserMapper;
import com.ltc.dao.UserMapperImpl;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;


public class UserDemo {

    UserMapper mapper = null;
    Logger log= Logger.getLogger(UserDemo.class);

    @Before
    public  void before(){
       mapper = new UserMapperImpl();
   }
/*
新增用户
 */
@Test
    public void addUser(){
    User user = new User("小拜拜","admin");
    mapper.addUser(user);
    //没有id是因为数据库中已经设置了 主键自增  我们能不能获取新增的id
    System.out.println(user.getUserId());
}

/*
*新增用户
*返回id值
*/
@Test
public void addUserByCached(){
    User user = new User("嘿嘿","123456");
    mapper.addUserByCached(user);
    //没有id是因为数据库中已经设置了 主键自增  我们能不能获取新增的id
    System.out.println(user.getUserId());
}

/**
 *通过id删除用户
 */
@Test
    public void  deleteUser(){
    mapper.deleteUser(2);
}

/**
 * 更新用户
 */
@Test

    public void updateUser(){
    User user = new User(4,"小黑","123456");
    mapper.updateUser(user);
}

/**
 * 查询所有用户
 */
@Test
    public void selectAllUsers(){
    List<User> users = null;
    users = mapper.selectAllUsers();
    for(int i=0;i<users.size();i++){
        System.out.println(users.get(i));
    }
}

@Test
    public void selectAllByMap(){
    Map<String,Object> users = null;
    users = mapper.selectAllByMap();
    System.out.println(users);
}

@Test
    public void selectUserStudentById(){
        User user = null;
        user = mapper.selectUserStudentById(1);
        System.out.println(user);
}

@Test
    public  void selectByName(){
    List<User> users=null;
    users = mapper.selectByName("黑");
    System.out.println(users);
}

















}
