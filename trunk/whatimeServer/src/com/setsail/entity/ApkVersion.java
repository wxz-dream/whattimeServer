package com.setsail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="apk_version")
public class ApkVersion {

	@Id
	@Column(unique=true, nullable=false, length=36)
	private String uuid;
	
	@Column(name = "version", nullable=false, unique=true, length=20)
	private String version;
	
	@Column(name = "url", nullable=false, length=1000)
	private String url;
	
	@Column(name = "size")
	private Long size;
	
	@Column(name = "des", length=1000)
	private String des;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
	
}
