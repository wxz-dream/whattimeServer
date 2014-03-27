package com.setsail.entity.business;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the alarm_category database table.
 * 
 */
@Entity
@Table(name = "alarm_category")
@NamedQuery(name = "AlarmCategory.findAll", query = "SELECT a FROM AlarmCategory a")
public class AlarmCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(length = 100)
	private String des;

	@Column(name = "DEL")
	private boolean del;

	@Column(length = 50)
	private String name;

	@Column(name = "PARENT_ID", length = 100)
	private Long parentId;
	@Column(name = "IMG_URI", length = 100)
	private String imgUri;

	public AlarmCategory() {
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUri() {
		return imgUri;
	}

	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}