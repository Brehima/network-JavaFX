package tn.redhats.network.networkClient.javafx.candidateProfile;

import com.jfoenix.validation.base.ValidatorBase;

import javafx.scene.control.TextInputControl;

public class usernameValidator extends ValidatorBase{
	public Boolean checkExistUsername = true;
	public String msg="";
	@Override
	protected void eval() {
		// TODO Auto-generated method stub
		evalUsernameField();
	}
	
	private void evalUsernameField()
	{
		TextInputControl textField = (TextInputControl) srcControl.get();
        try {
            String valeur = textField.getText();
           
            if(valeur.length()<=3 )
            {
                msg= "this username is too short";
                hasErrors.set(true);
            }
            else
            {
            	if(checkExistUsername==true)
            	{
                	msg="this username already exist";
                	hasErrors.set(true);
            	}
            	else
            	{
                    msg="";
                    hasErrors.set(false);
            	}
            	
            }
                       
        } catch (Exception e) {
        
        	msg="please enter your username";
            hasErrors.set(true);
        }
	}

	public Boolean getCheckExistUsername() {
		return checkExistUsername;
	}

	public void setCheckExistUsername(Boolean checkExistUsername) {
		this.checkExistUsername = checkExistUsername;
	}
	

}
