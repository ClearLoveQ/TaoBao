package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.ICartService;

/**
 * 购物车控制层
 * @author soft01
 */
@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
	@Resource
	private ICartService cartService;
	/**
	 * 添加商品到购物车
	 * @param session
	 * @param count
	 * @param price
	 * @param goodsId
	 * @return
	 */
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(HttpSession session,
			@RequestParam("count")int count,
			@RequestParam("price") int price,
			@RequestParam("image") String image,
			@RequestParam("goodsId")String goodsId){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		Cart cart=new Cart();
		cart.setPrice(price);
		cart.setImage(image);
		cart.setGoodsId(goodsId);
		cart.setCount(count);
	  cart.setUid(this.getId(session));
		cartService.insertCart(cart);
		rr.setState(1);
		rr.setMessage("添加成功");
		return rr;
	}
	/**
	 * 展示该登陆用户的购物车
	 * @param session
	 * @return
	 */
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,ModelMap map) {
		List<Cart> cartList=cartService.selectByUid(this.getId(session));
		map.addAttribute("cartList",cartList);
		return "cart";
	}
}
