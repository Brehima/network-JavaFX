package tn.redhats.network.networkClient.javafx.candidateProfile;

import com.jfoenix.validation.base.ValidatorBase;

import javafx.scene.control.TextInputControl;

public class usernameValidator extends ValidatorBase{
	public Boolean checkExistUsername = true;
	
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
                message.setValue( "this username is too short");
                hasErrors.set(true);
            }
            else
            {
            	if(checkExistUsername==true)
            	{
                	message.setValue("this username already exist");
                	hasErrors.set(true);
            	}
            	else
            	{
                    message.setValue("");
                    hasErrors.set(false);
            	}
            	
            }
                       
        } catch (Exception e) {
        	message.setValue("please enter your username");
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
