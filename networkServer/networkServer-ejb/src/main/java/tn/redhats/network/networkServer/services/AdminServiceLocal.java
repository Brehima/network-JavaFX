package tn.redhats.network.networkServer.services;

import javax.ejb.Local;

@Local
public interface AdminServiceLocal {
	String sayHello(String msg);
}
