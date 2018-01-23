package cn.cqupt.bean;

import java.util.List;

public class PageBean<T> {
	    //所有实体
		private List<T>list;
	    //当前页码
		private Integer currentPage;
		//总页数
		private Integer totalPage;
		//总条数
		private Integer totalSize;
		//每页条数
		private Integer pageSize;
		
	

		//有参构造
		public PageBean(Integer currentPage, Integer totalSize, Integer pageSize) {
			super();
			this.totalSize = totalSize;
			this.currentPage = currentPage;
			this.pageSize = pageSize;
			
		
	        
			//默认currentPage和pageSize
			if(this.currentPage==null){
	          	this.currentPage=1;
	        }
	        
	        if(this.pageSize==null){
	            this.pageSize=3;	
	        }
	        //计算总页数
	        this.totalPage=(this.pageSize+this.totalSize-1)/this.pageSize;
	        
	        //判断currentPage是否超出范围
	        if(this.currentPage<1){
	        	this.currentPage=1;
	        }
	        if(this.currentPage>totalPage){
	        	this.currentPage=totalPage;
	        }
		}
		
		//计算起始索引
		public int getStart(){
			return this.pageSize*(this.currentPage-1);
		}
		
		public List<T> getList() {
			return list;
		}

		public void setList(List<T> list) {
			this.list = list;
		}

		public Integer getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(Integer currentPage) {
			this.currentPage = currentPage;
		}

		public Integer getTotalPage() {
			return totalPage;
		}

		public void setTotalPage(Integer totalPage) {
			this.totalPage = totalPage;
		}

		public Integer getTotalSize() {
			return totalSize;
		}

		public void setTotalSize(Integer totalSize) {
			this.totalSize = totalSize;
		}

		public Integer getPageSize() {
			return pageSize;
		}

		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
}
