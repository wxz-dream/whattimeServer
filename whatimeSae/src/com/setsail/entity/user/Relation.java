package com.setsail.entity.user;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the relation database table.
 * 
 */
@Entity
@Table(name="relation")
@NamedQuery(name="Relation.findAll", query="SELECT r FROM Relation r")
public class Relation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=100)
	private String uuid;

	@Column(name="FRIEND_UUID", length=100)
	private String friendUuid;

	@Column(length=50)
	private String groups;

	@Column(name="NICK_NAME", length=100)
	private String nickName;

	@Column(name="USER_UUID", length=100)
	private String userUuid;

	public Relation() {
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFriendUuid() {
		return this.friendUuid;
	}

	public void setFriendUuid(String friendUuid) {
		this.friendUuid = friendUuid;
	}

	public String getGroups() {
		return this.groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserUuid() {
		return this.userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

}