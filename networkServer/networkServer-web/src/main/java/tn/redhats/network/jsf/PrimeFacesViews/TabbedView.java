package tn.redhats.network.jsf.PrimeFacesViews;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services_impl.CandidatProfilService;

@ManagedBean
public class TabbedView {
     
    private List<User> users;
    @EJB
    private CandidatProfilService candidateService;
    @PostConstruct
    public void init() {
       users = candidateService.showContact(5);    
    }
    
     
    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
         
    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}