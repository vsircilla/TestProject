package com.bsc.intg.svcs.repository;

import com.bsc.intg.svcs.exception.ServiceAdminException;
import com.bsc.intg.svcs.model.ServiceInstance;

public interface RegistryRepository {

	ServiceInstance registerService(ServiceInstance si) throws ServiceAdminException;
	
	ServiceInstance unregisterService(ServiceInstance si) throws ServiceAdminException;

}
