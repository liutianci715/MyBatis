package com.ltc.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

/*
单例模式创建SqlSessionFactory
 */
public class SqlSessionFactoryUtil {

//01.创建需要单例的静态对象
    private static SqlSessionFactory sessionFactory;

    //私有化构造
    private SqlSessionFactoryUtil(){}

    //提供对外访问的接口
    public static synchronized SqlSession getSession(){
        //把xml文件读取到内存中  并且返回一个输入流对象
        try {
            InputStream stream = Resources.getResourceAsStream("mybatis.xml");
            if(sessionFactory==null){
                //创建SqlSessionFactory
               sessionFactory = new SqlSessionFactoryBuilder().build(stream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  sessionFactory.openSession();  //返回一个SqlSession的实体类==》DefaultSqlSession
    }


}
