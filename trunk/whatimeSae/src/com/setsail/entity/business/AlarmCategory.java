package com.setsail.entity.business;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the alarm_category database table.
 * 
 */
@Entity
@Table(name="alarm_category")
@NamedQuery(name="AlarmCategory.findAll", query="SELECT a FROM AlarmCategory a")
public class AlarmCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=100)
	private String uuid;

	@Column(length=100)
	private String des;

	@Column(name="IS_DEL")
	private int isDel;

	@Column(length=50)
	private String name;

	@Column(name="PARENT_UUID", length=100)
	private String parentUuid;

	public AlarmCategory() {
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public int getIsDel() {
		return this.isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentUuid() {
		return this.parentUuid;
	}

	public void setParentUuid(String parentUuid) {
		this.parentUuid = parentUuid;
	}

}