package org.fage.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fage.domain.User;
import org.fage.domain.UserQueryVo;
import org.fage.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Caizhf
 * @date 2017年5月4日下午6:06:28
 * @version v.0.1
 * <p>Description: mybatis动态代理Mapper测试</p>
 *
 */
public class MapperTest {
	private SqlSessionFactory factory;
	@Before
	public void init() throws IOException{
		factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
	}
	
	@Test
	//测试通过id查找
	public void testFindById() throws Exception{
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		//查询id=2的用户
		User user = mapper.findById(2);
		System.out.println(user.getUsername());
		session.close();
	}
	
	
	@Test
	//测试增加用户
	public void testAdd() throws Exception{
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		//增加用户
		User user = new User("小肥蔡",new Date());
		mapper.add(user);
		//查看返回User内的id值
		System.out.println(user.getId());
		session.commit();
		session.close();
	}
	
	
	@Test
	//测试模糊查询
	public void testfindByLikeName() throws Exception{
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		List<User> users = mapper.findByLikeName("蔡");
		for(User u:users)
			System.out.println(u.getUsername());
		session.close();
	}
	
	
	@Test
	//测试通过id删除
	public void testDeleteById() throws Exception{
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		//测试删除
		mapper.deleteById(6);
		session.commit();
		session.close();
	}
	
	
	@Test
	//测试更新
	public void testUpdateById() throws Exception{
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u = new User(5,new Date(),"梁媛");
		mapper.updateById(u);
		session.commit();
		session.close();
	}
	
	//测试查所有记录数
	@Test
	public void testFindAllCount() throws Exception{
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		System.out.println(mapper.findAllCount());
		session.close();
	}
	
	
	//测试查所有记录
	@Test
	public void testfindAll() throws Exception{
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> users = mapper.findAll();
		for(User u:users)
			System.out.println(u.getUsername());
		session.close();
	}
	
	
	//测试模糊姓名+生日查询
	//因为java时间精确类型与数据库里面插入的不匹配，所以测试的时候没查到，但是正常情况下，只要相同，功能是正常查询到的
	@Test
	public void testfindByLikeNameAndBirthday() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date birthday = sdf.parse("1996-1-1");
		
		UserQueryVo uvo = new UserQueryVo();
		User user = new User();
		user.setBirthday(birthday);
		user.setUsername("媛");
		uvo.setUser(user);
		
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> users = mapper.findByLikeNameAndBirthday(uvo);
		
		for(User u:users)
			System.out.println(u.getUsername()+"|"+u.getBirthday());
		
		session.close();
		
	}
	
}
