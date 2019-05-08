package tn.redhats.network.networkServer.services;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;

import tn.redhats.network.networkServer.entities.Message;

@Remote
@LocalBean
public interface MessageServiceRemote {

	void RemoveMessage (int id );
	void AddMessage (Message m);
	void UpdateMessage(int id);
	Message findMessageById (int id);
	List<Message> findAllMessage();


	}

