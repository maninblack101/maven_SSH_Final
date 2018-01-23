package cn.cqupt.daoImpl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cqupt.dao.SupplierDao;
import cn.cqupt.entity.Supplier;

public class UserDaoImplTest {

	@Test
	public void test() {
		ApplicationContext app=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SupplierDao ud = (SupplierDao) app.getBean("userDao");
		//Supplier u = ud.findById(1l);
		//System.out.println(u.getSupplier_name());
	}

}
