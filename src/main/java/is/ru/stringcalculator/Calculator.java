package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else{
			int calc = 0;

        	String[] numb = splitNumbers(text);
        	if(numb.length > 2){
        		return 0;
        	}
        	for(int i = 0; i < numb.length; i++){
    			int value = 0;
    			value = toInt(numb[i]);
    			calc = calc + value;
        		
       		 }
			return calc;
		}
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