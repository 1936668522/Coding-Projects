package assg5_lic20;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestComplexNum {

	private ComplexNum complexNum, complexNum1, complexNum2; 

	@Before
	public void setUp()
	{
		complexNum = new ComplexNum(); //set real number as 0 and imaginary number as 0.
		complexNum1 = new ComplexNum (3.6); // set real number as 3.6 and imaginary number as 0.
		complexNum2 = new ComplexNum(6.7, 2.6); // set real number as 6.7 and imaginary number as 2.6
	}
	
	@Test
	public void testDefaultConstructorCase1()
	{
		//This test case should not show any problem.
		assertEquals("complexNum real number", 0, complexNum.getReal(), 0.00001);
		assertEquals("complexNum imaginary number", 0, complexNum.getImaginary(),0.00001);
	}
	
	@Test
	public void testDefaultConstructorCase2()
	{
		//I set the expect real number as 3.2 which is wrong, so it will show failure.
		assertEquals("complexNum real number", 3.2, complexNum.getReal(), 0.00001);
		assertEquals("complexNum imaginary number", 0, complexNum.getImaginary(),0.00001);
	}
	
	@Test
	public void testDefaultConstructorCase3()
	{
		//I set the expect imaginary number as 7, which is wrong and it will show failure.
		assertEquals("complexNum real number", 0, complexNum.getReal(), 0.00001);
		assertEquals("complexNum imaginary number", 7, complexNum.getImaginary(),0.00001);
	}
	
	
	
	@Test
	public void testSecondConstructorCase1()
	{
		//This test case should not show any problem
		assertEquals("ComplexNum1 real number", 3.6, complexNum1.getReal(),0.000001);
		assertEquals("ComplexNum1 imaginary number", 0, complexNum1.getImaginary(),0.00001);
	}
	
	@Test
	public void testSecondConstructorCase2()
	{	
		//I set expected real number as 0, which is wrong and it should show failure.
		assertEquals("ComplexNum1 real number", 0, complexNum1.getReal(),0.000001);
		assertEquals("ComplexNum1 imaginary number", 0, complexNum1.getImaginary(),0.00001);
	}
	
	@Test
	public void testSecondConstructorCase3()
	{
		//I set expected imaginary number as 3.6, which is wrong and it should show failure.
		assertEquals("ComplexNum1 real number", 3.6, complexNum1.getReal(),0.000001);
		assertEquals("ComplexNum1 imaginary number", 3.6, complexNum1.getImaginary(),0.00001);
	}
	
	
	
	@Test
	public void testThridConstructorCase1()
	{
		//This test Case should not show any failure.
		assertEquals("ComplexNum2 real number", 6.7, complexNum2.getReal(), 0.0000000001);
		assertEquals("ComplexNum2 imaginary numebr",2.6, complexNum2.getImaginary(), 0.000000001);
	}
	@Test
	public void testThridConstructorCase2()
	{
		//I set expected real number as 8.0, which is wrong and it should show failure.
		assertEquals("ComplexNum2 real number", 8.0, complexNum2.getReal(), 0.0000000001);
		assertEquals("ComplexNum2 imaginary numebr",2.6, complexNum2.getImaginary(), 0.000000001);
	}
	@Test
	public void testThridConstructorCase3()
	{
		//I set expected imaginary number as 2.5, which is wrong and it should show failure.
		assertEquals("ComplexNum2 real number", 6.7, complexNum2.getReal(), 0.0000000001);
		assertEquals("ComplexNum2 imaginary numebr",2.5, complexNum2.getImaginary(), 0.000000001);	
	}
	
	
	
	
	@Test
	public void testGetRealMethodCase1()
	{
		//Testing getReal method.
		//This should not show any failure.
		assertEquals("The real number of complexNnum1", 3.6, complexNum1.getReal(),0.0001);
	}
	@Test
	public void testGetRealMethodCase2()
	{
		//I set expect real num as 1 which is wrong and it should show failure.
		ComplexNum num = new ComplexNum(2.5);
		assertEquals("The real number of num", 1, num.getReal(), 0.000000001);
	}
	
	
	
	
	@Test
	public void testGetImaginaryMethodCase1()
	{		
		//testing get imaginary method
		//this test should not show any failure.
		ComplexNum num = new ComplexNum(2.5, 9.2);
		assertEquals("The imaginary number", 9.2, num.getImaginary(),0.0001);
	}
	@Test
	public void testGetImaginaryMethodCase2()
	{
		//I set expect imaginary number as 2.3 which is wrong and it should show failure.
		assertEquals("The imaginary number of complexNum", 2.3, complexNum.getImaginary(),0.001);
	}
	
	
	@Test
	public void testSetRealMethodCase1()
	{
		//test setReal method
		//this test case should not show any failure.
		complexNum1.setReal(7.8);
		assertEquals("The new real number is", 7.8, complexNum1.getReal(),0.000001);
	}
	@Test
	public void testSetRealMethodCase2()
	{	//test setReal method for different number
		//this test case should not show any failure.
		complexNum2.setReal(0);
		assertEquals("The new real number is", 0, complexNum2.getReal(),0.000001);
	}
	
	
	@Test
	public void testSetImaginaryMethodCase1()
	{
		//test setImaginary method
		//this test case should not show any failure
		complexNum.setImaginary(3.5);
		assertEquals("The new imaginary numer", 3.5, complexNum.getImaginary(),0.001);
	}
	@Test
	public void testSetImaginaryMethodCase2()
	{
		//test setImaginary method with different number.
		//this test case should not show any failure.
		complexNum1.setImaginary(0.6);
		assertEquals("The new imaginary numer", 0.6, complexNum1.getImaginary(),0.001);
	}
	
	
	@Test
	public void testAddMethodCase1()
	{
		//test add method
		//this test case should not show any failure.
		ComplexNum num;
		num = complexNum1.add(complexNum2);
		assertEquals("value of num", "10.3+2.6i", num.toString() );
	}
	@Test
	public void testAddMethodCase2()
	{
		//test add method with wrong expect result which is wrong 
		//this test case should show failure.
		ComplexNum num;
		num = complexNum1.add(complexNum2);
		assertEquals("value of num", "6.3+2.1i", num.toString() );
	}
	
	
	@Test
	public void testSubMethodCase1()
	{
		//test sub method 
		//this test case should not show any failure
		complexNum = complexNum1.sub(complexNum2);
		assertEquals("value of complexNum",  "-3.1-2.6i",complexNum.toString());
	}
	@Test
	public void testSubMethodCase2()
	{
		//test sub method with wrong expect result which is wrong
		//this test case should show failure.
		complexNum = complexNum1.sub(complexNum2);
		assertEquals("value of complexNum","-2.6+22.4i" ,complexNum.toString());
	}
	
	
	@Test
	public void testMulMethodCase1()
	{
		//test mul method
		//this test case should not show any failure
		ComplexNum num = complexNum2.mul(complexNum2);
		assertEquals("value of num", "38.13+34.84i",num.toString());
	}
	@Test
	public void testMulMethodCase2()
	{
		//test mul method with wrong expect result which is wrong
		//this test case should show failure.
		ComplexNum num = complexNum2.mul(complexNum2);
		assertEquals("value of num","-4.84+2.45",num.toString());
	}
	
	
	@Test
	public void testNegMethodCase1()
	{
		//test Neg method
		//this test case should not show any failure.
		complexNum2.neg();
		assertEquals("value of complexNum2", "6.7+2.6i",complexNum2.toString());
	}
	@Test
	public void testNegMethodCase2()
	{
		//test Neg method with wrong result which is wrong
		//this test case should show failure.
		complexNum2.neg();
		assertEquals("value of complexNum2", "-2.6-2.5",complexNum2.toString());
	}
	
	
	@Test
	public void testToStringMethodCase1()
	{
		//to test toString method
		//this test case should not show any failure
		assertEquals("toSrting of complexNum2", complexNum2.getReal() + "+" + complexNum2.getImaginary()+"i", complexNum2.toString());
	}
	@Test
	public void testToStringMethodCase2()
	{
		//to test toString with wrong result
		//this test case should show failure.
		String result =  complexNum1.getReal() + "+" + complexNum1.getImaginary()+"i";
		assertEquals("toSrting of complexNum3",result, complexNum1.toString());
	}
	
	
	
	@Test
	public void testEqualsMethodCase1()
	{
		//to test equal method
		//this test case should not show any failure
		complexNum.equals(complexNum1);
		assertEquals("result",false, complexNum.equals(complexNum1));
	}
	@Test
	public void testEqualsMethodCase2()
	{
		//to test equals method with wrong result
		//this test case should show failure.
		complexNum.equals(complexNum1);
		assertEquals("result",true, complexNum.equals(complexNum1));
	}
	
}
