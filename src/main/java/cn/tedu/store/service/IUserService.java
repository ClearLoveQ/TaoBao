package cn.tedu.store.service;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.User;

/**
 * 用户管理业务层接口
 * @author soft01
 */
@Transactional
public interface IUserService {
	/**
	 *判断登陆,如果帐号密码匹配则返回该用户,否则返回null
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public void registerUser(User user);
	/**
	 * 根据用户名做查询
	 * @param username
	 * @return
	 */
	public User selectUserByUsername(String username);
	/**
	 * 根据邮箱做查询
	 * @param email
	 * @return
	 */
	public User selectUserByEmail(String email);
}
