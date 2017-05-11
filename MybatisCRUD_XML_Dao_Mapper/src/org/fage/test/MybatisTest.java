package org.fage.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fage.domain.User;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * 
 * @author Caizhf
 * @date 2017年5月3日下午10:56:57
 * @version v.0.1
 * <p>Description: 对Mybatis进行基础CRUD测试,与User.xml相应</p>
 *
 */
public class MybatisTest {
	
	/**
	 * 
	 * @throws IOException
	 * <p>Description:测试得到id=1的User<p/>
	 */
	@Test
	public void findUserById() throws IOException{
		//获得配置文件的流
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//从配置文件中读取，并且根据配置文件构建sql会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//获得与数据库的session会话
		SqlSession session = factory.openSession();
		/*开始查找,
		第一个参数是mapper的命名空间+mappedStatement的id，
		第二个参数是mapper中的parameterType类型
		*/
		User user = session.selectOne("userMapper.findById",1);
		//取得结果集
		System.out.println(user.getUsername()+"|"+user.getBirthday());
		//关闭session
		session.close();
	}
	
	/**
	 * 
	 * @throws IOException
	 * <p>Description:查询姓蔡的用户<p/>
	 */
	@Test
	public void testFindByLikeName() throws IOException{
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		//查询姓蔡的人
		List<User> users = session.selectList("userMapper.findByLikeName","蔡");
		System.out.println(users.size());
		session.close();
	}
	
	
	/**
	 * 
	 * @throws IOException
	 * <p>Description:插入豆豆这条数据,需要提交事务<p/>
	 */
	@Test
	public void testInsertOne() throws IOException{
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		User user = new User("豆豆",new Date());
		System.out.println(session.insert("userMapper.addOneUser", user));
		session.commit();
		System.out.println(user.getId());
		session.close();
	}
	
	/**
	 * 
	 * @throws IOException
	 * <p>Description:删除id为1的人<p/>
	 */
	@Test
	public void testdeleteById() throws IOException{
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		System.out.println(session.delete("deleteById",1));
		session.commit();
		session.close();
	}
	
	
	/**
	 * 
	 * @throws IOException
	 * <p>Description:更新蔡美玲，变成蔡智法<p/>
	 */
	@Test
	public void testUpdateUser() throws IOException{
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		User user = new User(2,new Date(),"蔡智法");
		session.update("updateUser", user);
		session.commit();
		session.close();
	}
}
