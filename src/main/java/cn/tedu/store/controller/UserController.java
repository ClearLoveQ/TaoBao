package cn.tedu.store.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IPowerService;
import cn.tedu.store.service.IUserService;

/**
 * 用户模块控制器
 * @author soft01
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	@Resource
	private IPowerService powerService;
	/**
	 * 显示用户登陆页面
	 * @return
	 */
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}
	/**
	 * 用户登陆
	 * @return
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(HttpSession session,String username,String password){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		User user=userService.login(username, password);
		
		//登陆成功后绑定登陆人
		session.setAttribute("user",user);
		
		
		//判断此人的权限
		if(powerService.backPower(user.getId())!=1) {
			rr.setState(0);
			rr.setMessage("普通用户而已嘛!");
			session.setAttribute("power",0);
		}else {
			rr.setState(1);
			rr.setMessage("管理员大大!");
			session.setAttribute("power",1);
		}
		return rr;
	}
	/**
	 * 显示注册页面
	 * @return
	 */
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register";
	}
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("phone") String phone,
			@RequestParam("email") String email
			){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		userService.registerUser(user);
		rr.setState(1);
		rr.setMessage("注册成功");
		return rr;
	}
	/**
	 * 判断注册时用户名是否存在
	 * @param username
	 * @return
	 */
	@RequestMapping("/compareUsername.do")
	@ResponseBody
	public ResponseResult<Void> compareUsername(@RequestParam("username")String username){
		ResponseResult<Void> rr=new ResponseResult<Void>();
			if(username.equals(userService.selectUserByUsername(username).getUsername())) {
				rr.setState(1);
				rr.setMessage("用户名已经存在");
				return rr;
			}else {
				rr.setState(0);
				rr.setMessage("用户名可以使用");
				return rr;
		}
		
	}
	/**
	 * 判断注册时邮箱是否存在
	 * @param email
	 * @return
	 */
	@RequestMapping("/compareEmail.do")
	@ResponseBody
	public ResponseResult<Void> compareEmail(@RequestParam("email")String email){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		if(email.equals(userService.selectUserByEmail(email).getEmail())) {
			rr.setState(1);
			rr.setMessage("邮箱已经存在");
			return rr;
		}
		rr.setState(0);
		rr.setMessage("邮箱可以使用");
		return rr;
	}
	@RequestMapping("/showPersonInfo.do")
	public String showPersonInfo(HttpSession session){
		return "personInfo";
	}
	/**
	 * 退出登陆
	 * @return
	 */
	@RequestMapping("/exitLogin.do")
	public String exitLogin(HttpSession session) {
		return "redirect:showLogin.do";
	}
}
