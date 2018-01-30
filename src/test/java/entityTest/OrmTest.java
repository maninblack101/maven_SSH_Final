package entityTest;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cqupt.bean.PageBean;
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
	
	@Test
	public void fun2(){
		ApplicationContext app=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		RoomService rs =  (RoomService) app.getBean("roomService");
		
		DetachedCriteria dc=DetachedCriteria.forClass(Room.class);
		PageBean<Room> pb = rs.getPageBean(dc, 1,3);
		for(Room r:pb.getList()){
		    System.out.println(r.getRoom_number());
		    System.out.println(r.getTraveller());
		        
		}
		
	}
}
