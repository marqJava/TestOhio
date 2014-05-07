package gov.ohio.test.java;

import java.math.BigDecimal;

public interface FeeCalculator {

	public abstract void addFee(Fee fee);
	public abstract void emptyFees();
	public abstract BigDecimal totalFee(BigDecimal totalInvoice);

}