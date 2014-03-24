package com.setsail.entity.business;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the user_share_alarm database table.
 * 
 */
@Entity
@Table(name="user_share_alarm")
@NamedQuery(name="UserShareAlarm.findAll", query="SELECT u FROM UserShareAlarm u")
public class UserShareAlarm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=100)
	private String uuid;

	@Column(name="ALARM_TIME")
	private int alarmTime;

	@Column(name="CATE_UUID", length=100)
	private String cateUuid;

	
	@Column(name="CREATE_TIME")
	private Long createTime;

	@Column(length=500)
	private String des;

	
	@Column(name="END_TIME")
	private Long endTime;

	private int froms;

	@Column(name="IS_DEL")
	private int isDel;

	@Column(name="IS_END_JOIN")
	private int isEndJoin;

	@Column(name="IS_OPEN")
	private int isOpen;

	@Column(name="JOIN_NUM")
	private int joinNum;

	@Column(length=100)
	private String linkman;

	@Column(name="MAX_JOIN_NUM")
	private int maxJoinNum;

	@Column(length=100)
	private String scope;

	@Column(length=50)
	private String share;

	
	@Column(name="SYNC_TIME")
	private Long syncTime;

	@Column(name="TASK_UUID", length=100)
	private String taskUuid;

	@Column(length=100)
	private String title;

	private int type;

	
	@Column(name="UPT_TIME")
	private Long uptTime;

	@Column(name="USER_UUID", length=100)
	private String userUuid;

	public UserShareAlarm() {
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getAlarmTime() {
		return this.alarmTime;
	}

	public void setAlarmTime(int alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getCateUuid() {
		return this.cateUuid;
	}

	public void setCateUuid(String cateUuid) {
		this.cateUuid = cateUuid;
	}

	public Long getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Long getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public int getFroms() {
		return this.froms;
	}

	public void setFroms(int froms) {
		this.froms = froms;
	}

	public int getIsDel() {
		return this.isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsEndJoin() {
		return this.isEndJoin;
	}

	public void setIsEndJoin(int isEndJoin) {
		this.isEndJoin = isEndJoin;
	}

	public int getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}

	public int getJoinNum() {
		return this.joinNum;
	}

	public void setJoinNum(int joinNum) {
		this.joinNum = joinNum;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public int getMaxJoinNum() {
		return this.maxJoinNum;
	}

	public void setMaxJoinNum(int maxJoinNum) {
		this.maxJoinNum = maxJoinNum;
	}

	public String getScope() {
		return this.scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getShare() {
		return this.share;
	}

	public void setShare(String share) {
		this.share = share;
	}

	public Long getSyncTime() {
		return this.syncTime;
	}

	public void setSyncTime(Long syncTime) {
		this.syncTime = syncTime;
	}

	public String getTaskUuid() {
		return this.taskUuid;
	}

	public void setTaskUuid(String taskUuid) {
		this.taskUuid = taskUuid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Long getUptTime() {
		return this.uptTime;
	}

	public void setUptTime(Long uptTime) {
		this.uptTime = uptTime;
	}

	public String getUserUuid() {
		return this.userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

}