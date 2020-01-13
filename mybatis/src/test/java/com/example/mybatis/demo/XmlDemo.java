package com.example.mybatis.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatis.model.BossUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class XmlDemo {

    SqlSessionFactory sqlSessionFactory=null;
    String resource="mybatis-config.xml";
    InputStream inputStream;


    private SqlSessionFactory getSqlSessionFactory(){
        try {
            inputStream= Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            sqlSessionFactory=builder.build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }


    private void selectOnly(){

        SqlSession sqlSession=null;
        try {
            sqlSessionFactory=getSqlSessionFactory();

            sqlSession=sqlSessionFactory.openSession();
            /**
             * do something
             */
            BossUser bossUser=(BossUser)sqlSession.selectOne("com.example.mybatis.mapper.BossUserMapper.getBossUser","20190927C06627184133176557568");
            //BossUser bossUser=(BossUser)sqlSession.selectOne("getBossUser","1");
            System.out.println("结果："+ JSONObject.toJSONString(bossUser));

            sqlSession.commit();
        }catch (Exception e){
            if(null!=sqlSession) {
                sqlSession.rollback();
            }
        }finally {
            if(null!=sqlSession){
                sqlSession.close();
            }
        }
    }


    public static void main(String[] args){
        XmlDemo xmlDemo=new XmlDemo();
        xmlDemo.selectOnly();
    }
}