package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.vo.Category;

/**
 *分类业务层接口
 * @author soft01
 *
 */
@Transactional
public interface ICategoryService {
	/**
	 * 返回所有分类
	 * @return
	 */
	public List<Category> selectCate(int parentId);

}
