package is.ru.stringcalculator;

public class Calculator {

	public static int add(String value){
		if(value.equals("")){ return 0; }
		else{ return splitnsum(value); }
	}

	private static int splitnsum(String value){
		String[] snumbers;
		String tmp = value;
		if(tmp.contains("//")){
			String tmpdel = Character.toString(tmp.charAt(2));
			tmp = tmp.replace(tmpdel , ",").trim();
			tmp = tmp.replace("/",",").trim();
			tmp = tmp.replace(","," ").trim();
			tmp = tmp.replace(" ",",").trim();
		}
		tmp = tmp.replace("\n",",").trim();
		snumbers = tmp.split(",");
		int sum = 0;
		int[] numbers = new int[snumbers.length];
		for(int i = 0; i < snumbers.length; i++){
			numbers[i] = Integer.parseInt(snumbers[i].trim());
			sum += numbers[i];
		}
		String negnums = "";
		for(int i = 0; i < numbers.length; i++){
			if(numbers[i] < 0){negnums = negnums + Integer.toString(numbers[i]) + " ";}
		}
		if(negnums.length() != 0){
			negnums = negnums.trim();
			negnums = negnums.replace(" ", ",");
			negnums = "Negatives not allowed: " + negnums;
			throw new IllegalArgumentException(negnums);
		}
		else{
			return sum;
		}
	}
	
}
