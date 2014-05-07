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
 * @author Miguel Angel Ramirez Quezada
 *
 */
public class TestFeeUseCase3 {

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
	public void testArbitaryFeeRanges() {
		FeeCalculator target = new FeeCalculatorImpl();
		BigDecimal amountFee = BigDecimal.ZERO;
		
		Fee feeBetween = new FeeBetween100k500kC2(new BigDecimal(100000), new BigDecimal(500000), 0.10);		
		Fee feeAbove = new FeeAbove500kC2(new BigDecimal(500000), new BigDecimal(999999999), 0.05);		
		Fee feeUnder = new FeeUnder100kC1(new BigDecimal(1), new BigDecimal(100000), 0.20);
		
		target.addFee(feeBetween);
		target.addFee(feeAbove);
		target.addFee(feeUnder);
		amountFee = target.totalFee(new BigDecimal(600000));
		
		System.out.println("4.-The fee amount above of 600K is : " + NumberFormat.getCurrencyInstance().format(amountFee));
		
		assertTrue("amount not valid", amountFee.intValue() > 0);
	}	
	
}
