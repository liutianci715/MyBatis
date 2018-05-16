package com.ltc.dao;

import com.ltc.bean.User;
import com.ltc.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class UserMapperImpl implements UserMapper{

    //公共的session对象
    //获取SqlSession

    SqlSession session = null;
    @Override
    public void addUser(User user) {
        try {
            //获取SqlSession
            session= SqlSessionFactoryUtil.getSession();
            session.insert("addUser",user);  //新增用户
            //提交事务
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();  //回滚
        }finally {
            session.close();
        }

}

    @Override
    public void addUserByCached(User user) {
        try {
            //获取SqlSession
            session= SqlSessionFactoryUtil.getSession();
            session.insert("addUserByCached",user);  //新增用户
            //提交事务
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();  //回滚
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(Serializable id) {
        try {
            //获取SqlSession
            session= SqlSessionFactoryUtil.getSession();
            session.insert("deleteUser",id);  //删除用户
            //提交事务
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();  //回滚
        }finally {
            session.close();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            //获取SqlSession
            session= SqlSessionFactoryUtil.getSession();
            session.insert("updateUser",user);  //更新用户
            //提交事务
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();  //回滚
        }finally {
            session.close();
        }
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = null;
        try {
            //获取SqlSession
            session= SqlSessionFactoryUtil.getSession();
            //查询所有操作
            users = session.selectList("selectAllUsers");
           /* //提交事务
            session.commit();*/
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();  //回滚
        }finally {
            session.close();
        }
        return users;
    }

    /**
     * 查询所有返回map集合
     */

    @Override
    public Map<String, Object> selectAllByMap() {
        Map<String,Object> users = null;
        try {
            //获取SqlSession
            session= SqlSessionFactoryUtil.getSession();
            /**
             *  查询所有操作 返回map
             *     s1: map集合中的key
             */
            users = session.selectMap("selectAllByMap","userName");

        }catch (Exception e){
            e.printStackTrace();
            session.rollback();  //回滚
        }finally {
            session.close();
        }
        return users;
    }

    /**
     * 查询指定id的学生
     *
     * @param id
     */
    @Override
    public User selectUserStudentById(Serializable id) {
        User user = null;
        try {
            //获取SqlSession
            session= SqlSessionFactoryUtil.getSession();
            user = session.selectOne("selectUserStudentById",id);
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();  //回滚
        }finally {
            session.close();
        }
        return user;
    }

    /**
     * 根据姓名模糊查询
     *
     * @param name
     */
    @Override
    public List<User> selectByName(String name) {
        List<User> users=null;
        try {
            //获取SqlSession
            session= SqlSessionFactoryUtil.getSession();
            //查询所有操作
            users = session.selectList("selectByName",name);
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();  //回滚
        }finally {
            session.close();
        }
        return users;
    }
}
