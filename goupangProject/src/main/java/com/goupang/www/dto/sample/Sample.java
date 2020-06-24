package com.goupang.www.dto.sample;

public class Sample {
	 private int s_no;
     private String s_name;

	public Sample(int s_no, String s_name) {
		super();
		this.s_no = s_no;
		this.s_name = s_name;
	}
	
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
     
}
