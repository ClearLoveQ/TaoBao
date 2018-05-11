package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

/**
 * 地址管理持久层
 * @author soft01
 */
public interface AddressMapper {
	/**
	 * 添加收货人地址
	 * @param address
	 */
	public void insertAddress(Address address);
	/**
	 * 返回登陆人的所有收货地址
	 * @param uid
	 * @return
	 */
	public List<Address> selectByUid(Integer uid);
}
