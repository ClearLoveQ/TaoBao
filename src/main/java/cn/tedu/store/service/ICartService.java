package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Cart;

/**
 * 购物车业务层接口
 * @author soft01
 *
 */
@Transactional
public interface ICartService {
	/**
	 * 往购物车添加商品
	 * @param cart
	 */
	public void insertCart(Cart cart);
	/**
	 * 返回该登陆人的所有购物车商品
	 * @param uid
	 * @return
	 */
	public List<Cart> selectByUid(Integer uid);
}
