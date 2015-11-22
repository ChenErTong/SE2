package vo;

public class BussinessConditionVO {
	

	/**
	 * 经营情况表
	 * 统计显示一段时间内的经营收支状况和利润。
	 * 显示信息：	
	 * 1. 收入类
	 * 2. 支出类
	 * 3. 利润
	
	 */
		
		/** 结束时间 */
		public String end;
		/**收入**/
		public double totalIncome;
		/**支出**/
		public double totalExpen;
		/** 利润 */
		public double profit;
		public BussinessConditionVO( String end, double totalIncome, double totalExpen, double profit) {
			super();
			
			this.end = end;
			this.totalIncome = totalIncome;
			this.totalExpen = totalExpen;
			this.profit = profit;
		}
		public String getEnd() {
			return end;
		}
		public void setEnd(String end) {
			this.end = end;
		}
		public double getTotalIncome() {
			return totalIncome;
		}
		public void setTotalIncome(double totalIncome) {
			this.totalIncome = totalIncome;
		}
		public double getTotalExpen() {
			return totalExpen;
		}
		public void setTotalExpen(double totalExpen) {
			this.totalExpen = totalExpen;
		}
		public double getProfit() {
			return profit;
		}
		public void setProfit(double profit) {
			this.profit = profit;
		}
		
		
}
		

	


