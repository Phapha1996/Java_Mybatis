package org.fage.mapper;

import org.fage.domain.Orders;
/**
 * 
 * @author Caizhf
 * @date 2017年5月7日下午12:23:40
 * @version v.0.1
 * <p>Description: </p>
 *
 */
public interface OrdersMapper {
	//一对一懒加载
	public Orders findById(int id);
}
