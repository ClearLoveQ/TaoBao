package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.EmailAlreadyExist;
import cn.tedu.store.service.ex.NameAlreadyExist;
import cn.tedu.store.service.ex.PasswordNotTrue;
import cn.tedu.store.service.ex.UsernameNotFoundException;
/**
 * 用户管理业务层实现类
 * @author soft01
 */
@Service
public class UserService implements IUserService{
	@Resource
	private UserMapper userMapper;
	/**
	 * 判断登陆,如果帐号密码匹配则返回该用户,否则返回null
	 */
	public User login(String username,String password) {
		User user=(User)userMapper.selectUserByUsername(username);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
			throw new PasswordNotTrue("用户名密码错误......");
		}else {
			throw new UsernameNotFoundException("用户名不存在......");
		}
	}
	/**
	 * 注册用户
	 */
	public void registerUser(User regUser) {
			userMapper.registerUser(regUser);
	}
	/**
	 * 根据用户名做查询
	 */
	public User selectUserByUsername(String username) {
		return userMapper.selectUserByUsername(username);
	}
	/**
	 * 根据邮箱做查询
	 */
	public User selectUserByEmail(String email) {
		return userMapper.selectUserByEmail(email);
	}
	/**
	 * 管理员查看所有的用户
	 */
	public List<User> getAllUsers() {	
		return userMapper.getAllUsers();
	}
	

	
}
