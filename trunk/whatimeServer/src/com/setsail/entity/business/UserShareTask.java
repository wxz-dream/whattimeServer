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
	private int clockType;

	@Column(name = "CREATE_TIME")
	private Long createTime;

	@Column(name = "STE_TIME")
	private Long setTime;

	@Column(name = "ADVANCE_ORDER")
	private int advanceOrder;

	@Column(length = 500)
	private String des;

	@Column(name = "GPS_ADDRESS", length = 100)
	private String gpsAddress;

	@Column(name = "DEL")
	private boolean del;

	@Column(name = "OPEN")
	private boolean open;

	@Column(length = 100)
	private String music;

	@Column(length = 500)
	private String notice;

	@Column(name = "PLAY_MINUTE")
	private int playMinute;

	@Column(name = "PLAY_MUSIC", length = 100)
	private String playMusic;

	@Column(name = "PLAY_TYPE")
	private int playType;

	@Column(name = "REPEAT_INFO", length = 100)
	private String repeatInfo;

	@Column(name = "REPEAT_TYPE")
	private int repeatType;

	private boolean shake;

	private boolean skip;

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

	// public String getAlarmUuid() {
	// return this.alarmUuid;
	// }
	//
	// public void setAlarmUuid(String alarmUuid) {
	// this.alarmUuid = alarmUuid;
	// }

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

	public int getClockType() {
		return this.clockType;
	}

	public void setClockType(int clockType) {
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

	public int getPlayMinute() {
		return this.playMinute;
	}

	public void setPlayMinute(int playMinute) {
		this.playMinute = playMinute;
	}

	public String getPlayMusic() {
		return this.playMusic;
	}

	public void setPlayMusic(String playMusic) {
		this.playMusic = playMusic;
	}

	public int getPlayType() {
		return this.playType;
	}

	public void setPlayType(int playType) {
		this.playType = playType;
	}

	public String getRepeatInfo() {
		return this.repeatInfo;
	}

	public void setRepeatInfo(String repeatInfo) {
		this.repeatInfo = repeatInfo;
	}

	public int getRepeatType() {
		return this.repeatType;
	}

	public void setRepeatType(int repeatType) {
		this.repeatType = repeatType;
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

	public boolean isShake() {
		return shake;
	}

	public void setShake(boolean shake) {
		this.shake = shake;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
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

	public int getAdvanceOrder() {
		return advanceOrder;
	}

	public void setAdvanceOrder(int advanceOrder) {
		this.advanceOrder = advanceOrder;
	}

}
