package cn.cqupt.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.cqupt.bean.PageBean;
import cn.cqupt.entity.Room;
import cn.cqupt.entity.Traveller;

public interface TravellerService {

	void save(Traveller traveller);

	PageBean<Traveller> getPageBean(DetachedCriteria dc, Integer currentPage,Integer pageSize);

	Traveller getById(Long traveller_id);

	void checkOutById(Long traveller_id);

}
