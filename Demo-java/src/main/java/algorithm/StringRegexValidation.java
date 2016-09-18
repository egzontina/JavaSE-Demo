package algorithm;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegexValidation {
	
	
    public static void main(String args[]) {
        
        
        // split binnary between every group of same characters
        String str = "aaabbbcczzzz";
        String regex = "(?<=(.))(?!\\1)";
        String[] arr = str.split(regex);
        System.out.println(str + " => " + Arrays.toString(arr));
    }
    
    /**
     * Regular expression in Java to check if String is number or not
     */
    public void isStringNumber() { 	
        Pattern pattern = Pattern.compile(".*[^0-9].*");
       //Pattern pattern = Pattern.compile(".*\\D.*");
        // Pattern pattern = Pattern.compile("^[0-9]+$");
        
        
       String [] inputs = {"123", "-123" , "123.12", "abcd123"};

       for(String input: inputs){
           System.out.println( "does " + input + " is number : " + !pattern.matcher(input).matches());
       }

       /* Output:
		does 123 is number : true
		does -123 is number : false
		does 123.12 is number : false
		does abcd123 is number : false	
        */
    }
    
    /**
     * check if string contain only letter
     */
    public boolean isString(String str) { 
    	
        String expression = "^[a-zA-Z]*$";
        Pattern pattern = Pattern.compile(expression);
        // return Pattern.matches(expression, str);
        
        // or 
        
        //Java 8
        boolean allLetters = str.chars().allMatch(x -> Character.isLetter(x));
        // str.chars().allMatch(Character::isLetter);
        
        // or
        return str.matches("[a-zA-Z]+");
    }
    
	/**
	 * to check if String contains any number or not Instead of using matches()
	 * method of java.lang.String, we have used Pattern and Matcher class to
	 * avoid creating temporary Pattern objects.
	 */
    public Boolean isStringContainNumber(String str) { 
    	
    	// Regular expression pattern to test input
    	String regex = "(.)*(\\d)(.)*";      
        Pattern pattern = Pattern.compile(regex);
        
        // Don't create pattern in loop, creating Pattern is expensive
        Matcher matcher = pattern.matcher(str);
        
        return matcher.matches();    	
    }
    
    /**
     * Regular expression in java to check if String is 6 digit number or not
     */
    public void isStringSixDigitNumber() {
    	
        String [] numbers = {"123", "1234" , "123.12", "abcd123", "123456"};
        Pattern digitPattern = Pattern.compile("\\d{6}");       
        //Pattern digitPattern = Pattern.compile("\\d\\d\\d\\d\\d\\d");
        
        for(String number: numbers){
            System.out.println( "does " + number + " is 6 digit number : "
                                + digitPattern.matcher(number).matches());
        }
        
    	/* Output:
    	does 123 is 6 digit number : false
		does 1234 is 6 digit number : false
		does 123.12 is 6 digit number : false
		does abcd123 is 6 digit number : false
		does 123456 is 6 digit number : true    	
    	 */
    }
    
}
