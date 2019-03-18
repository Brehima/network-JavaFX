package tn.redhats.network.networkServer.services;

import javax.ejb.Remote;

@Remote
public interface AdminServiceRemote {
	String sayHello(String msg);
}
