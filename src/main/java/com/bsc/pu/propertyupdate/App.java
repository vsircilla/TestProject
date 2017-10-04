package com.bsc.pu.propertyupdate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.naming.ConfigurationException;

import com.bsc.intg.svcs.model.ServiceInstance;
import com.bsc.intg.svcs.repository.RegistryFSRepository;
import com.bsc.intg.svcs.repository.RegistryRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ConfigurationException
    {
        
        try {
    		
        	ServiceInstance si=new ServiceInstance("StormerService", "v1", "2","","");
        	
        	RegistryRepository registry=new RegistryFSRepository("c:/temp/Registry.properties");
	
        	//registry.registerService(si);
        	//registry.unregisterService(si);

        	Path file = Paths.get("/temp/file.txt");
        	Path fileLink = Paths.get("/temp/link.txt");
        	try {
        	    Files.createSymbolicLink(fileLink, file);
        	} catch (IOException e) {
        	    e.printStackTrace();
        	}

        	
		} catch (Exception e) {
			e.printStackTrace();
		}

		
    }



    

}
