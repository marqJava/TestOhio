/**
 * 
 */
package gov.ohio.test.java;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mike
 *
 */
public class TestFeeUseCase2 {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFeeBelow100_fail() {
		Fee target = new FeeUnder100kC1();		
		target.setAmount(new BigDecimal(0));
		
		BigDecimal amountFee = target.calculate();
		System.out.println("1.-The amount below of 100K is : " + NumberFormat.getCurrencyInstance().format(target.getAmount()));
		System.out.println("1.-The fee amount below of 100K is : " + NumberFormat.getCurrencyInstance().format(amountFee));
		
		assertTrue("amount not valid", amountFee.intValue() == 0);
	}
	
	@Test
	public void testFeeBelow100_success() {
		Fee target = new FeeUnder100kC1();		
		target.setAmount(new BigDecimal(50000));
		
		BigDecimal amountFee = target.calculate();
		
		System.out.println("2.-The amount below of 100K is : " + NumberFormat.getCurrencyInstance().format(target.getAmount()));
		System.out.println("2.-The fee amount below of 100K is : " + NumberFormat.getCurrencyInstance().format(amountFee));
		assertTrue("amount not valid", amountFee.intValue() > 0);
	}	

	@Test
	public void testFeeBetween100k500k_fail() {
		Fee target = new FeeBetween100k500kC2();		
		target.setAmount(new BigDecimal(0));
		
		BigDecimal amountFee = target.calculate();

		System.out.println("3.-The amount betwwen 100K and 500k is : " + NumberFormat.getCurrencyInstance().format(target.getAmount()));
		System.out.println("3.-The amount betwwen 100K and 500k is : " + NumberFormat.getCurrencyInstance().format(amountFee));		
		
		assertTrue("amount not valid", amountFee.intValue() == 0);
	}
	
	@Test
	public void testFeeBetween100k500k_success() {		
		Fee target = new FeeBetween100k500kC2();		
		target.setAmount(new BigDecimal(600000));		
		BigDecimal amountFee = target.calculate();
		System.out.println("4_1-The amount above of 600K is : " + NumberFormat.getCurrencyInstance().format(amountFee));
		
		target = new FeeUnder100kC1();
		target.setAmount(new BigDecimal(600000));
		amountFee = amountFee.add(target.calculate());
		System.out.println("4_2-The amount above of 600K is : " + NumberFormat.getCurrencyInstance().format(amountFee));
		
		
		target = new FeeAbove500kC2();
		target.setAmount(new BigDecimal(600000));
		amountFee = amountFee.add(target.calculate());
		System.out.println("4_3-The amount above of 600K is : " + NumberFormat.getCurrencyInstance().format(amountFee));
		
				
		System.out.println("4.-The amount above of 600K is : " + NumberFormat.getCurrencyInstance().format(target.getAmount()));
		System.out.println("4.-The fee amount above of 600K is : " + NumberFormat.getCurrencyInstance().format(amountFee));
		assertTrue("amount not valid", amountFee.intValue() > 0);
	}	
	
}
