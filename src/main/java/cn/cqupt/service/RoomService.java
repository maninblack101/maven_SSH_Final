package cn.cqupt.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.cqupt.bean.PageBean;
import cn.cqupt.entity.Room;
import cn.cqupt.entity.Supplier;

public interface RoomService {

	PageBean<Room> getPageBean(DetachedCriteria dc, Integer currentPage,Integer pageSize);

	void save(Room room);

	Room getById(Long room_id);

	void deleteById(Long room_id);

}
