package org.fage.mapper;

import org.fage.domain.User;
/**
 * 
 * @author Caizhf
 * @date 2017年5月7日下午12:23:37
 * @version v.0.1
 * <p>Description: </p>
 *
 */
public interface UserMapper {
	public User findById(int id);
	
	//测试懒加载Orders
	public User findByIdLazyInitOrders(int id);
	
	public void add(User user);
}
