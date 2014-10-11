package is.ru.stringcalculator;

public class Calculator {
	
	public static int add(String value){
		if(value.equals("")){return 0;}
		else if(value.contains(",")){
			return splitnsum(value);
		}
		else {return Integer.parseInt(value.trim());}
	}

	private static int splitnsum(String value){
		String[] snumbers;
		snumbers = value.split(",");
		int sum = 0;
		for(int i = 0; i < snumbers.lenght; i++){		
			sum += Integer.parseInt(snumbers[i].trim());
		}
		return sum;	
	}
	
}