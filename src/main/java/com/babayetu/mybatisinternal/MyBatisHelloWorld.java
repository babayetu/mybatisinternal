package com.babayetu.mybatisinternal;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisHelloWorld {

	public static void main(String[] args) {
		String resources = "com/babayetu/mybatisinternal/Configuration.xml";
		
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resources);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = factory.openSession();
			try {
				User user = (User)session.selectOne("com.babayetu.mybatisinternal.UserMapper.getUser", 1);
				System.out.println(user.getLfPartyId() + "," + user.getPartyName());
			} finally {
				session.close();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

}
