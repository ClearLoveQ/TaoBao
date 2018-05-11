package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IOrderService;

/**
 * 订单控制器
 * @author soft01
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{
	@Resource
	private IOrderService orderService;
	/**
	 * 显示登陆用户的订单页面
	 * @return
	 */
	@RequestMapping("/showOrder.do")
	public String showOrder(HttpSession session,ModelMap map) {
		Integer uid=this.getId(session);
		List<OrderItem> orderList=orderService.selectOrder(uid);
		map.addAttribute("orderList",orderList);
		return "order";
	}
	/**
	 * 添加订单
	 * @param session
	 * @param goodsId
	 * @param count
	 * @param image
	 * @param price
	 * @return
	 */
	@RequestMapping("/addOrder.do")
	@ResponseBody
	public ResponseResult<Void> addOrder(
			HttpSession session,
			@RequestParam("goodsId") String goodsId,
			@RequestParam("count") int count,
			@RequestParam("image") String image,
			@RequestParam("price") int price			
			){
		ResponseResult<Void>rr=new ResponseResult<Void>();
		Integer uid=getId(session);
		OrderItem orderItem=new OrderItem();
		orderItem.setUid(uid);
		orderItem.setGoodsId(goodsId);
		orderItem.setImage(image);
		orderItem.setPrice(price);
		orderItem.setCount(count);
		
		orderService.insertOrder(orderItem);
		rr.setState(1);
		rr.setMessage("添加订单成功");
		return rr;
	}
	/**
	 * 跳转到支付页面
	 * @return
	 */
	@RequestMapping("/payment.do")
	public String payMent(HttpSession session,int id,ModelMap map) {
		map.addAttribute("orderId",id);
		return "payment";
	}
	/**
	 * 用户付钱成功
	 * @param session
	 * @param orderId
	 * @param BankPwd
	 * @return
	 */
	@RequestMapping("/payOver.do")
	@ResponseBody
	public ResponseResult<Void> payOver(HttpSession session,int orderId,int BankPwd){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		//在第三方支付成功之后,我们对数据进行更新
		orderService.updateOrder(orderId);
		rr.setState(1);
		rr.setMessage("支付成功");
		return rr;
	}
}
