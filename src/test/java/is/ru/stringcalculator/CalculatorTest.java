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
    public void testNewDel2(){
        assertEquals(3, Calculator.add("//*\n1*2"));
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
    		Calculator.add("-1,2");
    	}
    	catch(RuntimeException ex){
    		assertEquals("Negatives not allowed: -1", ex.getMessage());

    	}
    }

    @Test
    public void testMulitpleNegativesNotAllowed(){
    	try{
    		Calculator.add("2,-4,3,-5");
    	}
    	catch(RuntimeException ex){
    		assertEquals("Negatives not allowed: -4,-5", ex.getMessage());

    	}
    }

   @Test
    public void testIgnoreLargerThanThousand(){
    	assertEquals(3, Calculator.add("//[;;][%]\n1;;2%1001"));
    }

     @Test
    public void testIgnoreLargerThanThousand2(){
    	assertEquals(2, Calculator.add("1001,2"));
    }

     @Test
    public void testIgnoreLargerThanThousand3(){
    	assertEquals(0, Calculator.add("1020,1032"));
    }

     @Test
    public void testLongDelimeters(){
    	assertEquals(6, Calculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void testMultipleDelimeters(){
    	assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testMultipleLongDelimeters(){
    	assertEquals(6, Calculator.add("//[***][%%]\n1***2%%3"));
    }

    @Test
    public void testAdditionally(){
    	assertEquals(6, Calculator.add("//;\n1;2,3"));
    }

}