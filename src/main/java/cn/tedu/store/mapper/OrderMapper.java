package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.OrderItem;

/**
 * 订单管理持久层
 * @author soft01
 */
public interface OrderMapper {
	/**
	 * 添加订单
	 * @param order
	 */
	public void insertOrder(OrderItem orderItem);
	/**
	 * 1.返回该登陆用户的所有订单
	 * 2.管理员查看某人的订单情况
	 * @param uid
	 */
	public List<OrderItem> selectOrder(Integer uid);
	/**
	 *支付成功,更新用户的订单,设置支付状态为1
	 * @param id
	 */
	public void updateOrder(int id);

}
