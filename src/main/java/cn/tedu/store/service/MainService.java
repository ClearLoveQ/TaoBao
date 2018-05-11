package cn.tedu.store.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.MainMapper;
@Service
public class MainService implements IMainService {
	@Resource
	private MainMapper mainMapper;
	/**
	 * 根据分类的id返回此分类的所有商品
	 */
	public List<Goods> selectByCategoryId(int categoryId) {
		return mainMapper.selectByCategoryId(categoryId);
	}
	/**
	 * 根据商品的id查询指定商品信息
	 */
	public Goods selectByGoodsId(String goodsId) {	
		return mainMapper.selectByGoodsId(goodsId);
	}

}
