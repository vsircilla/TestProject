package com.bsc.intg.svcs.model;

public class Service {

	String name				=		null;
	String version			=		null;
	String bundle			=	 	null;
	String jvmProperties	=		null;
	String appProperties	=		null;
	String uri				=		null;
	String group			=		null;
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getBundle() {
		return bundle;
	}
	public void setBundle(String bundle) {
		this.bundle = bundle;
	}
	public String getJvmProperties() {
		return jvmProperties;
	}
	public void setJvmProperties(String jvmProperties) {
		this.jvmProperties = jvmProperties;
	}
	public String getAppProperties() {
		return appProperties;
	}
	public void setAppProperties(String appProperties) {
		this.appProperties = appProperties;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String url) {
		this.uri = uri;
	}
	
	
}
