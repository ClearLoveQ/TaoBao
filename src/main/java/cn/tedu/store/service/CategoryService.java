package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.mapper.CategoryMapper;
import cn.tedu.store.vo.Category;
@Service
public class CategoryService implements ICategoryService {
	@Resource
	private CategoryMapper categoryMapper;
	/**
	 * 返回所有的分类
	 */
	public List<Category> selectCate(int parentId) {
		return categoryMapper.selectCategory(parentId);
	}
	

}
