package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;

/**
 *业务层实现类
 * @author soft01
 *
 */
@Service
public class DictService implements IDictService{
	@Resource
	private DictMapper dictMapper;
	/**
	 * 返回所有的省份
	 */
	public List<Province> selectProvinces() {
		return dictMapper.selectProvinces();
	}
	/**
	 * 返回所有的市
	 */
	public List<City> selectCities(String provinceCode) {
		return dictMapper.selectCities(provinceCode);
	}
	/**
	 * 返回所有的区
	 */
	public List<Area> selectAreas(String cityCode) {
		return dictMapper.selectAreas(cityCode);
	}
	
	
}
