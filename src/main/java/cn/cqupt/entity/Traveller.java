package cn.cqupt.entity;

public class Traveller {

	//自增长主键
	private Long traveller_id;
	private String traveller_name;
	private String email;
	private String phone;
	private String order_time;
	private String limited_day;
	private String traveller_cert;
	//退房时间（系统计算）
	private String leave_day;
	private Room room;
	
	
	public Long getTraveller_id() {
		return traveller_id;
	}
	public void setTraveller_id(Long traveller_id) {
		this.traveller_id = traveller_id;
	}
	public String getTraveller_name() {
		return traveller_name;
	}
	public void setTraveller_name(String traveller_name) {
		this.traveller_name = traveller_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public String getLimited_day() {
		return limited_day;
	}
	public void setLimited_day(String limited_day) {
		this.limited_day = limited_day;
	}
	public String getTraveller_cert() {
		return traveller_cert;
	}
	public void setTraveller_cert(String traveller_cert) {
		this.traveller_cert = traveller_cert;
	}
	public String getLeave_day() {
		return leave_day;
	}
	public void setLeave_day(String leave_day) {
		this.leave_day = leave_day;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	
}
