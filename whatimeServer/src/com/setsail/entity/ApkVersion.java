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
	
	@Column(name = "version", nullable=false, length=20)
	private String version;
	
	@Column(name = "url", nullable=false, length=1000)
	private String url;

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
	
	
}
