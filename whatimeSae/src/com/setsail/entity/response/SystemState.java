package com.setsail.entity.response;


/**
 * 用户操作返回状态实体
 * @author 亚杰
 *
 */
public class SystemState {

	/**
	 * 操作状态
	 */
	private Integer state;
	
	/**
	 * 状态信息
	 */
	private String stateInfo;
	
	/**
	 * 返回信息
	 */
	private Object resInfo;
	
	public SystemState() {
		super();
	}

	public SystemState(Integer state, String stateInfo) {
		super();
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	public SystemState(StateEnum state) {
		this.state = state.STATE;
		this.stateInfo = state.STATEINFO;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public Object getResInfo() {
		return resInfo;
	}

	public void setResInfo(Object resInfo) {
		this.resInfo = resInfo;
	}

	/**
	 * 设置状态
	 * @param state
	 */
	public void setState(StateEnum state) {
		this.state = state.STATE;
		this.stateInfo = state.STATEINFO;
	}
	
	
}
