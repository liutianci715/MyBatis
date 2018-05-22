package com.ltc;

import com.ltc.bean.Teacher;
import com.ltc.dao.TeacherDao;
import com.ltc.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TeacherDemo {

  TeacherDao dao = null;
  SqlSession session = null;
  Logger log = Logger.getLogger(TeacherDemo.class);

    /**
     * 在所有的test测试方法执行之前 都要执行的操作
     */
    @Before
    public void before(){
        session = SessionFactoryUtil.getSession();
        dao = session.getMapper(TeacherDao.class);
    }

    @After
    public void after(){
        if(session!=null){
            session.close();
        }
    }

    @Test
    public void testSelectByTid(){
        List<Teacher> teachers = dao.selectTeachersByTid(1);
        log.debug(teachers);//会把查询结果id当成tid再次查询
        log.debug(teachers.get(0).getName());//不会触发 只查询 tid为1的数据
    }

    @Test
    public  void  testSelectById(){
        Teacher teacher= dao.selectByTeacherId(3);
        log.debug(teacher.getName()); //1条sql
       // log.debug(teacher);
    }

}
