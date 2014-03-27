package com.setsail.entity.business;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the user_local_task_img database table.
 * 
 */
@Entity
@Table(name = "user_local_task_img")
@NamedQuery(name = "UserLocalTaskImg.findAll", query = "SELECT u FROM UserLocalTaskImg u")
public class UserLocalTaskImg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 100)
	private String uuid;

	@Column(name = "DEL")
	private Boolean del;

	@Column(name = "TASK_UUID", length = 100)
	private String taskUuid;

	@Column(length = 100)
	private String uri;

	public UserLocalTaskImg() {
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public Boolean isDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

}