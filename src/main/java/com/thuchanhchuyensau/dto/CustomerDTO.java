package com.thuchanhchuyensau.dto;


public class CustomerDTO extends AbstractDTO<CustomerDTO> {
	
	private String fir;
	private String last;
	private String cunname;
	private String cun;
	private String street;
	private String zip;
	private String town;
	private String email;
	private String phone;
	public String getFir() {
		return fir;
	}
	public void setFir(String fir) {
		this.fir = fir;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getCunname() {
		return cunname;
	}
	public void setCunname(String cunname) {
		this.cunname = cunname;
	}
	public String getCun() {
		return cun;
	}
	public void setCun(String cun) {
		this.cun = cun;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
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
	
	
	

}
