package cn.cqupt.serviceImpl;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cqupt.dao.SupplierDao;
import cn.cqupt.daoImpl.SupplierDaoImpl;
import cn.cqupt.entity.Supplier;

public class SupplierServiceImplTest {


	@Test
	public void test() {
		ApplicationContext app=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SupplierDao ss =  (SupplierDao) app.getBean("supplierService");
		Supplier t=new Supplier();
		t.setSupplier_name("中兴通信");
		t.setFinancing(100000d);
		ss.save(t);
	}

}
