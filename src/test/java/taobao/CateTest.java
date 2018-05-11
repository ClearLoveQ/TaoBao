package taobao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.CategoryMapper;
import cn.tedu.store.vo.Category;

public class CateTest {
	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		CategoryMapper cm=ac.getBean("categoryMapper",CategoryMapper.class);
		List<Category> list=cm.selectCategory(0);
		for(Category cate:list) {
			System.out.println(cate.getParentId());
			System.out.println(cate.getName());
		}
		System.out.println("ok");
	}
}
