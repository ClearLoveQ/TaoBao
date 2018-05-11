package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IAddressService;

/**
 * 地址管理控制器
 * @author soft01
 */
@Controller
@RequestMapping("/address")
public class AddressController extends BaseController{
	@Resource
	private IAddressService addressService;
	/**
	 * 显示地址管理页面
	 * @return
	 */
	@RequestMapping("/showAddress.do")
	public String showAddress() {
		return "address";
	}
	/**
	 * 添加收货人地址
	 * @param session
	 * @param recvProvince
	 * @param recvCity
	 * @param recvArea
	 * @param recvName
	 * @param recvDistrict
	 * @param recvPhone
	 * @return
	 */
	@RequestMapping("/addAddress.do")
	@ResponseBody
	public ResponseResult<Void> addAddress(
			HttpSession session,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverArea") String recvArea,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverDistrict") String recvDistrict,
			@RequestParam("receiverPhone") String recvPhone
			){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		int uid=getId(session);
		
		Address address=new Address();
		address.setUid(uid);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvDistrict(recvDistrict);
		address.setRecvPhone(recvPhone);
		
		addressService.insertAddress(address);
		rr.setState(1);
		rr.setMessage("添加成功");
		return rr;
	}
	/**
	 * 根据登陆用户的uid返回地址
	 * @param session
	 * @return
	 */
	@RequestMapping("/getAddressByUid.do")
	@ResponseBody
	public ResponseResult<List<Address>> getAddressByUid(HttpSession session){
		ResponseResult<List<Address>>rr=new ResponseResult<List<Address>>();
		Integer uid=this.getId(session);
		List<Address> address=addressService.getAddressByUid(uid);
		rr.setData(address);
		return rr;
	}
}
