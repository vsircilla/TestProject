package com.bsc.intg.svcs.model;

public class ServiceInstance {
	
	String name 		= 	null;
	String version		= 	null;
	String instance		=	null;
	String port			=	null;
	String adminPort	=	null;
	Service service		=	null;
	
	public ServiceInstance(String name, String version, String instance, String port, String adminPort) {
		this.name		=	name;
		this.version	=	version;
		this.instance	=	instance;
		this.port		=	port;
		this.adminPort	= 	adminPort;
	}

	
	
	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}



	public String getAdminPort() {
		return adminPort;
	}

	public void setAdminPort(String adminPort) {
		this.adminPort = adminPort;
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
	public String getInstance() {
		return instance;
	}
	public void setInstance(String instance) {
		this.instance = instance;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	

}
