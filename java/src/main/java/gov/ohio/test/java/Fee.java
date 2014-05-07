/**
 * 
 */
package gov.ohio.test.java;

import java.math.BigDecimal;

/**
 * @author Miguel Angel Ramirez Quezada
 * 
 */
public abstract class Fee {

	protected BigDecimal lowLimit = BigDecimal.ZERO;
	protected BigDecimal topLimit = BigDecimal.ZERO;
	protected double feePercentage;
	protected BigDecimal amount = BigDecimal.ZERO;;

	/**
	 * 
	 */
	public Fee() {
	}

	public Fee(BigDecimal lowLimit, BigDecimal topLimit, double feePercentage,
			BigDecimal amount) {
		super();
		this.lowLimit = lowLimit;
		this.topLimit = topLimit;
		this.feePercentage = feePercentage;
		this.amount = amount;
	}

	public abstract BigDecimal calculate();
	/**
	 * @return the lowLimit
	 */
	public BigDecimal getLowLimit() {
		return lowLimit;
	}

	/**
	 * @param lowLimit
	 *            the lowLimit to set
	 */
	public void setLowLimit(BigDecimal lowLimit) {
		if (lowLimit.compareTo(BigDecimal.ZERO) == 1) {
			this.lowLimit = lowLimit;
		}
	}

	/**
	 * @return the topLimit
	 */
	public BigDecimal getTopLimit() {
		return topLimit;
	}

	/**
	 * @param topLimit
	 *            the topLimit to set
	 */
	public void setTopLimit(BigDecimal topLimit) {
		if (lowLimit.compareTo(BigDecimal.ZERO) == 1) {
			this.topLimit = topLimit;
		}
	}

	/**
	 * @return the feePercentage
	 */
	public double getFeePercentage() {
		return feePercentage;
	}

	/**
	 * @param feePercentage
	 *            the feePercentage to set
	 */
	public void setFeePercentage(double feePercentage) {
		if (feePercentage > 0) {
			this.feePercentage = feePercentage;
		}
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
