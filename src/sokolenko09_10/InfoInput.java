package ua.khpi.oop.sokolenko09_10;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class InfoInput {
    private static Scanner in = new Scanner(System.in);

    public static Prisoner insert() {
    	Prisoner newPrisoner = new Prisoner();
    	
    	newPrisoner.setFirstName(enterFirstName());
    	newPrisoner.setLastName(enterLastName());
    	newPrisoner.setPatronymic(enterPatronymic());
    	newPrisoner.setDob(enterDob());
    	newPrisoner.setEyeColor(enterEyeColor());
    	newPrisoner.setImprisonmentDate(enterImpDate());
    	newPrisoner.setImprisonmentDate(enterReleaseDate());
    	newPrisoner.setTattooDescription(enterTattooDesc());

        return newPrisoner;
    }

    private static String enterFirstName() {
    	
    	System.out.println("Input prisoner's first name: ");
        String firstName = in.next();
    	
    	return firstName;
    }
    
    private static String enterLastName() {
    	
    	System.out.println("Input prisoner's last name: ");
        String lastName = in.next();
    	
    	return lastName;
    }

    private static String enterPatronymic() {
    	
    	System.out.println("Input prisoner's patronymic: ");
        String patronymic = in.next();
    	
    	return patronymic;
    }
    
    private static Calendar enterDob() {
    	
    	System.out.println("Input prisoner's day of birth: ");
        String birtheyDay = in.next();
        
        System.out.println("Input prisoner's month of birth: ");
        String birtheyMonth = in.next();
        
        System.out.println("Input prisoner's year of birth: ");
        String birtheyYear = in.next();
        
        Calendar newDob = new GregorianCalendar
        		(Integer.parseInt(birtheyDay), Integer.parseInt(birtheyMonth), Integer.parseInt(birtheyYear));
        
    	return newDob;
    }
    
	private static String enterEyeColor() {
	
		System.out.println("Input prisoner's eye color: ");
		String eyeColor = in.next();
	
		return eyeColor;
	}
		
    private static Calendar enterImpDate() {
    	
    	System.out.println("Input prisoner's day of imprisonment: ");
        String imprisonmentDay = in.next();
        
        System.out.println("Input prisoner's month of imprisonment: ");
        String imprisonmentMonth = in.next();
        
        System.out.println("Input prisoner's year of imprisonment: ");
        String imprisonmentYear = in.next();
    	
        Calendar newImpDate = new GregorianCalendar
        		(Integer.parseInt(imprisonmentDay), Integer.parseInt(imprisonmentMonth), Integer.parseInt(imprisonmentYear));
        
    	return newImpDate;
    }
    
    private static Calendar enterReleaseDate() {
    	
    	System.out.println("Input prisoner's day of release: ");
        String releaseDay = in.next();
        
        System.out.println("Input prisoner's month of release: ");
        String releaseMonth = in.next();
        
        System.out.println("Input prisoner's year of release: ");
        String releaseYear = in.next();
    	
        Calendar newReleaseDate = new GregorianCalendar
        		(Integer.parseInt(releaseDay), Integer.parseInt(releaseMonth), Integer.parseInt(releaseYear));
        
    	return newReleaseDate;
    }
    
    private static String enterTattooDesc() {
    	
		System.out.println("Input prisoner's tattoo description: ");
		String tattooDesc = in.next();
	
		return tattooDesc;
	}


}