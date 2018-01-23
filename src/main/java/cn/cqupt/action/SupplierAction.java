package cn.cqupt.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.cqupt.bean.PageBean;
import cn.cqupt.entity.Supplier;
import cn.cqupt.service.SupplierService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class SupplierAction extends ActionSupport implements ModelDriven<Supplier> {

    

	Supplier supplier=new Supplier();
 	 private SupplierService us;

 	 Integer currentPage;
 	 Integer pageSize;


   
	//供应商列表方法
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc=DetachedCriteria.forClass(Supplier.class);
		if(supplier!=null&&supplier.getSupplier_name()!=null&&supplier.getSupplier_name()!=""){
			dc.add(Restrictions.like("supplier_name","%"+supplier.getSupplier_name()+"%"));
		}
		//调用service查询PageBean
        PageBean<Supplier> pb=us.getPageBean(dc,currentPage,pageSize);
        //****************
        System.out.println(pb.getList());
        //****************
		//将pageBean放入request域
		ActionContext.getContext().getSession().put("pageBean",pb);
		
		return "list";
	}
	//添加供应商
	public String add() throws Exception {
		us.save(supplier);
		return "tolist";
	}
    //供应商编辑回显
	public String toedit() throws Exception {
		supplier = us.getById(supplier.getSupplier_id());	
		ActionContext.getContext().put("supplier", supplier);
		return "toedit";
	}
	//供应商删除
	public String delete() throws Exception {
		us.deleteMarkById(supplier.getSupplier_id());	
		return "tolist";
	}

	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public void setUs(SupplierService us) {
		this.us = us;
	}

	@Override
	public Supplier getModel() {
		return supplier;
	}
;
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


}
