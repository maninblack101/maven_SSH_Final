package cn.cqupt.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.cqupt.bean.PageBean;
import cn.cqupt.dao.TravellerDao;
import cn.cqupt.entity.Room;
import cn.cqupt.entity.Traveller;
import cn.cqupt.service.TravellerService;

public class TravellerServiceImpl implements TravellerService {

	private TravellerDao td;
	
	

	@Override
	public void save(Traveller traveller) {
		td.saveOrUpdate(traveller);
	}


	@Override
	public PageBean<Traveller> getPageBean(DetachedCriteria dc, Integer currentPage,Integer pageSize) {
		//查询总记录数
		Integer totalsize=td.getTotalCount(dc);
		//创建PageBean
		PageBean<Traveller> pb=new PageBean<Traveller>(currentPage,totalsize, pageSize);
		
		//调用dao查询分页列表
		List<Traveller> list = td.getPageList(dc, pb.getStart(), pb.getPageSize());
		//将列表封装进pageBean中
		pb.setList(list);
		return pb;
	}

	public void setTd(TravellerDao td) {
		this.td = td;
	}


	@Override
	public Traveller getById(Long traveller_id) {
		return td.getById(traveller_id);
	}


	@Override
	public void checkOutById(Long traveller_id) {
        //根据id获取对象
		Traveller traveller = td.getById(traveller_id);
		//获取格式化的系统时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String delTime = df.format(new Date());
		//设置其limited_day属性为当前时间
		traveller.setLeave_day(delTime);
	}
}
