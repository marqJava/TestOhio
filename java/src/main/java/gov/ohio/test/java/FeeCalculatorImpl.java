package gov.ohio.test.java;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FeeCalculatorImpl implements FeeCalculator {
	
	private List<Fee> feeList = new ArrayList<Fee>();
	
	public FeeCalculatorImpl() {
	}

	/* (non-Javadoc)
	 * @see gov.ohio.test.java.FeeCalculator#addFee(gov.ohio.test.java.Fee)
	 */
	public void addFee(Fee fee){
		this.feeList.add(fee);
	}
	
	public void emptyFees() {
		this.feeList.clear();
	}	
	
	/* (non-Javadoc)
	 * @see gov.ohio.test.java.FeeCalculator#TotalFee()
	 */
	public BigDecimal totalFee(BigDecimal totalInvoice){
		BigDecimal res = BigDecimal.ZERO;
		
		if(totalInvoice.doubleValue() > 0){
			for (Fee objIter: this.feeList) {
				objIter.setAmount(totalInvoice);
				res = res.add(objIter.calculate());
			}			
		}
		
		return res;
	}

}
