package com.bsc.intg.svcs.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.configuration.PropertiesConfiguration;

import com.bsc.intg.svcs.exception.ServiceAdminException;
import com.bsc.intg.svcs.model.ServiceInstance;

public class RegistryFSRepository implements RegistryRepository{
	
	private String registryPath		= 	null;
	
	public RegistryFSRepository(String registryPath) {
		this.registryPath=registryPath;
	}
	
	public ServiceInstance registerService(ServiceInstance si) throws ServiceAdminException {
		
		
        try {
    		
        	
        	String sq	= 	si.getName() + "." + si.getVersion() + "." + si.getInstance();
        	
        	
        	List<Integer> allocatedPorts=new ArrayList<Integer>();
        	
	    	PropertiesConfiguration config = new PropertiesConfiguration(registryPath);
	    	
	    	int startPort	=	config.getInt("Registry.start.port");
	    	int endPort		=	config.getInt("Registry.end.port");
	    	
	    	
	    	String servicePort=config.getString( sq + ".service.port");
	    	
	    
	    	if ( servicePort != null  ) {
	    		si.setPort(servicePort);
	    	} else {
	    		
		    	Iterator<String> itr = config.getKeys();
		   	
		    	while(itr.hasNext()) {
		    		 String key = itr.next();
		    		 if (key.contains("service.port")) {
		    			 Integer port= config.getInteger(key,null);
		    			 allocatedPorts.add(port);
		    		 }
		         }
		    	
		    	int assignedPort=0;
		    	
		    	for (int p=startPort; p<endPort;p+=2) {
		    		if (allocatedPorts.contains(new Integer(p))) {
		    			continue;
		    		} else {
		    			assignedPort=p;
		    			break;
		    		}
		    	}

		    	si.setPort(String.valueOf(assignedPort));
		    	si.setAdminPort(String.valueOf(assignedPort + 1));

		    	config.addProperty(sq+".service.port", si.getPort());
		    	config.addProperty(sq+".admin.port", si.getAdminPort());
		    	config.save();
		    	
	    	}	    	

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceAdminException("SERVICE_REGISTER_ERROR", "Error occurred while registering the service" + e.toString());
		}        
		
		return si;
		
	}
	
	public  ServiceInstance unregisterService(ServiceInstance si) throws ServiceAdminException {
		
		
        try {
    		
        	
        	String sq	= 	si.getName() + "." + si.getVersion() + "." + si.getInstance();
        	
	    	PropertiesConfiguration config = new PropertiesConfiguration(registryPath);
	    	
	    	String servicePort=config.getString( sq + ".service.port");
	    	String serviceAdminPort=config.getString( sq + ".admin.port");
	    

	    	si.setPort(servicePort);
	    	si.setAdminPort(serviceAdminPort);

	    	if ( servicePort != null  ) {
	    		
	    		config.clearProperty( sq + ".service.port");
	    		config.clearProperty(sq + ".admin.port");
	    		config.save();
	    	}     	

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceAdminException("SERVICE_UNREGISTER_ERROR", "Error occurred while unregistering the service" + e.toString());
		}

		return si;
		
	}

}
