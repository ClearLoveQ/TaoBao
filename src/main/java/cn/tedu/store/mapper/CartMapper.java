package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;

/**
 * 购物车页面持久层接口
 * @author soft01
 */
public interface CartMapper {
	/**
	 * 添加商品到购物车
	 * @param cart
	 */
	public void insertCart(Cart cart); 
	/**
	 * 返回该用户的所有购物车商品
	 * @param uid
	 * @return
	 */
	public List<Cart> selectByUid(Integer uid);
}
