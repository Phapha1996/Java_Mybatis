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
 * <p>Description: DMISql测试</p>
 *
 */
public class MapperTest {
	private SqlSessionFactory factory;
	@Before
	public void init() throws IOException{
		factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
	}
	
	
	//测试模糊姓名+生日查询
	//因为java时间精确类型与数据库里面插入的不匹配，所以测试的时候没查到，但是正常情况下，只要相同，功能是正常查询到的
	//在这里可以自行注释测试DMISql调用
	@Test
	public void testfindByLikeNameAndBirthday() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date birthday = sdf.parse("1996-1-1");
		
		UserQueryVo uvo = new UserQueryVo();
		User user = new User();
		//注释点
		user.setBirthday(birthday);
		user.setUsername("媛");
		uvo.setUser(user);
		
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		//uvo可以设置为null
		List<User> users = mapper.findByLikeNameAndBirthday(uvo);
		
		for(User u:users)
			System.out.println(u.getUsername()+"|"+u.getBirthday());
		
		session.close();
		
	}
	
}
