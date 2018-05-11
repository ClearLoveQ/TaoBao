package taobao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.CategoryMapper;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.vo.Category;

public class DictTest {
	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper cm=ac.getBean("dictMapper",DictMapper.class);
		List<City> list=cm.selectCities("110000");
		for(City cate:list) {
			System.out.println(cate.getCityName());
		}
		System.out.println("ok");
	}
}
