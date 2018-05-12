package cn.tedu.store.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 权限管理业务层接口
 * @author soft01
 *
 */
@Transactional
public interface IPowerService {
	/**
	 * 返回该用户的权限等级
	 * @param id
	 * @return
	 */
	public Integer backPower(Integer id);
}
