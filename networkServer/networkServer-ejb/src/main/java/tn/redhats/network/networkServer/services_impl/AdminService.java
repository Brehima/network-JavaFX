package tn.redhats.network.networkServer.services_impl;

import javax.ejb.Stateless;

import tn.redhats.network.networkServer.services.AdminServiceLocal;
import tn.redhats.network.networkServer.services.AdminServiceRemote;


@Stateless
public class AdminService implements AdminServiceLocal, AdminServiceRemote{
	@Override
	public String sayHello(String msg) {
		return msg;
	}
}
