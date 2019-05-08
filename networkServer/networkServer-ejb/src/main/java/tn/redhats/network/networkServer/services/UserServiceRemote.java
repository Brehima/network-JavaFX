package tn.redhats.network.networkServer.services;

import javax.ejb.Remote;

import tn.redhats.network.networkServer.entities.User;

@Remote
public interface UserServiceRemote {
	public User signIn(String id);
	public void addUser(User user);
}
