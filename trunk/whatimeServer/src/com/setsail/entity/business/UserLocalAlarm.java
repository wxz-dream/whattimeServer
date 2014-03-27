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

/**
 * The persistent class for the user_local_alarm database table.
 * 
 */
@Entity
@Table(name = "user_local_alarm")
@NamedQuery(name = "UserLocalAlarm.findAll", query = "SELECT u FROM UserLocalAlarm u")
public class UserLocalAlarm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 100)
	private String uuid;

	@Column(name = "ALARM_TIME")
	private Long alarmTime;

	@Column(name = "CREATE_TIME")
	private Long createTime;

	@Column(length = 500)
	private String des;

	private int froms;

	@Column(name = "DEL")
	private boolean del;

	@Column(name = "OPEN")
	private boolean open;

	@Column(length = 50)
	private String share;

	@Column(name = "SYNC_TIME")
	private Long syncTime;

	@Column(name = "TASK_UUID", length = 100)
	private String taskUuid;

	@Column(length = 100)
	private String title;

	private int type;

	@Column(name = "UPT_TIME")
	private Long uptTime;

	@Column(name = "USER_UUID", length = 100)
	private String userUuid;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ALARM_UUID")
	private List<UserLocalTask> tasks;

	public UserLocalAlarm() {
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

	public int getFroms() {
		return this.froms;
	}

	public void setFroms(int froms) {
		this.froms = froms;
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

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public List<UserLocalTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<UserLocalTask> tasks) {
		this.tasks = tasks;
	}

}
