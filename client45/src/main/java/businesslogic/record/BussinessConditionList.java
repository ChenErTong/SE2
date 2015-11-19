package businesslogic.record;

import java.util.ArrayList;

import vo.BussinessConditionVO;


/**
 * 查看经营情况表（统计显示一段时间内的经营收支状况和利润。

 * 显示信息：
 * 	1. 收入
 *  2. 支出类
 *  3. 利润：
 * 各报表能够导出。

 * @author lxl
 * @version
 */
public class BussinessConditionList {
	
	
	/** 销售收入 */
	private double Income=5000;
	/**销售成本*/
	private double Expense=3000;
	/** 利润 */
	private double profit=2000;	
	
	ArrayList<BussinessConditionVO> VO;
	public String end;
	
	
	
	public BussinessConditionList(String endDate) {
		this.end = endDate;
		this.VO = new ArrayList<BussinessConditionVO>();
	}


	/**
	 * 得到最终的经营情况VO
	 * @return
	 * @author
	 * @version 
	 * @throws 
	 */

	public BussinessConditionVO BussinessCondition(String end) {
		BussinessConditionVO vo = new BussinessConditionVO( "20151003", Income, Expense, profit); 
		return vo;
	}

	
	



	
}
	