package entityTest;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cqupt.dao.SupplierDao;
import cn.cqupt.entity.Room;
import cn.cqupt.entity.Traveller;
import cn.cqupt.service.RoomService;

public class OrmTest {

	@Resource(name="roomService")
	private RoomService rs;
	
	@Test
	public void fun1(){
		ApplicationContext app=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		RoomService rs =  (RoomService) app.getBean("roomService");
		
		
		Traveller t=new Traveller();
		t.setTraveller_name("张三");
		t.setTraveller_cert("342623199970191");
		
		Room room = rs.getById(1l);
        room.setTraveller(t);
    
	}
}
