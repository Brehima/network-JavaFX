package tn.redhats.network.networkServer.services_impl;



import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javafx.animation.Animation.Status;
import tn.redhats.network.networkServer.entities.Message;
import tn.redhats.network.networkServer.enumeration.messageStatus;
import tn.redhats.network.networkServer.services.MessageServiceLocal;
import tn.redhats.network.networkServer.services.MessageServiceRemote;

@Stateless
public class MessageService implements MessageServiceRemote, MessageServiceLocal {
	
	@PersistenceContext(unitName="networkServer-ejb")
	EntityManager em;
	
	@Override
	public void RemoveMessage(int id) {
		// TODO Auto-generated method stub
		Message m = findMessageById(id);
		if (m != null)
		{
			em.remove(m);
		}
		
	}
	
	
	@Override
	public void AddMessage(Message m) {
		em.persist(m);
	}
	
	
	@Override
	public void UpdateMessage(int id) {
		// TODO Auto-generated method stub
		Message m = em.find(Message.class, id);
		m.setStatus(messageStatus.AWAY);
	}
	
	@Override
	public List<Message> findAllMessage() {
		// TODO Auto-generated method stub
		List<Message> m = em.createQuery("select m from Message m", Message.class).getResultList();
	    return m; 
	}
	
	
	@Override
	public Message findMessageById(int id) {
		// TODO Auto-generated method stub
		return em.find(Message.class, id);
	}
	
	
	
	
}
	


