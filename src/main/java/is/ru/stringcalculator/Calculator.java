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
			char tmpdel = tmp.charAt(2);
			tmp.replace(tmpdel , ",");
			tmp.replace("/","");	
		}
		tmp = tmp.replace("\n",",");
		snumbers = tmp.split(",");
		int sum = 0;
		for(int i = 0; i < snumbers.length; i++){		
			sum += Integer.parseInt(snumbers[i].trim());
		}
		return sum;	
	}
	
}