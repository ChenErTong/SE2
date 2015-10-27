package businesslogicservice.recordblservice;


import vo.BussinessConditionVO;
import vo.BussinessProcessVO;
     /** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public interface RecordBLService {
/**统计经营情况表成本收益表**/
	/**符合条件的所有入款单和收款单**/
	public  BussinessProcessVO bussinessProcess(String begin, String end);
	/**成本收益表数据**/
	public  BussinessConditionVO bussinessCondition(String end);
	/**计算得到的收入**/
	public   double income(String  end);
	/**计算得到的利润**/
	public   double earning(String  end);
	/**计算得到的支出**/
	public   double expense(String  end);
}
