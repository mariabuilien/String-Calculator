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
		if(numbers.startsWith("//")){
			numbers = numbers.substring(2);
			if(numbers.startsWith("[")){
				while(numbers.startsWith("[")){
					String del2 = findDel(numbers);
					del = del + "|" + del2;
					int n = numbers.indexOf("]");
					numbers = numbers.substring(n + 1);
				}
				numbers = numbers.substring(1);
				return numbers.split(del);

			}
			else{
				String del2 = findDel(numbers);
				del = del + "|" + del2;
				numbers = numbers.substring(2);

				return numbers.split(del);
			}
		}
		return numbers.split(del);
	}
	
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

    private static String findDel(String numbers){
    	if(numbers.startsWith("[")){
    		int n = numbers.indexOf("]");
    		String del = numbers.substring(1,n);
    		return del;
    	}
    	else{
    		char dels = numbers.charAt(0);
    		String del = Character.toString(dels);
    		
    		return del;
    	}
    } 

}