package com.setsail.entity.user;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the friend_req database table.
 * 
 */
@Entity
@Table(name="friend_req")
@NamedQuery(name="FriendReq.findAll", query="SELECT f FROM FriendReq f")
public class FriendReq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=100)
	private String uuid;

	private int access;

	@Column(name="FRIEND_REQ_UUID", length=100)
	private String friendReqUuid;

	@Column(name="NICK_NAME", length=100)
	private String nickName;

	@Column(length=200)
	private String remark;

	@Column(name="REQUEST_TIME")
	private Long requestTime;

	
	@Column(name="UPT_TIME")
	private Long uptTime;

	@Column(name="USER_UUID", length=100)
	private String userUuid;

	@Column(name="USERPHOTO_URI", length=100)
	private String userphotoUri;

	public FriendReq() {
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getAccess() {
		return this.access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public String getFriendReqUuid() {
		return this.friendReqUuid;
	}

	public void setFriendReqUuid(String friendReqUuid) {
		this.friendReqUuid = friendReqUuid;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getRequestTime() {
		return this.requestTime;
	}

	public void setRequestTime(Long requestTime) {
		this.requestTime = requestTime;
	}

	public Long getUptTime() {
		return this.uptTime;
	}

	public void setUptTime(Long uptTime) {
		this.uptTime = uptTime;
	}

	public String getUserUuid() {
		return this.userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getUserphotoUri() {
		return this.userphotoUri;
	}

	public void setUserphotoUri(String userphotoUri) {
		this.userphotoUri = userphotoUri;
	}

}
