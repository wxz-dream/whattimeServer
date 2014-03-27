package com.setsail.entity.user;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the level database table.
 * 
 */
@Entity
@Table(name="level")
@NamedQuery(name="Level.findAll", query="SELECT l FROM Level l")
public class Level implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=100)
	private String uuid;

	@Column(name="AUTH_UUID", length=100)
	private String authUuid;

	@Column(name="LEVEL_NUM")
	private Integer levelNum;

	public Level() {
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAuthUuid() {
		return this.authUuid;
	}

	public void setAuthUuid(String authUuid) {
		this.authUuid = authUuid;
	}

	public Integer getLevelNum() {
		return this.levelNum;
	}

	public void setLevelNum(Integer levelNum) {
		this.levelNum = levelNum;
	}

}