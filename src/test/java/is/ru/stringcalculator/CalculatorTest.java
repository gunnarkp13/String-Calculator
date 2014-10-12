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

	//Prófa \n í stað ,
	@Test
	public void testNewlineDelimiter(){
		assertEquals(6, Calculator.add("1\n2,3"));
		assertEquals(10, Calculator.add("1,2\n3\n4"));
		assertEquals(28, Calculator.add("1\n2,3,4\n5,6,7"));

	}

	//Prófa ; í stað ,
	@Test
	public void testDiffDelimiter(){
		assertEquals(6, Calculator.add("//;\n1\n2;3"));
		assertEquals(10, Calculator.add("//;\n1;2\n3\n4"));
		assertEquals(28, Calculator.add("//;\n1\n2;3;4\n5;6;7"));

	}

	//Prófa exception á mínustölur;
	@Test
	public void testNegativeNumbersException(){
		try{ 
			Calculator.add("-1,2");
		}
		catch(IllegalArgumentException e){
		assertEquals("Negatives not allowed: -1", e.getMessage());
		}

		try{
			Calculator.add("2,-4,3,-5");
		}
		catch(IllegalArgumentException e){
		assertEquals("Negatives not allowed: -4,-5", e.getMessage());
		}
	}

	//Prófa ignore á tölur stærri en 1000
	@Test
	public void testBiggerThan1k(){
		assertEquals(7, Calculator.add("//;\n3;6000;1500;4"));
		assertEquals(2, Calculator.add("1001,2"));
		assertEquals(2032, Calculator.add("999,1,32,1000,1001"));
	}

	//Prófa nota endalausan delimiter
	@Test
	public void testBracketDelimiter(){
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
		assertEquals(12, Calculator.add("//[%%%%]\n2%%%%5%%%%5"));
		assertEquals(45, Calculator.add("//[#####]\n10#####15#####20"));
	}

	//Prófa fyrir marga delimiters
	@Test
	public void testMultiDelimiters(){
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
		assertEquals(12, Calculator.add("//[&][(][#]\n6&4#1#1"));
		assertEquals(13, Calculator.add("//[=][}][{][$]\n2=4$5{2}"));
	}
	
	//Prófa fyrir marga langa delimiters
	@Test
	public void testMultiLongDelimiters(){
	assertEquals(6, Calculator.add("//[*][%%%]\n1*2%%%3"));
	assertEquals(12, Calculator.add("//[#][##][&&]\n6&&4#1##1"));
	assertEquals(13, Calculator.add("//[==][$$$$][{{{{{][}}}]\n2==4$$$$5{{{{{2}}}"));
	}
}
