package cn.tedu.store.mapper;

import cn.tedu.store.bean.User;

/**
 * 用户管理持久层接口
 * @author soft01
 */
public interface UserMapper {
	/**
	 * 根据用户名返回指定的用户
	 * @param username
	 * @return
	 */
	public User selectUserByUsername(String username);
	/**
	 * 注册用户
	 * @param user
	 */
	public void registerUser(User user);
	/**
	 * 根据邮箱做做查询
	 * @param username
	 * @return
	 */
	public User selectUserByEmail(String email);
}
