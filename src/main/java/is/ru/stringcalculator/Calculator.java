package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text == ""){
			return 0;
		}
        String[] numb = splitNumbers(text);
        int sums = sum(numb);
        return sums;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    } 
}