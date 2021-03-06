package com.ltc.dao;

import com.ltc.bean.Student;
import com.ltc.bean.Teacher;

import java.io.Serializable;

public interface TeacherDao {

    /**
     * 根据学生的编号 查询出对应的所有老师信息
     */
    Student selectTeachersBySid(Serializable id);
    /**
     * 根据老师的编号 查询出对应的所有学生信息
     */
    Teacher selectStudentsByTid(Serializable id);
}
