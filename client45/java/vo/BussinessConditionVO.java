package vo;

import java.math.BigDecimal;

public class BussinessConditionVO {

	/**
	 * 成本收益表 统计显示一段时间内的经营收支状况和利润。 显示信息： 1. 收入类 2. 支出类 3. 利润
	 * 
	 */

	/** 结束时间 */
	public String end;
	/** 收入 **/
	public BigDecimal totalIncome;
	/** 支出 **/
	public BigDecimal totalExpen;
	/** 利润 */
	public BigDecimal profit;

	public BussinessConditionVO(String end, BigDecimal totalIncome, BigDecimal totalExpen, BigDecimal profit) {
		super();
		this.end = end;
		this.totalIncome = totalIncome;
		this.totalExpen = totalExpen;
		this.profit = profit;
	}

}
