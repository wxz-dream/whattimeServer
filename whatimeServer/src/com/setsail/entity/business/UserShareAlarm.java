package com.setsail.entity.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

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
	private Long alarmTime;

	@Column(name="CATE_UUID", length=100)
	private String cateUuid;

	
	@Column(name="CREATE_TIME")
	private Long createTime;

	@Column(length=500)
	private String des;

	
	@Column(name="END_TIME")
	private Long endTime;

	private int froms;

	@Column(name="DEL")
	private boolean del;

	@Column(name="END_JOIN")
	private boolean endJoin;

	@Column(name="OPEN")
	private boolean open;

	@Column(name="JOIN_NUM")
	private Long joinNum;

	@Column(length=100)
	private String linkman;

	@Column(name="MAX_JOIN_NUM")
	private Long maxJoinNum;

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
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="ALARM_UUID")
	private List<UserShareTask> tasks;

	public UserShareAlarm() {
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getAlarmTime() {
		return this.alarmTime;
	}

	public void setAlarmTime(Long alarmTime) {
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


	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	public boolean isEndJoin() {
		return endJoin;
	}

	public void setEndJoin(boolean endJoin) {
		this.endJoin = endJoin;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public Long getJoinNum() {
		return this.joinNum;
	}

	public void setJoinNum(Long joinNum) {
		this.joinNum = joinNum;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public Long getMaxJoinNum() {
		return this.maxJoinNum;
	}

	public void setMaxJoinNum(Long maxJoinNum) {
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

	public List<UserShareTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<UserShareTask> tasks) {
		this.tasks = tasks;
	}
	
}