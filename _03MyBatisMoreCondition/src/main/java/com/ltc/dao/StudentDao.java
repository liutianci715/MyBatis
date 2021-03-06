package com.ltc.dao;

import com.ltc.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    /**
     * 如果前台表单中给出的查询条件不能封装成一个对象的时候，
     * 我们可以使用两种方式来解决这个问题！
     *
     * 第一种方式
     *   01.把查询条件 封装成map
     *    使用map 查询 姓名中带  小  并且年龄大于100的学生信息
     *
     *   02.使用map 查询 姓名中带  小 ，年龄大于100 并且id 大于小白id的 学生信息
     */

    List<Student> selectStudentByMap(Map<String,Object> map);


    /**
     * 第二种方式  使用注解
     *   查询 姓名中带  小  并且年龄大于100的学生信息
     */
    List<Student> selectStudentsByCondition(String name,int age);


    /**
     * 第三种方式  使用Param注解
     */

    List<Student> findStudentByParams(@Param("name") String name,@Param("id") int id);






}
