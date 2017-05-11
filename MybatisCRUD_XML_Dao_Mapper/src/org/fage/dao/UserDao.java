package org.fage.dao;

import java.util.List;

import org.fage.domain.User;
/**
 * 
 * @author Caizhf
 * @date 2017年5月4日下午6:43:48
 * @version v.0.1
 * <p>Description: mybatis开发传统dao,与User.xml相应</p>
 *
 */
public interface UserDao {
	
	//通过id查询User
		public User findById(int id) throws Exception;
		
		//通过姓、名模糊查询
		public List<User> findByLikeName(String likeName) throws Exception;
		
		//增加一个用户
		public void add(User user) throws Exception;
		
		//根据id删除
		public void deleteById(int id)throws Exception;
		
		//通过user中的id进行更新user
		public void updateById(User user) throws Exception;
		
}
