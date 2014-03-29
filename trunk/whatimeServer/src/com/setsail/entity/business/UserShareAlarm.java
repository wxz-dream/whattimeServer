package com.setsail.entity.business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	@Column(name="CATE_ID", length=100)
	private Integer cateId;

	
	@Column(name="CREATE_TIME")
	private Long createTime;

	@Column(length=500)
	private String des;

	
	@Column(name="END_TIME")
	private Long endTime;

	private Integer froms;

	@Column(name="DEL")
	private Boolean del;

	@Column(name="END_JOIN")
	private Boolean endJoin;

	@Column(name="OPEN")
	private Boolean open;

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

	private Integer type;

	@Column(name="UPT_TIME")
	private Long uptTime;

	@Column(name="USER_UUID", length=100)
	private String userUuid;
	
	private Boolean allowChange;
    private String owerUuid;
    private String owerUserUuid;
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="ALARM_UUID")
	private List<UserShareTask> tasks;

	public UserShareAlarm() {
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Long alarmTime) {
		this.alarmTime = alarmTime;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public Integer getFroms() {
		return froms;
	}

	public void setFroms(Integer froms) {
		this.froms = froms;
	}

	public Boolean getDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public Boolean getEndJoin() {
		return endJoin;
	}

	public void setEndJoin(Boolean endJoin) {
		this.endJoin = endJoin;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Long getJoinNum() {
		return joinNum;
	}

	public void setJoinNum(Long joinNum) {
		this.joinNum = joinNum;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public Long getMaxJoinNum() {
		return maxJoinNum;
	}

	public void setMaxJoinNum(Long maxJoinNum) {
		this.maxJoinNum = maxJoinNum;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getShare() {
		return share;
	}

	public void setShare(String share) {
		this.share = share;
	}

	public Long getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Long syncTime) {
		this.syncTime = syncTime;
	}

	public String getTaskUuid() {
		return taskUuid;
	}

	public void setTaskUuid(String taskUuid) {
		this.taskUuid = taskUuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getUptTime() {
		return uptTime;
	}

	public void setUptTime(Long uptTime) {
		this.uptTime = uptTime;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public Boolean getAllowChange() {
		return allowChange;
	}

	public void setAllowChange(Boolean allowChange) {
		this.allowChange = allowChange;
	}

	public String getOwerUuid() {
		return owerUuid;
	}

	public void setOwerUuid(String owerUuid) {
		this.owerUuid = owerUuid;
	}

	public String getOwerUserUuid() {
		return owerUserUuid;
	}

	public void setOwerUserUuid(String owerUserUuid) {
		this.owerUserUuid = owerUserUuid;
	}

	public List<UserShareTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<UserShareTask> tasks) {
		this.tasks = tasks;
	}
	
}
