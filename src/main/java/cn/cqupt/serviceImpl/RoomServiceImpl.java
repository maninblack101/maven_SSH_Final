package cn.cqupt.serviceImpl;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;

import cn.cqupt.bean.PageBean;
import cn.cqupt.dao.RoomDao;
import cn.cqupt.entity.Room;
import cn.cqupt.service.RoomService;

public class RoomServiceImpl implements RoomService {

	private RoomDao rd;
	
	@Override
	public PageBean<Room> getPageBean(DetachedCriteria dc,Integer currentPage, Integer pageSize) {
		dc.setFetchMode("traveller", FetchMode.JOIN);
				//查询总记录数
				Integer totalsize=rd.getTotalCount(dc);
				//创建PageBean
				PageBean<Room> pb=new PageBean<Room>(currentPage,totalsize, pageSize);
				
				//调用dao查询分页列表
				List<Room> list = rd.getPageList(dc, pb.getStart(), pb.getPageSize());
				//将列表封装进pageBean中
				pb.setList(list);
				return pb;
	}
	public void setRd(RoomDao rd) {
		this.rd = rd;
	}
	@Override
	public void save(Room room) {
        rd.saveOrUpdate(room);
		
	}
	@Override
	public Room getById(Long room_id) {

		return rd.getById(room_id);
	}
	@Override
	public void deleteById(Long room_id) {
         rd.delete(room_id);
		
	}

}
