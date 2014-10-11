package is.ru.stringcalculator;

public class Calculator {
	
	public static int add(String value){
		if(value.equals("")){return 0;}
		else if(value.contains(",") || value.contains("\n")){
			return splitnsum(value);
		}
		else {return Integer.parseInt(value.trim());}
	}

	private static int splitnsum(String value){
		String[] snumbers;
		String tmp = value.replace("\n",",");
		snumbers = tmp.split(",");
		int sum = 0;
		for(int i = 0; i < snumbers.length; i++){		
			sum += Integer.parseInt(snumbers[i].trim());
		}
		return sum;	
	}
	
}