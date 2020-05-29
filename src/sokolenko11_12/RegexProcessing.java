package ua.khpi.oop.sokolenko11_12;

public class RegexProcessing {
	
	 public static boolean checkName(String input) {
	        return input.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$");
	 }
	 
	 public static boolean checkNum(String input) {
	        return input.matches("[0-9]+");
	 }
	 
}
