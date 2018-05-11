package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Address;

/**
 * 地址管理业务层接口
 * @author soft01
 *
 */
@Transactional
public interface IAddressService {
	/**
	 * 添加新的收货地址
	 * @param address
	 */
	public void insertAddress(Address address);
	/**
	 * 获取登陆用户的所有收货地址
	 * @param uid
	 * @return
	 */
	List<Address> getAddressByUid(Integer uid);
}
