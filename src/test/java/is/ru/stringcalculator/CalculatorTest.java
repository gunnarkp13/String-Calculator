package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	public static void main(String args[]){
	org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}
	
	// Prófa tómastrenginn viljum fá 0 útúr fallinu.
	@Test
	public void testEmptyString(){
		assertEquals(0,Calculator.add(""));
	}

	// Prófa eina tölu viljum fá 1 út.
	@Test
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}
}