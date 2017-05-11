package org.fage.mapper;

import java.util.List;

import org.fage.domain.User;
import org.fage.domain.UserQueryVo;

/**
 * 
 * @author Caizhf
 * @date 2017年5月4日下午6:16:27
 * @version v.0.1
 * <p>Description: Mapper接口开发模式，有四个约束</p>
 *
 */
public interface UserMapper {
	
	/**
	 * 1.方法名称要与mapper.xml的相应mappedStatement的id一致
	 * 2.返回值类型要与mapper.xml的resultType类型一致
	 * 3.参数类型要与mapper.xml的parameterType类型一致
	 */
	//通过id查询User
//	public User findById(int id) throws Exception;
	
	//通过姓、名模糊查询
//	public List<User> findByLikeName(String likeName) throws Exception;
	
	//增加一个用户
//	public void add(User user) throws Exception;
	
	//根据id删除
//	public void deleteById(int id)throws Exception;
	
	//通过user中的id进行更新user
//	public void updateById(User user) throws Exception;
	
	//查询所有
//	public List<User> findAll() throws Exception;
	
	//计数一下表中有多少条记录
//	public int findAllCount()throws Exception;
	
	//复杂查询，根据年龄与模糊姓、名查询 
	public List<User> findByLikeNameAndBirthday(UserQueryVo userQueryVo) throws Exception;
}
