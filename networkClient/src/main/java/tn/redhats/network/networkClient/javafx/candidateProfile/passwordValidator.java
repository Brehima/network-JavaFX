package tn.redhats.network.networkClient.javafx.candidateProfile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfoenix.validation.base.ValidatorBase;

import javafx.scene.control.TextInputControl;

public class passwordValidator extends ValidatorBase {
	public static final Pattern VALID_PASS_REGEX =  Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{8,})", Pattern.CASE_INSENSITIVE);
	public  String msg="";
	@Override
	protected void eval() {
		// TODO Auto-generated method stub
		evalTextInputField();
	}
	private void evalTextInputField()
	{
		TextInputControl textField = (TextInputControl) srcControl.get();
        try {
            String valeur = textField.getText();
            if(valeur.length() < 8)
            {
          
            	msg="your password should have at least 8 caracters";
            	
                hasErrors.set(true);
            }
            else
            {
              if(validate(valeur)==false)
              {
            
            	  
            	  msg="your password should contains at least 1 (special,numeric,upper case,lower case) carcters ex:cr0cKM@IfUCan";
            	  hasErrors.set(true);
              }
              else
              {
            	
            	  msg="";
            	  hasErrors.set(false);  
              }
                
            }
            
        } catch (Exception e) {
        
        	msg="please enter a password";
            hasErrors.set(true);            
        }
	}
	
	public static boolean validate(String pass) 
	{
		Matcher matcher = VALID_PASS_REGEX.matcher(pass);
		return matcher.find();
	}


}