package com.ltc;

import com.ltc.bean.Teacher;
import com.ltc.dao.TeacherDao;
import com.ltc.util.SessionFactoryUtil;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TeacherDemo {

    TeacherDao dao = null;
    SqlSession session = null;
    Logger log = Logger.getLogger(TeacherDemo.class);

    /**
     * 在所有的test测试方法执行之前 都要执行的操作
     */
    @Before
    public void before(){
        //获取session
        session = SessionFactoryUtil.getSession();
        dao = session.getMapper(TeacherDao.class);
    }

    @After
    public  void after(){
        if(session!=null){
            session.close();
        }
    }

    @Test
    public void testSelectByTid(){
        Teacher teacher = dao.selectTeachersById(8);
        log.debug(teacher);
    }






}
