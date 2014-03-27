package com.setsail.entity.user;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=100)
	private String uuid;

	@Column(name="AUTH_TYPE")
	private Integer authType;

	private Boolean available;

	@Column(length=50)
	private String city;

	
	@Column(name="CREATE_TIME")
	private Long createTime;

	@Column(length=100)
	private String email;

	@Column(name="IDENTITY_CARD", length=50)
	private String identityCard;

	@Column(name="DEL")
	private Boolean del;

	@Column(name="LEVEL_UUID", length=100)
	private String levelUuid;

	
	@Column(name="LOGIN_TIME")
	private Long loginTime;

	@Column(length=50)
	private String mime;

	@Column(name="NICK_NAME", length=100)
	private String nickName;

	@Column(length=50)
	private String password;

	@Column(name="PHONE_INFO", length=200)
	private String phoneInfo;

	@Column(length=20)
	private String qq;

	@Column(name="REAL_NAME", length=100)
	private String realName;

	private Integer sex;

	@Column(length=50)
	private String telphone;

	
	@Column(name="UPT_TIME")
	private Long uptTime;

	@Column(name="USER_NAME", length=50)
	private String userName;

	@Column(name="USERPHOTO_URI", length=100)
	private String userphotoUri;

	public User() {
	}

	public User(String uuid) {
		this.uuid = uuid;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getAuthType() {
		return this.authType;
	}

	public void setAuthType(Integer authType) {
		this.authType = authType;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentityCard() {
		return this.identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getLevelUuid() {
		return this.levelUuid;
	}

	public void setLevelUuid(String levelUuid) {
		this.levelUuid = levelUuid;
	}

	public Long getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}

	public String getMime() {
		return this.mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneInfo() {
		return this.phoneInfo;
	}

	public void setPhoneInfo(String phoneInfo) {
		this.phoneInfo = phoneInfo;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public Long getUptTime() {
		return this.uptTime;
	}

	public void setUptTime(Long uptTime) {
		this.uptTime = uptTime;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserphotoUri() {
		return this.userphotoUri;
	}

	public void setUserphotoUri(String userphotoUri) {
		this.userphotoUri = userphotoUri;
	}

	public Boolean isAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Boolean isDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

}