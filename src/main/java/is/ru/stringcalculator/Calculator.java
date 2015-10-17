package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text == ""){
			return 0;
		}
		String[] numb = splitNumbers(text);
        return sum(numb);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		String del = ",|\n";
	    return numbers.split(del);
	}
	
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    } 

}