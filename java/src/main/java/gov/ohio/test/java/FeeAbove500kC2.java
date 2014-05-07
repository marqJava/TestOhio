package gov.ohio.test.java;

import java.math.BigDecimal;

public class FeeAbove500kC2 extends Fee {

	public FeeAbove500kC2() {
		super(new BigDecimal(500000), new BigDecimal(999999999), 0.05, BigDecimal.ZERO);
	}

	public FeeAbove500kC2(BigDecimal lowLimit, BigDecimal topLimit, double feePercentage) {
		super(lowLimit, topLimit, feePercentage, BigDecimal.ZERO);
	}

	@Override
	public BigDecimal calculate() {
		BigDecimal res = new BigDecimal(0);
		BigDecimal multiplicand = new BigDecimal(this.feePercentage);
		res.setScale(2);

		if ((this.amount.intValue() > 0 && this.topLimit.compareTo(this.lowLimit) == 1)) {

			if (this.amount.compareTo(this.lowLimit) == 1) {
				res = this.amount.subtract(this.lowLimit);
				res = res.multiply(multiplicand);
			}
		}

		return res;
	}

}
