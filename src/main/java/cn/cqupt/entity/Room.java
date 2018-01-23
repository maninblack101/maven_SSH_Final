package cn.cqupt.entity;

public class Room {

	private Long room_id;

	private String room_number;
	private Integer room_kind;
	private Double room_price;
	private Traveller traveller;
	
	public Traveller getTraveller() {
		return traveller;
	}
	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}
	public String getRoom_number() {
		return room_number;
	}
	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	public Integer getRoom_kind() {
		return room_kind;
	}
	public void setRoom_kind(Integer room_kind) {
		this.room_kind = room_kind;
	}
	public Double getRoom_price() {
		return room_price;
	}
	public void setRoom_price(Double room_price) {
		this.room_price = room_price;
	}
	public Long getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Long room_id) {
		this.room_id = room_id;
	}

	
}
