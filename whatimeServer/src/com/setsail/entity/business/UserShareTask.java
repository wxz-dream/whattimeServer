package com.setsail.entity.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the user_share_task database table.
 * 
 */
@Entity
@Table(name = "user_share_task")
@NamedQuery(name = "UserShareTask.findAll", query = "SELECT u FROM UserShareTask u")
public class UserShareTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 100)
	private String uuid;

	@Column(length = 100)
	private String address;

	@Column(name = "ALARM_TIME")
	private Long alarmTime;

	@ManyToOne
	@JoinColumn(name = "ALARM_UUID")
	private UserShareAlarm userShareAlarm;

	@Column(name = "BACKGROUND_URI", length = 100)
	private String backgroundUri;

	@Column(name = "CLOCK_TYPE")
	private Integer clockType;

	@Column(name = "CREATE_TIME")
	private Long createTime;

	@Column(name = "STE_TIME")
	private Long setTime;

	@Column(name = "ADVANCE_ORDER")
	private Integer advanceOrder;

	@Column(length = 500)
	private String des;

	@Column(name = "GPS_ADDRESS", length = 100)
	private String gpsAddress;

	@Column(name = "DEL")
	private Boolean del;

	@Column(name = "OPEN")
	private Boolean open;

	@Column(length = 100)
	private String music;

	@Column(length = 500)
	private String notice;

	@Column(name = "PLAY_MINUTE")
	private Integer playMinute;

	@Column(name = "PLAY_MUSIC", length = 100)
	private String playMusic;

	@Column(name = "PLAY_TYPE")
	private Integer playType;

	@Column(name = "REPEAT_INFO", length = 100)
	private String repeatInfo;

	@Column(name = "REPEAT_TYPE")
	private Integer repeatType;

	private Boolean shake;

	private Boolean skip;

	@Column(length = 100)
	private String surpervise;

	@Column(name = "SYNC_TIME")
	private Long syncTime;

	@Column(length = 100)
	private String title;

	@Column(name = "UPT_TIME")
	private Long uptTime;

	public UserShareTask() {
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Long alarmTime) {
		this.alarmTime = alarmTime;
	}

	public UserShareAlarm getUserShareAlarm() {
		return userShareAlarm;
	}

	public void setUserShareAlarm(UserShareAlarm userShareAlarm) {
		this.userShareAlarm = userShareAlarm;
	}

	public String getBackgroundUri() {
		return this.backgroundUri;
	}

	public void setBackgroundUri(String backgroundUri) {
		this.backgroundUri = backgroundUri;
	}

	public Integer getClockType() {
		return this.clockType;
	}

	public void setClockType(Integer clockType) {
		this.clockType = clockType;
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

	public String getGpsAddress() {
		return this.gpsAddress;
	}

	public void setGpsAddress(String gpsAddress) {
		this.gpsAddress = gpsAddress;
	}

	public String getMusic() {
		return this.music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getNotice() {
		return this.notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Integer getPlayMinute() {
		return this.playMinute;
	}

	public void setPlayMinute(Integer playMinute) {
		this.playMinute = playMinute;
	}

	public String getPlayMusic() {
		return this.playMusic;
	}

	public void setPlayMusic(String playMusic) {
		this.playMusic = playMusic;
	}

	public Integer getPlayType() {
		return this.playType;
	}

	public void setPlayType(Integer playType) {
		this.playType = playType;
	}

	public String getRepeatInfo() {
		return this.repeatInfo;
	}

	public void setRepeatInfo(String repeatInfo) {
		this.repeatInfo = repeatInfo;
	}

	public Integer getRepeatType() {
		return this.repeatType;
	}

	public void setRepeatType(Integer repeatType) {
		this.repeatType = repeatType;
	}

	public Boolean isDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public Boolean isOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Boolean isShake() {
		return shake;
	}

	public void setShake(Boolean shake) {
		this.shake = shake;
	}

	public Boolean isSkip() {
		return skip;
	}

	public void setSkip(Boolean skip) {
		this.skip = skip;
	}

	public String getSurpervise() {
		return this.surpervise;
	}

	public void setSurpervise(String surpervise) {
		this.surpervise = surpervise;
	}

	public Long getSyncTime() {
		return this.syncTime;
	}

	public void setSyncTime(Long syncTime) {
		this.syncTime = syncTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getUptTime() {
		return this.uptTime;
	}

	public void setUptTime(Long uptTime) {
		this.uptTime = uptTime;
	}

	public Long getSetTime() {
		return setTime;
	}

	public void setSetTime(Long setTime) {
		this.setTime = setTime;
	}

	public Integer getAdvanceOrder() {
		return advanceOrder;
	}

	public void setAdvanceOrder(Integer advanceOrder) {
		this.advanceOrder = advanceOrder;
	}

}
