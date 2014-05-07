package gov.ohio.test.java;

import java.math.BigDecimal;

public class FeeBetween100k500kC2 extends Fee {

	public FeeBetween100k500kC2() {
		super(new BigDecimal(100000), new BigDecimal(500000), 0.10, BigDecimal.ZERO);
	}

	@Override
	public BigDecimal calculate() {
		BigDecimal res = new BigDecimal(0);
		BigDecimal multiplicand = new BigDecimal(this.feePercentage);
		res.setScale(2);

		if ((this.amount.intValue() > 0 && this.topLimit.compareTo(this.lowLimit) == 1)) {

			if (this.amount.compareTo(this.topLimit) == 1) {
				res = this.topLimit.subtract(this.lowLimit);
				res = res.multiply(multiplicand);
			} else if ((this.amount.compareTo(this.topLimit) == -1 || this.amount.compareTo(this.topLimit) == 0) && this.amount.compareTo(this.lowLimit) == 1) {
				res = this.amount.multiply(multiplicand);
			}
		}

		return res;
	}

}
