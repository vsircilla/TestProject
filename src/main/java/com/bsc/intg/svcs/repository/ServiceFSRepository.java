package com.bsc.intg.svcs.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.configuration.PropertiesConfiguration;

import com.bsc.intg.svcs.exception.ServiceAdminException;
import com.bsc.intg.svcs.model.Service;
import com.bsc.intg.svcs.model.ServiceInstance;

public class ServiceFSRepository implements ServiceRepository {

	private String serviceConfigPath = null;
	
	public ServiceFSRepository(String serviceConfigPath) {
		this.serviceConfigPath=serviceConfigPath;
		
	}
	public Service createService(Service s) throws ServiceAdminException {
		
		
        try {   		
        	
        	String sq	= 	s.getName() + "." + s.getVersion() + ".properties";
        	
        	String serviceConfigFile =  serviceConfigPath + "/" + sq ;
        	
        	File scfile = new File(serviceConfigFile);

        	if( ! scfile.exists() )
        		scfile.createNewFile();
        
        	PropertiesConfiguration config = new PropertiesConfiguration(serviceConfigFile);
	    	
        	config.addProperty("name", s.getName());
        	config.addProperty("version", s.getVersion());
        	config.addProperty("uri", s.getUri());
        	config.addProperty("bundle", s.getBundle());
        	config.addProperty("jvmProperties", s.getJvmProperties());
        	config.addProperty("appProperties", s.getAppProperties());
        	
        	config.save();
        	
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceAdminException("SERVICE_CONFI_CREATE_ERROR", "Error occurred while creating service config" + e.toString());
		}
        
		return s;
	}

	public Service deleteService(Service s) {

		return null;
	}

	public Service updateService(Service s) {
		return null;
	}

	public Service addServiceInstance(ServiceInstance si) {
		
		try {
			
			Path path = Paths.get("/tmp/foo/bar.txt");
			Service s = si.getService(); 
        
			Files.createDirectories(path.getParent());
            Files.createFile(path);
            
        } catch (FileAlreadyExistsException e) {
            System.err.println("already exists: " + e.getMessage());
        }  catch (IOException e1) {
			e1.printStackTrace();
		}

		
		return null;
	}

	public Service deleteService(ServiceInstance si) {
		return null;
	}

	public List<ServiceInstance> getServiceInstances() {
		return null;
	}
	

	public List<Service> getServices() {
		return null;
	}
	public Service createServiceInstance(ServiceInstance si) {
		// TODO Auto-generated method stub
		return null;
	}
	public Service removeServiceInstance(ServiceInstance si) {
		// TODO Auto-generated method stub
		return null;
	}
	public Service getServiceFromInstance(ServiceInstance si) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<ServiceInstance> getServiceInstances(Service s) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
