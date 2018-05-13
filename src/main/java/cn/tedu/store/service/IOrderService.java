package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.OrderItem;

/**
 *订单业务层接口
 * @author soft01
 */
@Transactional
public interface IOrderService {
	/**
	 * 添加订单
	 * @param orderItem
	 */
	public void insertOrder(OrderItem orderItem);
	/**
	 * 1.返回该登陆用户的所有订单
	 * 2.管理员查看某人的订单情况
	 * @param uid
	 * @return
	 */
	public List<OrderItem> selectOrder(Integer uid);
	/**
	 * 更改订单支付状态,1是支付成功
	 * @param id
	 */
	public void updateOrder(int id);
}
