package com.ltc;

import com.ltc.bean.Provincial;
import com.ltc.dao.CountryDao;
import com.ltc.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CountryDemo {
    CountryDao dao = null;
    SqlSession session = null;
    Logger log = Logger.getLogger(CountryDemo.class);

    /**
     * 在所有的test测试方法执行之前 都要执行的操作
     */
    @Before
    public void before(){
        session = SessionFactoryUtil.getSession();
        dao = session.getMapper(CountryDao.class); //获取执行的类对象
    }

    @After
    public void after(){
        if(session!=null){
            session.close();
        }
    }

    /**
     * 根据国家的编号  查询出 国家对应省会的信息
     * 设置延迟加载
     *01.在mybati核心配置文件中 增加setting节点
     *02.节点中增加
     *  <setting name="lazyLoadingEnabled" value="true"/>
     *   <setting name="aggressiveLazyLoading" value="false"/>
     */

    @Test
    public void selectCountryLazy(){
        Provincial provincial = dao.selectProvincialById(1);
        //开启延迟加载的情况  直接输出省会的名称   执行1条sql
        // log.debug(provincial.getpName());
        //执行2条
        log.debug(provincial.getCountry().getcName());
    }



























}
