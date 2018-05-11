package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Goods;

/**
 * 主页显示商品业务层
 * @author soft01
 *
 */
@Transactional
public interface IMainService {
	/**
	 * 根据分类的id返回此分类的所有商品
	 * @param categoryId
	 * @return
	 */
	public List<Goods> selectByCategoryId(int categoryId);
	/**
	 * 根据商品的id查询指定商品信息
	 * @param goodsId
	 * @return
	 */
	public Goods selectByGoodsId(String goodsId);
}
