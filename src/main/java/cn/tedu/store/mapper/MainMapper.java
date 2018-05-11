package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Goods;

/**
 * 主页持久层接口
 * @author soft01
 */
public interface MainMapper {
	/**
	 * 根据商品的分类id,返回该类的所有商品
	 * @param categortId
	 * @return
	 */
	public List<Goods> selectByCategoryId(int categortId);
	/**
	 * 根据商品的id查询指定商品信息
	 * @param goodsId
	 * @return
	 */
	public Goods selectByGoodsId(String goodsId);
}
