package tn.redhats.network.networkServer.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;

import tn.redhats.network.networkServer.entities.Message;

@Local
@LocalBean
public interface MessageServiceLocal {
	
	void RemoveMessage (int id );
	void AddMessage (Message m);
	Message findMessageById (int id);
	List<Message> findAllMessage();
	void UpdateMessage(int id);
	
}
