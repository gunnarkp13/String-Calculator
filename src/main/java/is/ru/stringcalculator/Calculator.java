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
			tmp = tmp.replaceAll("$,","")	
		}
		tmp = tmp.replace("\n",",").trim();
		snumbers = tmp.split(",");
		int sum = 0;
		for(int i = 0; i < snumbers.length; i++){		
			sum += Integer.parseInt(snumbers[i].trim());
		}
		return sum;	
	}
	
}