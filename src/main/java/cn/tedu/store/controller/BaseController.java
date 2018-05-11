package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.User;
@Controller
@RequestMapping("/base")
public class BaseController {
	/**
	 * 返回登陆用户的id
	 * @param session
	 * @return
	 */
	Integer getId(HttpSession session) {
		User user=(User)session.getAttribute("user");
		Integer id=null;
		if(user!=null) {
			id=user.getId();
		}
		return id;
	}
}
