package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

/**
 * 返回省份业务层接口
 * @author soft01
 *
 */
@Transactional
public interface IDictService {
	/**
	 * 返回所有的省份
	 * @return
	 */
	public List<Province> selectProvinces();
	/**
	 * 返回所有的市
	 * @return
	 */
	public List<City> selectCities(String provinceCode);
	/**
	 * 返回所有的区
	 * @param cityCode
	 * @return
	 */
	public List<Area> selectAreas(String cityCode);
}
