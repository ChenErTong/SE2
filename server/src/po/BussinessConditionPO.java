package po;
/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	



	public class BussinessConditionPO extends PersistentObject{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
<<<<<<< HEAD
		 * 缁忚惀鎯呭喌琛�
		 * 缁熻鏄剧ず涓�娈垫椂闂村唴鐨勭粡钀ユ敹鏀姸鍐靛拰鍒╂鼎銆�
		 * 鏄剧ず淇℃伅锛�	
		 * 1. 鏀跺叆绫�
		 * 2. 鏀嚭绫�
		 * 3. 鍒╂鼎
		
		 */
			/** 璧峰鏃堕棿 */
			public String begin;
			/** 缁撴潫鏃堕棿 */
			public String end;
			/**鏀跺叆**/
			public double totalIncome;
			/**鏀嚭**/
			public double totalExpen;
			/** 鍒╂鼎 */
			public double profit;
			public BussinessConditionPO(String id,String begin, String end, double totalIncome, double totalExpen,double profit){
				super(id);
=======
		 * 经营情况表
		 * 统计显示一段时间内的经营收支状况和利润。
		 * 显示信息：	
		 * 1. 收入类
		 * 2. 支出类
		 * 3. 利润
		
		 */
			/** 起始时间 */
			public String begin;
			/** 结束时间 */
			public String end;
			/**收入**/
			public double totalIncome;
			/**支出**/
			public double totalExpen;
			/** 利润 */
			public double profit;
			public BussinessConditionPO(String begin, String end, double totalIncome, double totalExpen, double profit) {
				super();
>>>>>>> origin/master
				this.begin = begin;
				this.end = end;
				this.totalIncome = totalIncome;
				this.totalExpen = totalExpen;
				this.profit = profit;
			}
			
			
			
	}

