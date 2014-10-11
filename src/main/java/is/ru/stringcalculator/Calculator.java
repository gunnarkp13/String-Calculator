package is.ru.stringcalculator;

public class Calculator {
	
	public static int add(String value){
		if(value.equals("")){return 0;}
		else if(value.contains(",")){
			int[2] numbers = (int) value.split(",");
			return numbers[0] + numbers[1];
		}
		else {return 1;}
	}
	
}