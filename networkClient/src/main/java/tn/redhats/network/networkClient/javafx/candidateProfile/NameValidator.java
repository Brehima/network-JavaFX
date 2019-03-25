package tn.redhats.network.networkClient.javafx.candidateProfile;

import com.jfoenix.validation.base.ValidatorBase;

import javafx.scene.control.TextInputControl;


public class NameValidator extends ValidatorBase{

	@Override
	protected void eval() {
		// TODO Auto-generated method stub
		if(srcControl.get() instanceof TextInputControl)
		{
			evalTextInputField();
		}
		
	}
	private void evalTextInputField()
	{
		TextInputControl textField = (TextInputControl) srcControl.get();
        try {
            String valeur = textField.getText();
            if((valeur.length()<=3 ) || (valeur.length() > 50))
            {
                hasErrors.set(true);
            }
            else
            {
               hasErrors.set(false);  
            }
            
        } catch (Exception e) {
            hasErrors.set(true);
        }
	}
  
}
