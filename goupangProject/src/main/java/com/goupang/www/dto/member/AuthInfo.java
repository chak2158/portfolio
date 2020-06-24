package com.goupang.www.dto.member;

public class AuthInfo {

	private Long id;
	private String email;
	private String name;
	private int grant;

	public AuthInfo(Long id, String email, String name) {
		this.id = id;
		this.email = email;
		this.name = name;
	}
	
	public AuthInfo(Long id, String email, String name , int grant) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.grant = grant;
	}
	

	public int getGrant() {
		return grant;
	}
	
	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}
	
	public boolean checkId(Long id) {
		if(this.grant == 0) return false;
		if(this.id == id) return true;
		return false;
	}
	
	public boolean checkGrant(int grant) {
		if(this.grant == grant) return true;
		return false;
	}

}
