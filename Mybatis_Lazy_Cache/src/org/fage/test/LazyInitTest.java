package org.fage.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fage.domain.Orders;
import org.fage.domain.User;
import org.fage.mapper.OrdersMapper;
import org.fage.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Caizhf
 * @date 2017年5月4日下午6:06:28
 * @version v.0.1
 * <p>Description: 一对一、一对多、多对多测试懒加载</p>
 *
 */
public class LazyInitTest {
	private SqlSessionFactory factory;
	@Before
	public void init() throws IOException{
		factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
	}
	
	/**
	 * 一对一测试，Orders里面有个user，
	 * 在find orders的时候，把user
	 * 一起取出来，懒加载
	 */
	@Test
	public void testfindByOrderIdLazyInit(){
		SqlSession session = factory.openSession();
		OrdersMapper mapper = session.getMapper(OrdersMapper.class);
		Orders o = mapper.findById(1);
		System.out.println(o.getId()+o.getNum()+o.getCreateDate());
		System.out.println(o.getUser());
		session.close();
	}
	
	/**
	 *	一对多测试 ，User对Order懒加载
	 */
	@Test
	public void testfindByUserId(){
		SqlSession session = 	factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u = mapper.findByIdLazyInitOrders(1);
		/*System.out.println(u);
		System.out.println(u.getOrdersList());*/
		session.close();
	}
	
	/**
	 * 多对多，user一直对到Items,
	 *//*
	@Test
	public void testfindItemsByUserId(){
		SqlSession session = 	factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		//此处断点观察，可看到最深处
		User u = mapper.findItemsByUserId(1);
		System.out.println(u);
		session.close();
	}*/
}
