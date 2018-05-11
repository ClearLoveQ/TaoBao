package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;

/**
 * 地址管理实现类
 * @author soft01
 */
@Service
public class AddressService implements IAddressService{
	@Resource
	private AddressMapper addressMapper;
	/**
	 * 添加新的收货地址
	 */
	public void insertAddress(Address address) {
		addressMapper.insertAddress(address);
	}
	/**
	 * 获取登陆用户的所有收货地址
	 */
	public List<Address> getAddressByUid(Integer uid) {
		//返回持久层方法的返回值
		return addressMapper.selectByUid(uid);
	}
	
}
