package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.service.ICategoryService;
import cn.tedu.store.vo.Category;

/**
 * 商品分类控制器
 * @author soft01
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
	@Resource
	private ICategoryService categoryService;
	/**
	 * 展示商品分类页面
	 * @return
	 */
	@RequestMapping("/showCategory.do")
	public String showCategory(ModelMap map) {
		List<Category> cateFirstList=categoryService.selectCate(0);
		map.addAttribute("cateFirstList",cateFirstList);
		List<Category> cateSecondList=categoryService.selectCate(1);
		map.addAttribute("cateSecondList",cateSecondList);
		return "category";
	}
}
