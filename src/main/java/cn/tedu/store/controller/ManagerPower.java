package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;

/**
 * 管理员
 * @author soft01
 *
 */
@Controller
@RequestMapping("/manager")
public class ManagerPower {
	@Resource
	private IUserService userService;
	/**
	 * 判断此人是否可以跳转到管理员界面
	 * @return
	 */
	@RequestMapping("/showManager.do")
	public String managerMain(HttpSession session) {
		Integer power=(Integer) session.getAttribute("power");
		if(power==0) {
			//普通用户,重定向到主页面,不予展示
			return "forward:../main/showIndex.do";
		}else {
			//管理员.展示管理界面
			return "manager";
		}
	}
	/**
	 * 返回所有的用户
	 * @return
	 */
	@RequestMapping("/getAllUsers.do")
	public String getAllUsers(ModelMap map) {
		List<User> userList=userService.getAllUsers();
		map.addAttribute("userList",userList);
		return "manager";
	}
}
