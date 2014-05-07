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
public class TestFeeUseCase1 {

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
	public void testFeeAbove100_fail() {
		Fee target = new FeeUAbove100kC1();		
		target.setAmount(new BigDecimal(0));
		
		BigDecimal amountFee = target.calculate();

		System.out.println("3.-The amount below of 100K is : " + NumberFormat.getCurrencyInstance().format(target.getAmount()));
		System.out.println("3.-The fee amount below of 100K is : " + NumberFormat.getCurrencyInstance().format(amountFee));		
		
		assertTrue("amount not valid", amountFee.intValue() == 0);
	}
	
	@Test
	public void testFeeAbove100_success() {		
		Fee target = new FeeUAbove100kC1();		
		target.setAmount(new BigDecimal(200000));		
		BigDecimal amountFee = target.calculate();
		
		target = new FeeUnder100kC1();		
		target.setAmount(new BigDecimal(200000));
		
		amountFee = amountFee.add(target.calculate());
				
		System.out.println("4.-The amount below of 100K is : " + NumberFormat.getCurrencyInstance().format(target.getAmount()));
		System.out.println("4.-The fee amount below of 100K is : " + NumberFormat.getCurrencyInstance().format(amountFee));
		assertTrue("amount not valid", amountFee.intValue() > 0);
	}	
	
}
