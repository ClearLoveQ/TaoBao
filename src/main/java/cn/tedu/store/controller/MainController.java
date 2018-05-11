package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IMainService;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private IMainService mainService;
	/**
	 * 显示主页面
	 * @return
	 */
	@RequestMapping("/showIndex.do")
	public String showIndex() {	
		return "index";
	}
	/**
	 * 成列商品
	 * @param cateGoryId
	 * @param map
	 * @return
	 */
	@RequestMapping("/showGoods.do")
	public String showGoods(@RequestParam("categoryId")int categoryId,ModelMap map){
		//将商品装入map显示到页面
		List<Goods> nowNovelList=mainService.selectByCategoryId(categoryId);
		map.addAttribute("nowNovelList",nowNovelList);
		return "showGoods";
	}
	/**
	 * 显示商品的详细信息
	 * @param goodsId
	 * @param map
	 * @return
	 */
	@RequestMapping("/goodInfo.do")
	public String goodInfo(String goodsId,ModelMap map){
		Goods goods=mainService.selectByGoodsId(goodsId);
		map.addAttribute("goods",goods);
		return "goodInfo";
	}
}
