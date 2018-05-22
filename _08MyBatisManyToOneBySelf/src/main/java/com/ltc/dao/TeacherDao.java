package com.ltc.dao;

import com.ltc.bean.Teacher;

import java.io.Serializable;

public interface TeacherDao {

    /**
     * 根据老师的编号 查询  所有导师的信息
     * 递归查询
     */

    Teacher selectTeachersById(Serializable id);
}
