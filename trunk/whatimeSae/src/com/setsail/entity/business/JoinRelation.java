package com.setsail.entity.business;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the join_relation database table.
 * 
 */
@Entity
@Table(name="join_relation")
@NamedQuery(name="JoinRelation.findAll", query="SELECT j FROM JoinRelation j")
public class JoinRelation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=100)
	private String uuid;

	@Column(name="ALARM_UUID", length=100)
	private String alarmUuid;

	@Column(name="USER_UUID", length=100)
	private String userUuid;

	public JoinRelation() {
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAlarmUuid() {
		return this.alarmUuid;
	}

	public void setAlarmUuid(String alarmUuid) {
		this.alarmUuid = alarmUuid;
	}

	public String getUserUuid() {
		return this.userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

}