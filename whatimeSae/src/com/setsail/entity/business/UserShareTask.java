package com.setsail.entity.business;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the user_share_task database table.
 * 
 */
@Entity
@Table(name="user_share_task")
@NamedQuery(name="UserShareTask.findAll", query="SELECT u FROM UserShareTask u")
public class UserShareTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=100)
	private String uuid;

	@Column(length=100)
	private String address;

	@Column(name="ALARM_TIME")
	private int alarmTime;

	@Column(name="ALARM_UUID", length=100)
	private String alarmUuid;

	@Column(name="BACKGROUND_URI", length=100)
	private String backgroundUri;

	@Column(name="CLOCK_TYPE")
	private int clockType;

	
	@Column(name="CREATE_TIME")
	private Long createTime;

	@Column(name="DELAY_MINUTE")
	private int delayMinute;

	@Column(name="DELAY_ORDER")
	private int delayOrder;

	@Column(name="DELAY_TYPE")
	private int delayType;

	@Column(length=500)
	private String des;

	@Column(name="GPS_ADDRESS", length=100)
	private String gpsAddress;

	@Column(name="IS_DEL")
	private int isDel;

	@Column(name="IS_OPEN")
	private int isOpen;

	@Column(length=100)
	private String music;

	@Column(length=500)
	private String notice;

	@Column(name="PLAY_MINUTE")
	private int playMinute;

	@Column(name="PLAY_MUSIC", length=100)
	private String playMusic;

	@Column(name="PLAY_TYPE")
	private int playType;

	@Column(name="REPEAT_INFO", length=100)
	private String repeatInfo;

	@Column(name="REPEAT_TYPE")
	private int repeatType;

	private int shake;

	private int skip;

	@Column(length=100)
	private String surpervise;

	
	@Column(name="SYNC_TIME")
	private Long syncTime;

	@Column(length=100)
	private String title;

	
	@Column(name="UPT_TIME")
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

	public int getAlarmTime() {
		return this.alarmTime;
	}

	public void setAlarmTime(int alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getAlarmUuid() {
		return this.alarmUuid;
	}

	public void setAlarmUuid(String alarmUuid) {
		this.alarmUuid = alarmUuid;
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

	public int getDelayMinute() {
		return this.delayMinute;
	}

	public void setDelayMinute(int delayMinute) {
		this.delayMinute = delayMinute;
	}

	public int getDelayOrder() {
		return this.delayOrder;
	}

	public void setDelayOrder(int delayOrder) {
		this.delayOrder = delayOrder;
	}

	public int getDelayType() {
		return this.delayType;
	}

	public void setDelayType(int delayType) {
		this.delayType = delayType;
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

	public int getIsDel() {
		return this.isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
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

	public int getShake() {
		return this.shake;
	}

	public void setShake(int shake) {
		this.shake = shake;
	}

	public int getSkip() {
		return this.skip;
	}

	public void setSkip(int skip) {
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

}