package tn.redhats.network.networkServer.services;

import javax.ejb.Local;

import tn.redhats.network.networkServer.entities.User;

@Local
public interface UserServiceLocal {
	public User signIn(String id);
	public void addUser(User user);
}
