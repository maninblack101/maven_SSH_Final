package cn.cqupt.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.cqupt.bean.PageBean;
import cn.cqupt.entity.Room;
import cn.cqupt.entity.Traveller;
import cn.cqupt.service.TravellerService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TravellerAction extends ActionSupport implements ModelDriven<Traveller> {

	//模型驱动接受参数
	Traveller traveller=new Traveller();
	TravellerService ts;
	//属性驱动
	private Integer currentPage;
	private Integer pageSize;
	
	public String add() throws Exception {
		ts.save(traveller);
		return "tolist";
	}

	public String list() throws Exception {
		DetachedCriteria dc=DetachedCriteria.forClass(Traveller.class);
		if(traveller!=null&&traveller.getTraveller_name()!=null&&traveller.getTraveller_name()!=""){
			dc.add(Restrictions.like("traveller_name","%"+traveller.getTraveller_name()+"%"));
		}
		
		//调用service查询PageBean
        PageBean<Traveller> pb=ts.getPageBean(dc,currentPage,pageSize);
		//将pageBean放入request域
		ActionContext.getContext().getSession().put("pageBean",pb);
		
		return "list";
	}
	
	public String toedit() throws Exception {
		//根据id返回对应实体
		traveller=ts.getById(traveller.getTraveller_id());
		//放入request域中
		ActionContext.getContext().put("traveller", traveller);
		return "toedit";
	}
	
	public String delete() throws Exception {
		ts.checkOutById(traveller.getTraveller_id());
		return "tolist";
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

	public void setTs(TravellerService ts) {
		this.ts = ts;
	}

	public Traveller getTraveller() {
		return traveller;
	}

	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}

	

	@Override
	public Traveller getModel() {
		return traveller;
	}

}
