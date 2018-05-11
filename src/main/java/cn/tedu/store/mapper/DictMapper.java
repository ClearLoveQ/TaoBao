package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

/**
 *字典查询省市区接口
 * @author soft01
 *
 */
public interface DictMapper {
	/**
	 * 返回省份的集合
	 * @return
	 */
	public List<Province> selectProvinces();
	/**
	 * 返回所有的市
	 * @param provinceCode
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
