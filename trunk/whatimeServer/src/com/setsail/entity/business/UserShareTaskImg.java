package com.setsail.entity.business;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_share_task_img database table.
 * 
 */
@Entity
@Table(name="user_share_task_img")
@NamedQuery(name="UserShareTaskImg.findAll", query="SELECT u FROM UserShareTaskImg u")
public class UserShareTaskImg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=100)
	private String uuid;

	@Column(name="IS_DEL")
	private int isDel;

	@Column(name="TASK_UUID", length=100)
	private String taskUuid;

	@Column(length=100)
	private String uri;

	public UserShareTaskImg() {
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getIsDel() {
		return this.isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public String getTaskUuid() {
		return this.taskUuid;
	}

	public void setTaskUuid(String taskUuid) {
		this.taskUuid = taskUuid;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}