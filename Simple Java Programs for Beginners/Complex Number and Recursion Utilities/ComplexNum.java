package assg5_lic20;

public class ComplexNum {
	private double realNum; // real number 
	private double imagNum; // imaginary number
	
	/**
	 * default constructor that initialize both real and imaginary number
	 * to zero.
	 */
	public ComplexNum() // use getNum to test the constructor
	{	realNum = 0;
		imagNum = 0;
	}
	
	/**
	 * another constructor that initialize the real number and initialize
	 * imaginary to zero 
	 * @param realNum
	 */
	public ComplexNum(double realNum) {
		this.realNum = realNum;
	}
	
	/**
	 * @param realNum to initialized the real number
	 * @param imagNum to initialized the imaginary number.
	 */
	public ComplexNum(double realNum, double imagNum) {
		this.realNum = realNum;
		this.imagNum = imagNum;
	}
	
	/**
	 * This method is to retrieve the real number
	 * @return the new number.
	 */
	public double getReal() {
		return realNum;
	}
	
	
	/**
	 * This method is to retrieve the imaginary number
	 * @return the imaginary number.
	 */
	public double getImaginary()
	{
		return imagNum;
	}
	
	
	/**
	 * This method is to modify the real number. 
	 * @param to set a new realNum.
	 */
	public void setReal(double realNum)
	{
		this.realNum = realNum;
	}
	
	/**
	 * This method is to modify the imaginary Number.
	 * @param to get a new imagNum.
	 */
	public void setImaginary(double imagNum)
	{
		this.imagNum = imagNum;
	}
	
	
	/**
	 * This method is to add two complex numbers in order to get a new Complex Number.
	 * @param ComplexNum num is the parameter of the complex number that is going to be added.
	 * @return a new Complex Number with new real number and new imaginary number.
	 */
	public ComplexNum add(ComplexNum num)
	{
		double realNum = this.realNum + num.realNum;		
		double imagNum = this.imagNum + num.imagNum;
		realNum = (double)Math.round(realNum*100)/100;// to round 2 decimal number. 
		imagNum = (double)Math.round(imagNum*100)/100;
		
		return new ComplexNum(realNum, imagNum);
	}
	
	
	/**
	 * This method is to subtract two complex numbers in order to get a new Complex Number.
	 * @param ComplexNum num is the parameter of the complex number that is going to be subtracted. 
	 * @return the new Complex Number with new real number and new imaginary number.
	 */
	public ComplexNum sub(ComplexNum num)
	{
		double realNum = this.realNum - num.realNum;
		double imagNum = this.imagNum - num.imagNum;
		
		realNum = (double)Math.round(realNum*100)/100; // to round 2 decimal number. 
		imagNum = (double)Math.round(imagNum*100)/100;
		
		return new ComplexNum(realNum, imagNum);
	}
	
	/**
	 * This method is to multiply two complex numbers in order to get a new Complex Number.
	 * @param ComplexNum num is the parameter of the complex number that is going to be multiplied. 
	 * @return the new Complex Number with new real number and new imaginary number.
	 */
	public ComplexNum mul(ComplexNum num)
	{
		double realNum = ((this.realNum * num.realNum) - (this.imagNum * num.imagNum));
		double imagNum = ((this.realNum * num.imagNum) + (this.imagNum * num.realNum));
		
		realNum = (double)Math.round(realNum*100)/100; // to round 2 decimal number. 
		imagNum = (double)Math.round(imagNum*100)/100;
		
		return new ComplexNum(realNum,imagNum);
	}
	
	
	/**
	 * This method is to negate the Complex number.
	 * @return the new Complex Number after negation.
	 */
	public ComplexNum neg()
	{
		double realNum = - this.realNum;
		double imagNum =  - this.imagNum;
		
		 return new ComplexNum(realNum, imagNum);
	}
	
	/**
	 * @Override This is override method inherited from the Object class.
	 * this method is to print out the different types of real and imaginary numbers.
	 */
	public String toString()
	{
		if(realNum != 0 && imagNum > 0)
		{
			return realNum + "+" + imagNum + "i";//if imaginary is bigger than 0, then add "+"
		}
		else if(realNum !=0 && imagNum < 0 )
		{
			return realNum + "" + imagNum + "i";//if imaginary is less than 0, then I don't need to add anything because it will automatically have "-" sign in front of it.
		}
		else if(realNum!= 0 && imagNum ==0)//if imaginary is 0, then just print out the real number.
		{
			return realNum + "";
		}
		else if (realNum == 0 && imagNum == 0 )// if both numbers are 0 then print 0;
		{
			return "0";
		}
		else //if the real number is equal to 0 while imaginary number is not, then print out the imaginary number.
		{
			return imagNum + "i" ; 
		}
	}
	
	
	/**
	 * Override method to compare two Complex Numbers.
	 * This is equals method to check if two Complex Numbers has same real number and imaginary number
	 */
	public boolean equals(Object obj)
	{
		if(obj == null) // means that the Object that is passed as a parameter is not a ComplexNum object.
		{
			return false;
		}
		if(obj instanceof ComplexNum)// if the Object is ComplexNum object.
		{
			ComplexNum comNum = (ComplexNum)obj; // made a new variable for object that passed as a parameter in order to compare.
			if(this.realNum == comNum.realNum && this.imagNum == comNum.imagNum)//to compare if they have same real number and imaginary number
			{ 
				return true;
			}
			else 
			{
				return false;
			}
		}
		else 
		{
			return false;
		}
		
	}
}
