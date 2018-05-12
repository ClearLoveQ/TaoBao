package cn.tedu.store.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.mapper.PowerMapper;

/**
 * 权限管理业务层实现类
 * @author soft01
 *
 */
@Service
public class PowerService implements IPowerService {
	@Resource
	private PowerMapper powerMapper;
	/**
	 * 返回该用户的权限
	 */
	public Integer backPower(Integer id) {
		return powerMapper.backPower(id);
	}

}
