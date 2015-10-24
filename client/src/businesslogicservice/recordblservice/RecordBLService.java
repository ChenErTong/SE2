package businesslogicservice.recordblservice;

import state.ResultMessage;
     /** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public interface RecordBLService {
/**统计经营情况表成本收益表**/
	/**符合条件的所有入款单和收款单**/
	public  ResultMessage bussinessState(String begin, String end);
	/**成本收益表数据**/
	public  ResultMessage bussinessCondition(String end);
	/**计算得到的收入**/
	public  ResultMessage income(String  end);
	/**计算得到的利润**/
	public  ResultMessage earning(String  end);
	/**计算得到的支出**/
	public  ResultMessage expense(String  end);
}
