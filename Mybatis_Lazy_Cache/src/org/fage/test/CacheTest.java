package org.fage.test;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fage.domain.User;
import org.fage.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Caizhf
 * @date 2017年5月10日下午12:31:58
 * @version v.0.1
 * <p>Description:一级缓存与二级缓存测试 </p>
 * 
 * <p>一级缓存：在service中，spring默认是整个方法进行事务处理的，那么session的范围就是方法体，
 * 所以一级缓存的有效范围在整个方法体内（Session上下文）！</p>
 *
 *<p>缓存，只要方法执行了commit操作，缓存就会刷新</p>
 */
public class CacheTest {
	private SqlSessionFactory factory;
	@Before
	public void init() throws IOException{
		factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
	}

	/**
	 * 测试Session查询缓存
	 */
	@Test
	public void testSessionCache01(){
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u1 = mapper.findById(1);
		User u2 = mapper.findById(1);
		System.out.println(u1==u2);
	}
	
	/**
	 * 测试commit是否会刷新一级缓存
	 */
	@Test
	public void testSessionCache2(){
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u1 = mapper.findById(1);
		User u2 = mapper.findById(1);
		System.out.println(u1==u2);
		//----------下面因为插入，所以有执行commit操作，session清空缓存
		User u = new User();
		u.setUsername("霸气发哥");
		u.setBirthday(new Date());
		mapper.add(u);
		session.commit();
		//session缓存被清空了
		mapper.findById(1);
		session.close();
	}
	
	/**
	 * 测试mybatis自带二级缓存
	 */
	@Test
	public void test2Cache(){
		SqlSession session = factory.openSession();
		SqlSession session2 = factory.openSession();
		//------------------------------
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u1 = mapper.findById(1);
		session.close();
		//----------session1关闭
		UserMapper mapper2 = session2.getMapper(UserMapper.class);
		User u2 = mapper2.findById(1);
		session2.close();
	}
	
}
