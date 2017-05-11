package org.fage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fage.domain.User;
/**
 * 
 * @author Caizhf
 * @date 2017年5月4日下午6:51:30
 * @version v.0.1
 * <p>Description: 传统Dao实现</p>
 * 缺点：
 * 	1.冗余代码太多
 * 	2.存在字串硬编码
 */
public class UserDaoImpl implements UserDao{

	private SqlSessionFactory factory;
	//为了模仿注入
	public UserDaoImpl(SqlSessionFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public User findById(int id) throws Exception {
		SqlSession session = factory.openSession();
		User user = session.selectOne("userMapper.findById",id);
		session.close();
		return user;
	}

	@Override
	public List<User> findByLikeName(String likeName) throws Exception {
		SqlSession session = factory.openSession();
		List<User> users = session.selectOne("userMapper.findByLikeName",likeName);
		session.close();
		return users;
	}

	@Override
	public void add(User user) throws Exception {
		SqlSession session = factory.openSession();
		session.insert("userMapper.addOneUser",user);
		session.commit();
		session.close();
	}

	@Override
	public void deleteById(int id) throws Exception {
		SqlSession session = factory.openSession();
		session.delete("userMapper.deleteById",id);
		session.commit();
		session.close();
	}

	@Override
	public void updateById(User user) throws Exception {
		SqlSession session = factory.openSession();
		session.update("userMapper.updateUser",user);
		session.commit();
		session.close();
	}

}
