package ua.khpi.oop.sokolenko11_12;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Date;
import java.io.Serializable;

public class Prisoner implements Serializable,Comparable<Prisoner> {
	private String firstName;
	private String patronymic;
	private String lastName;
	private Calendar dob;
	private String eyeColor;
	private Calendar imprisonmentDate;
	private Calendar releaseDate;
	private String tattooDescription;
	
	private static final long serialVersionUID = 1L;
	
	public Prisoner() {
		
	}
	
	public Prisoner(String newFirstName,
			String newPatronymic,
			String newLastName,
			int dobDay,
			int dobMonth,
			int dobYear,
			String newEyeColor,
			int imprisonDay,
			int imprisonMonth,
			int imprisonYear,
			int releaseDay,
			int releaseMonth,
			int releaseYear,
			String newTattooDescription) {
		
		firstName = newFirstName;
		patronymic = newPatronymic;
		lastName = newLastName;
		dob = new GregorianCalendar(dobYear, dobMonth - 1, dobDay);
		eyeColor = newEyeColor;
		imprisonmentDate = new GregorianCalendar(imprisonYear, imprisonMonth - 1, imprisonDay);
		releaseDate = new GregorianCalendar(releaseYear, releaseMonth - 1, releaseDay);
		tattooDescription = newTattooDescription;
	}
	
	public Prisoner(String newFirstName,
			String newPatronymic,
			String newLastName,
			Calendar newDob,
			String newEyeColor,
			Calendar newImprisonmentDate,
			Calendar newReleaseDate,
			String newTattooDescription) {
		
		firstName = newFirstName;
		patronymic = newPatronymic;
		lastName = newLastName;
		dob = newDob;
		eyeColor = newEyeColor;
		imprisonmentDate = newImprisonmentDate;
		releaseDate = newReleaseDate;
		tattooDescription = newTattooDescription;
	}
	
	public void setFirstName(String newFirstName){
		firstName = newFirstName;
	}
	public String getFirstName(){
		return firstName;
	}
	
	
	public void setPatronymic(String newPatronymic){
		patronymic = newPatronymic;
	}
	public String getPatronymic(){
		return patronymic;
	}
	
	
	public void setLastName(String newLastName){
		lastName = newLastName;
	}
	public String getLastName(){
		return lastName;
	}
	
	
	public void setDob(Calendar newDob){
		dob = newDob;
	}
	public Calendar getDob(){
		return dob;
	}
	
	
	public void setEyeColor(String newEyeColor){
		eyeColor = newEyeColor;
	}
	public String getEyeColor(){
		return eyeColor;
	}
	
	
	public void setImprisonmentDate(Calendar newImprisonmentDate){
		imprisonmentDate = newImprisonmentDate;
	}
	public Calendar getImprisonmentDate(){
		return imprisonmentDate;
	}
	
	
	public void setReleaseDate(Calendar newReleaseDate){
		releaseDate = newReleaseDate;
	}
	public Calendar getReleaseDate(){
		return releaseDate;
	}
	
	public void setTattooDescription(String newTattooDescription){
		tattooDescription = newTattooDescription;
	}
	public String getTattooDescription(){
		return tattooDescription;
	}
	
	public void printInformation() {
		Date dateDob = dob.getTime();
		Date dateImprison = imprisonmentDate.getTime();
		Date dateRelease = releaseDate.getTime();
		System.out.println("FirstName: " + firstName + "\n" +
				"Patronymic: " + patronymic + "\n" +
				"Last name: " + lastName + "\n" +
				"Day of birth: " + dateDob + "\n" +
				"Color of eyes: " + eyeColor + "\n" +
				"Date of imprisonment: " + dateImprison + "\n" +
				"Date of release: " + dateRelease + "\n" +
				"Tattoo description: " + tattooDescription + "\n");
	}
	
	public void scanInformation() {
		
		int day;
		int month;
		int year;
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.print("FirstName: ");
		firstName = in.nextLine();
		
		System.out.print("Patronymic: ");
		patronymic = in.nextLine();
		
		System.out.print("Last name: ");
		lastName = in.nextLine();
		
		System.out.print("Day of birth: ");
		day = in.nextInt();
		System.out.print("Month of birth: ");
		month = in.nextInt();
		System.out.print("Year of birth: ");
		year = in.nextInt();
		dob = new GregorianCalendar(year, month, day);
		
		System.out.print("Color of eyes: ");
		eyeColor = in.next();
		
		System.out.print("Date of imprisonment: ");
		day = in.nextInt();
		System.out.print("Month of imprisonment: ");
		month = in.nextInt();
		System.out.print("Year of imprisonment: ");
		year = in.nextInt();
		imprisonmentDate = new GregorianCalendar(year, month, day);
		
		System.out.print("Date of release: ");
		day = in.nextInt();
		System.out.print("Month of release: ");
		month = in.nextInt();
		System.out.print("Year of release: ");
		year = in.nextInt();
		releaseDate = new GregorianCalendar(year, month, day);
		
		
		System.out.print("Tattoo description: ");
		tattooDescription = in.next();
	}
	
	public String toString() {

        StringBuilder test = new StringBuilder("FirstName: " + this.firstName + 
        		"\nPatronymic: " + this.patronymic + 
        		"\nLast name: " + this.lastName +
                "\nDate of birth: " + this.dob.DAY_OF_MONTH + "." + this.dob.MONTH + "." + this.dob.YEAR +
                "\nColor of eyes: " + this.eyeColor +
                "\nDate of imprisonment: " + this.imprisonmentDate.DAY_OF_MONTH + "." + this.imprisonmentDate.MONTH + "." + this.imprisonmentDate.YEAR +
                "\nDate of release: " + this.releaseDate.DAY_OF_MONTH + "." + this.releaseDate.MONTH + "." + this.releaseDate.YEAR +
                "\nTattoo description: " + this.tattooDescription + "\n");

        
        return test.toString();
    }
	
	@Override
    public int compareTo(Prisoner object) {
        return Integer.compare(this.imprisonmentDate.YEAR,object.imprisonmentDate.YEAR);
    }
}
