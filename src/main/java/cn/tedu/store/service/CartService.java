package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;

/**
 * 购物车业务层实现类
 * @author soft01
 *
 */
@Service
public class CartService implements ICartService{
	@Resource
	private CartMapper cartMapper;
	/**
	 * 往购物车添加商品
	 */
	public void insertCart(Cart cart) {
		cartMapper.insertCart(cart);
	}
	/**
	 * 返回该用户购物车商品
	 */
	public List<Cart> selectByUid(Integer uid) {
		return cartMapper.selectByUid(uid);
	}

}
