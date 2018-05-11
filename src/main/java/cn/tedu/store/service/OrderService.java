package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.mapper.OrderMapper;
/**
 * 订单业务层实现类
 * @author soft01
 *
 */
@Service
public class OrderService implements IOrderService {
	@Resource
	private OrderMapper orderMapper;
	/**
	 * 添加订单
	 */
	public void insertOrder(OrderItem orderItem) {
		Integer sumPrice=orderItem.getPrice()*orderItem.getCount();
		orderItem.setSumPrice(sumPrice);
		String image=orderItem.getImage();
		if(image.equals("undefined")) {
			image="NULL";
			orderItem.setImage(image);
		}
		orderMapper.insertOrder(orderItem);
	}
	/**
	 * 返回登陆用户的所用订单
	 */
	public List<OrderItem> selectOrder(Integer uid) {
		return orderMapper.selectOrder(uid);
	}
	/**
	 * 更改订单的支付状态,1支付成功
	 */
	public void updateOrder(int id) {
		orderMapper.updateOrder(id);
	}

}
