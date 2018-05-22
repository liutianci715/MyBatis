package com.ltc.dao;

import com.ltc.bean.Teacher;

import java.io.Serializable;

public interface TeacherDao {

    /**
     * 根据id查询指定的老师信息
     */
    Teacher selectTeacherByID(Serializable id);

    /**
     * 新增teacher
     */
    void   insertTeacher(Teacher teacher);

}
