package cn.cqupt.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.cqupt.bean.PageBean;
import cn.cqupt.entity.Room;
import cn.cqupt.entity.Supplier;
import cn.cqupt.service.RoomService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RoomAction extends ActionSupport implements ModelDriven<Room> {
	
	private Room room=new Room();
	private RoomService rs;
	


	private Integer currentPage;
	private Integer pageSize;
	
	public String list() throws Exception {
		//封装离线查询对象
				DetachedCriteria dc=DetachedCriteria.forClass(Room.class);
				if(room!=null&&room.getRoom_number()!=null&&room.getRoom_number()!=""){
					dc.add(Restrictions.like("room_number","%"+room.getRoom_number()+"%"));
				}
				if(room.getRoom_kind()!=null){
					dc.add(Restrictions.eq("room_kind", room.getRoom_kind()));
				}
				
				//调用service查询PageBean
		        PageBean<Room> pb=rs.getPageBean(dc,currentPage,pageSize);
				//将pageBean放入request域
				ActionContext.getContext().getSession().put("pageBean",pb);
		       
				return "list";
		        
	}
	//新增或修改
	public String add() throws Exception {
		rs.save(room);
		return "tolist";
	}
	//修改回显
      
	public String toedit() throws Exception {
		//根据id查询待修改的房间实体
		room=rs.getById(room.getRoom_id());
		//将实体在request中返回
		ActionContext.getContext().put("room", room);
		return "toedit";
	}
	
	public String delete() throws Exception{
		rs.deleteById(room.getRoom_id());
		return "tolist";
	}

	@Override
	public Room getModel() {
		return room;
	}

	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setRs(RoomService rs) {
		this.rs = rs;
	}
	
}
