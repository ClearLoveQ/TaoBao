package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IDictService;

/**
 * 字典查询省市区
 * @author soft01
 *
 */
@Controller
@RequestMapping("/dict")
public class DictController {
	@Resource
	private IDictService dictService;
	/**
	 * 返回所有的省份
	 * @return
	 */
	@RequestMapping("/getProvinces.do")
	@ResponseBody
	public ResponseResult<List<Province>> getProvinces(){
		ResponseResult<List<Province>> rr=new ResponseResult<List<Province>>();
		List<Province> proList=dictService.selectProvinces();
		rr.setData(proList);
		return rr;
	}
	/**
	 * 返回所有的市
	 * @return
	 */
	@RequestMapping("/getCities.do")
	@ResponseBody
	public ResponseResult<List<City>> getCities(@RequestParam("provinceCode")String provinceCode){
		ResponseResult<List<City>> rr=new ResponseResult<List<City>>();
		List<City> citList=dictService.selectCities(provinceCode);
		rr.setData(citList);
		return rr;
	}
	/**
	 * 返回所有的区
	 * @return
	 */
	@RequestMapping("/getAreas.do")
	@ResponseBody
	public ResponseResult<List<Area>> getAreas(String cityCode){
		ResponseResult<List<Area>> rr=new ResponseResult<List<Area>>();
		List<Area> areList=dictService.selectAreas(cityCode);
		rr.setData(areList);
		return rr;
	}
}
