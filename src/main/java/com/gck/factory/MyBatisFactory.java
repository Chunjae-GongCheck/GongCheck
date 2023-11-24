package com.gck.factory;

import com.gck.config.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MyBatisFactory {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}