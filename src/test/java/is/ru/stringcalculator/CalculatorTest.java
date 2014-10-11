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

	//Prófa leggja saman 2 tölur skiptar með kommu
	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
	}

	//Prófa fleiri en 2 tölur, gerum fyrir 3,4 og 7 tölur
	@Test
	public void testManyNumbers(){
		assertEquals(6, Calculator.add("1,2,3"));
		assertEquals(10, Calculator.add("1,2,3,4"));
		assertEquals(28, Calculator.add("1,2,3,4,5,6,7"));

	}
}