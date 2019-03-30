package tn.redhats.network.networkClient.javafx.candidateProfile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfoenix.validation.base.ValidatorBase;

import javafx.scene.control.TextInputControl;

public class EmailValidator extends ValidatorBase{
	public Boolean checkExistEmail = true;
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	@Override
	protected void eval()
	{
		evalEmailField();
	}
	
	private void evalEmailField()
	{
		TextInputControl textField = (TextInputControl) srcControl.get();
        try {
            String valeur = textField.getText();
           
            if(validate(valeur)==false )
            {
                message.setValue( "this email is not valid");
                hasErrors.set(true);
            }
            else
            {
            	if(checkExistEmail==true)
            	{
                	message.setValue("this email already exist");
                	hasErrors.set(true);
            	}
            	else
            	{
                    message.setValue("");
                    hasErrors.set(false);
            	}
            	
            }
                       
        } catch (Exception e) {
        	message.setValue("please enter you email");
            hasErrors.set(true);
        }
	}
	
	public static boolean validate(String emailStr) 
	{
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		return matcher.find();
	}

	public Boolean getCheckExistEmail() {
		return checkExistEmail;
	}

	public void setCheckExistEmail(Boolean checkExistEmail) {
		this.checkExistEmail = checkExistEmail;
	}
	
}
