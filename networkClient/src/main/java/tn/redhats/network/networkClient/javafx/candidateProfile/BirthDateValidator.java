package tn.redhats.network.networkClient.javafx.candidateProfile;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import com.jfoenix.validation.base.ValidatorBase;

import javafx.scene.control.TextInputControl;

public class BirthDateValidator extends ValidatorBase{
	
	private int year;
	private int todayYear;
	public BirthDateValidator() {
		super();
		this.year = 0;
		
		todayYear = LocalDate.now().getYear();;
	}

	@Override
	protected void eval() {
		// TODO Auto-generated method stub
		
			evalBirthDateField();
		
	}
	
	private void evalBirthDateField()
	{
		
		
        try {
           
            if( Math.abs(year-todayYear)< 18  || Math.abs(year-todayYear) > 70)
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	

}
