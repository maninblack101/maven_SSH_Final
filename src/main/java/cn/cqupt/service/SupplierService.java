package cn.cqupt.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.cqupt.bean.PageBean;
import cn.cqupt.entity.Supplier;

public interface SupplierService {

	public PageBean<Supplier> getPageBean(DetachedCriteria dc,Integer currentPage, Integer pageSize);

	public void save(Supplier supplier);

	public Supplier getById(Long supplier_id);

	public void deleteMarkById(Long supplier_id);
}
