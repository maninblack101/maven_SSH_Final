package cn.cqupt.entity;

public class Supplier {

	/*
	 *  supplier_id          longint not null,
   supplier_name        varchar(200),
   supplier_shortname   varchar(200),
   supplier_shortname         varchar(100),
   financing            decimal(10.2),
   business_man         varchar(15),
   telphone             varchar(255),
   address              varchar(100),
   bank                 varchar(100),
   bank_id              varchar(100),
   business_id          varchar(50),
   tax_id               varchar(50),
   taxplayer_propert    int(1),
   business_scope       varchar(500),
   service_promise      <varchar(500)Undefined>,
   option_advice        varchar(500),
   create_user_id       varchar(32),
   create_time          datetime,
   modify_time          datetime,
   delete_time          datetime,
   Column_21            char(10),
   primary key (supplier_id)*/
	private Long supplier_id;
	//供应商名称
	private String supplier_name;
	//供应商简称
	private String supplier_shortname;
	//注册资金
	private Double financing;
	
	//联系电话
	private String telphone;
	//地址
	private String address;
	//开户行
	private String bank;
	//开户行账号
	private String bank_id;
	//营业执照编号
	private String business_id;
	//税号
	private String tax_id;
	//纳税人性质
	private String taxplayer_propert;
	//经营范围
	private String business_scope;
	//服务承诺
	private String service_promise;
	//申请意见
	private String option_advice;
	//申请用户id
	private String create_user_id;
	//创建时间
	private String create_time;
	//修改时间
	private String modify_time;
	//删除时间
	private String delete_time;
	private String Column_21;
	
	
	public Double getFinancing() {
		return financing;
	
	}
	public void setFinancing(Double financing) {
		this.financing = financing;
	}
	public Long getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_shortname() {
		return supplier_shortname;
	}
	public void setSupplier_shortname(String supplier_shortname) {
		this.supplier_shortname = supplier_shortname;
	}

	
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	public String getTax_id() {
		return tax_id;
	}
	public void setTax_id(String tax_id) {
		this.tax_id = tax_id;
	}
	public String getTaxplayer_propert() {
		return taxplayer_propert;
	}
	public void setTaxplayer_propert(String taxplayer_propert) {
		this.taxplayer_propert = taxplayer_propert;
	}
	public String getBusiness_scope() {
		return business_scope;
	}
	public void setBusiness_scope(String business_scope) {
		this.business_scope = business_scope;
	}
	public String getService_promise() {
		return service_promise;
	}
	public void setService_promise(String service_promise) {
		this.service_promise = service_promise;
	}
	public String getOption_advice() {
		return option_advice;
	}
	public void setOption_advice(String option_advice) {
		this.option_advice = option_advice;
	}
	public String getCreate_user_id() {
		return create_user_id;
	}
	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getModify_time() {
		return modify_time;
	}
	public void setModify_time(String modify_time) {
		this.modify_time = modify_time;
	}
	public String getDelete_time() {
		return delete_time;
	}
	public void setDelete_time(String delete_time) {
		this.delete_time = delete_time;
	}
	public String getColumn_21() {
		return Column_21;
	}
	public void setColumn_21(String column_21) {
		Column_21 = column_21;
	}
	
}
