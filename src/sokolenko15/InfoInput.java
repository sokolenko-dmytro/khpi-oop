package ua.khpi.oop.sokolenko15;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import ua.khpi.oop.sokolenko11_12.*;

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
        while (!RegexProcessing.checkName(firstName)) {
            System.out.print("WARNING: Invalid. Try again: ");
            firstName = in.next();
        }
    	
    	return firstName;
    }
    
    private static String enterLastName() {
    	
    	System.out.println("Input prisoner's last name: ");
        String lastName = in.next();
        while (!RegexProcessing.checkName(lastName)) {
            System.out.print("WARNING: Invalid. Try again: ");
            lastName = in.next();
        }
    	
    	return lastName;
    }

    private static String enterPatronymic() {
    	
    	System.out.println("Input prisoner's patronymic: ");
        String patronymic = in.next();
        while (!RegexProcessing.checkName(patronymic)) {
            System.out.print("WARNING: Invalid. Try again: ");
            patronymic = in.next();
        }
    	
    	return patronymic;
    }
    
    private static Calendar enterDob() {
    	
    	System.out.println("Input prisoner's day of birth: ");
        String birtheyDay = in.next();
        while (!RegexProcessing.checkNum(birtheyDay)) {
            System.out.print("WARNING: Invalid. Try again: ");
            birtheyDay = in.next();
        }
        
        System.out.println("Input prisoner's month of birth: ");
        String birtheyMonth = in.next();
        while (!RegexProcessing.checkNum(birtheyMonth)) {
            System.out.print("WARNING: Invalid. Try again: ");
            birtheyMonth = in.next();
        }
        
        System.out.println("Input prisoner's year of birth: ");
        String birtheyYear = in.next();
        while (!RegexProcessing.checkNum(birtheyYear)) {
            System.out.print("WARNING: Invalid. Try again: ");
            birtheyYear = in.next();
        }
    	
        Calendar newDob = new GregorianCalendar
        		(Integer.parseInt(birtheyDay), Integer.parseInt(birtheyMonth), Integer.parseInt(birtheyYear));
        
    	return newDob;
    }
    
	private static String enterEyeColor() {
	
		System.out.println("Input prisoner's eye color: ");
		String eyeColor = in.next();
		while (!RegexProcessing.checkName(eyeColor)) {
			System.out.print("WARNING: Invalid. Try again: ");
			eyeColor = in.next();
		}
	
		return eyeColor;
	}
		
    private static Calendar enterImpDate() {
    	
    	System.out.println("Input prisoner's day of imprisonment: ");
        String imprisonmentDay = in.next();
        while (!RegexProcessing.checkNum(imprisonmentDay)) {
            System.out.print("WARNING: Invalid. Try again: ");
            imprisonmentDay = in.next();
        }
        
        System.out.println("Input prisoner's month of imprisonment: ");
        String imprisonmentMonth = in.next();
        while (!RegexProcessing.checkNum(imprisonmentMonth)) {
            System.out.print("WARNING: Invalid. Try again: ");
            imprisonmentMonth = in.next();
        }
        
        System.out.println("Input prisoner's year of imprisonment: ");
        String imprisonmentYear = in.next();
        while (!RegexProcessing.checkNum(imprisonmentYear)) {
            System.out.print("WARNING: Invalid. Try again: ");
            imprisonmentYear = in.next();
        }
    	
        Calendar newImpDate = new GregorianCalendar
        		(Integer.parseInt(imprisonmentDay), Integer.parseInt(imprisonmentMonth), Integer.parseInt(imprisonmentYear));
        
    	return newImpDate;
    }
    
    private static Calendar enterReleaseDate() {
    	
    	System.out.println("Input prisoner's day of release: ");
        String releaseDay = in.next();
        while (!RegexProcessing.checkNum(releaseDay)) {
            System.out.print("WARNING: Invalid. Try again: ");
            releaseDay = in.next();
        }
        
        System.out.println("Input prisoner's month of release: ");
        String releaseMonth = in.next();
        while (!RegexProcessing.checkNum(releaseMonth)) {
            System.out.print("WARNING: Invalid. Try again: ");
            releaseMonth = in.next();
        }
        
        System.out.println("Input prisoner's year of release: ");
        String releaseYear = in.next();
        while (!RegexProcessing.checkNum(releaseYear)) {
            System.out.print("WARNING: Invalid. Try again: ");
            releaseYear = in.next();
        }
    	
        Calendar newReleaseDate = new GregorianCalendar
        		(Integer.parseInt(releaseDay), Integer.parseInt(releaseMonth), Integer.parseInt(releaseYear));
        
    	return newReleaseDate;
    }
    
    private static String enterTattooDesc() {
    	
		System.out.println("Input prisoner's tattoo description: ");
		String tattooDesc = in.next();
		while (!RegexProcessing.checkName(tattooDesc)) {
			System.out.print("WARNING: Invalid. Try again: ");
			tattooDesc = in.next();
		}
	
		return tattooDesc;
	}

    public static int enterFewData() {
    	System.out.println("Enter amount of data: ");
    	String data = in.next();
        while (!RegexProcessing.checkName(data)) {
            System.out.print("Invalid Data. Try again: ");
            data = in.next();
        }
        return Integer.parseInt(data);
    }
    
    public static int enterTimer() {
        System.out.println("Set the timer [0 - 100 000 ms]: ");
        String timer = in.next();
        while (!RegexProcessing.checkNum(timer)) {
            System.out.print("Invalid number. Try again: ");
            timer = in.next();
        }
        return Integer.parseInt(timer);
}

}

    
