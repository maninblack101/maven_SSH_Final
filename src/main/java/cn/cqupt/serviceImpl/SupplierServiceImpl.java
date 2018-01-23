package cn.cqupt.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.cqupt.bean.PageBean;
import cn.cqupt.dao.SupplierDao;
import cn.cqupt.entity.Supplier;
import cn.cqupt.service.SupplierService;

public class SupplierServiceImpl implements SupplierService {

	private SupplierDao ud;
	@Override
	public PageBean getPageBean(DetachedCriteria dc,Integer currentPage,Integer pageSize) {
		//封装查询条件(查询delete_time字段为空的记录)
		dc.add(Restrictions.isNull("delete_time"));
		//查询总记录数
		Integer totalsize=ud.getTotalCount(dc);
		//创建PageBean
		PageBean<Supplier> pb=new PageBean<Supplier>(currentPage,totalsize, pageSize);
		
		//调用dao查询分页列表
		List<Supplier> list = ud.getPageList(dc, pb.getStart(), pb.getPageSize());
		//将列表封装进pageBean中
		pb.setList(list);
		return pb;
	}
	public void setUd(SupplierDao ud) {
		this.ud = ud;
	}
	
	
	@Override
	public void save(Supplier supplier) {
		ud.saveOrUpdate(supplier);
	}
	@Override
	public Supplier getById(Long supplier_id) {
		return 	ud.getById(supplier_id);
	}
	@Override
	public void deleteMarkById(Long supplier_id) {
         //获取格式化的系统时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String delTime = df.format(new Date());
		//根据id查询Supplier
		Supplier supplier = ud.getById(supplier_id);
		//将时间放入Supplier对象中
		supplier.setDelete_time(delTime);
		
	}
	
}
