package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if(text == ""){
			return 0;
		}
		String[] numb = splitNumbers(text);
        return sum(numb);
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		String del = ",|\n";
		if(numbers.startsWith("//")){
			numbers = numbers.substring(2);
			if(numbers.startsWith("[")){
				while(numbers.startsWith("[")){
					numbers = trimString(numbers);
				}
				numbers = numbers.substring(1);
			}
			else{
				String del2 = findDel(numbers);
				numbers = numbers.substring(2);
				numbers = numbers.replace(del2, ",");
			}
		}
		return numbers.split(del);
	}
	
	private static String trimString(String numbers){
		String del = findDel(numbers);
		numbers = numbers.replace(del, ",");
		int n = numbers.indexOf("]");
		return numbers.substring(n + 1); 
	}

    private static int sum(String[] numbers){
 	    int total = 0;
 	    String negatives = "";
        for(String number : numbers){
        	int numb = toInt(number);
        	if(numb < 0){
        		negatives = negatives + "," + numb;
        	}
        	if(numb < 1001){
        		total += numb;
        	}
		}
        NegativesNotAllowed(negatives);
		return total;
    }

    private static String findDel(String numbers){
    	String del = "";
    	if(numbers.startsWith("[")){
    		int n = numbers.indexOf("]");
    		del = numbers.substring(1,n);
    	}
    	else{
    		char dels = numbers.charAt(0);
    		del = Character.toString(dels); 		
    	}
    	return del;
    } 

    private static void NegativesNotAllowed(String negatives){
    	if(negatives.length() > 0){
    		negatives = negatives.substring(1);
    		throw new RuntimeException("Negatives not allowed: " + negatives);
    	}
    	return;
    }

}