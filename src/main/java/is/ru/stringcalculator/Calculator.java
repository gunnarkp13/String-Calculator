package is.ru.stringcalculator;

public class Calculator {
	
	public static int add(String value){
		if(value.equals("")){return 0;}
		else if(value.contains(",")){
			return splitnsum(value);
		}
		else {return 1;}
	}

	private static int splitnsum(String value){
		String[] snumbers;
		snumbers = value.split(",");
		return Integer.parseInt(snumbers[0].trim()) +
				 Integer.parseInt(snumbers[1].trim());		
	}
	
}