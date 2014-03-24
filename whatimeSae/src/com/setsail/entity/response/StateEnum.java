package com.setsail.entity.response;

public enum StateEnum {

	STATE_EXCEPTION(-1, "exception"),
	STATE_SUCCESS(1, "success"),
	STATE_FAIL(2, "fail"),
	STATE_NOLOGIN(3, "nologin");
	
	public final int STATE;
	public final String STATEINFO;
	
	private StateEnum(int state, String stateInfo){
		this.STATE = state;
		this.STATEINFO = stateInfo;
	}
}
