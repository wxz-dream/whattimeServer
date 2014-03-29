package com.setsail.entity.business;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the user_share_task_img database table.
 * 
 */
@Entity
@Table(name = "user_share_task_img")
@NamedQuery(name = "UserShareTaskImg.findAll", query = "SELECT u FROM UserShareTaskImg u")
public class UserShareTaskImg implements Serializable {
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

	public UserShareTaskImg() {
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Boolean getDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public String getTaskUuid() {
		return taskUuid;
	}

	public void setTaskUuid(String taskUuid) {
		this.taskUuid = taskUuid;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}