package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testThreeNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testMultipleNumbers(){
    	assertEquals(10, Calculator.add("1,2,3,4"));
    }

    @Test
    public void testNewLine(){
    	assertEquals(3, Calculator.add("1\n2"));
    }

    @Test
    public void testNewLineWithComma(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testNewLineLarger(){
    	assertEquals(13, Calculator.add("1\n2,3\n3,4"));
    }

        @Test
    public void testNewDel(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void testNewDelMult(){
    	assertEquals(3, Calculator.add("//[;;]\n1;;2"));
    }

     @Test
    public void testNewDelMultMore(){
    	assertEquals(6, Calculator.add("//[;;][%]\n1;;2%3"));
    }

     @Test
    public void testNegativesNotAllowed(){
    	try{
    		Calculator.add("-1,2,3");
    	}
    	catch(RuntimeException ex){
    		assertEquals("Negatives not allowed: -1", ex.getMessage());

    	}
    }

    @Test
    public void testMulitpleNegativesNotAllowed(){
    	try{
    		Calculator.add("-1,-2,3");
    	}
    	catch(RuntimeException ex){
    		assertEquals("Negatives not allowed: -1,-2", ex.getMessage());

    	}
    }

}