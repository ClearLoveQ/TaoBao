package cn.tedu.store.mapper;

import java.util.List;
import cn.tedu.store.vo.Category;

/**
 * 分类商品持久层接口
 * @author soft01
 */
public interface CategoryMapper {
	/**
	 * 返回不同等级的分类
	 * @return
	 */
	public List<Category> selectCategory(int parentId);
}
