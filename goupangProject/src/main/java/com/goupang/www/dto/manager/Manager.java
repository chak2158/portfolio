package com.goupang.www.dto.manager;

public class Manager {
	private int MANAGER_NO; /* NOT NULL, 관리자번호 */
	private String MANAGER_ID; /* 관리자ID */
	private String MANAGER_PW; /* 관리자PASSWORD */

	public Manager(int mANAGER_NO, String mANAGER_ID, String mANAGER_PW) {
		super();
		MANAGER_NO = mANAGER_NO;
		MANAGER_ID = mANAGER_ID;
		MANAGER_PW = mANAGER_PW;
	}

	public int getMANAGER_NO() {
		return MANAGER_NO;
	}

	public void setMANAGER_NO(int mANAGER_NO) {
		MANAGER_NO = mANAGER_NO;
	}

	public String getMANAGER_ID() {
		return MANAGER_ID;
	}

	public void setMANAGER_ID(String mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}

	public String getMANAGER_PW() {
		return MANAGER_PW;
	}

	public void setMANAGER_PW(String mANAGER_PW) {
		MANAGER_PW = mANAGER_PW;
	}

}
