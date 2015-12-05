package util;
/** 
* 工具类
* 一些静态方法用来实现重复简单功能 
* @author Ann
* @version 创建时间：2015年12月5日 上午9:35:52 
*/
public class Util {
	/**
	 * 将营业厅编号分裂成城市编号和营业厅号
	 * @author Ann
	 * @param branchID String型 营业厅编号
	 * @return 城市编号和营业厅号 String[]型
	 * 				  String[0]为城市编号
	 * 				  String[1]为营业厅编号
	 */
	public static String[] splitBranchID(String branchID){
		int length = branchID.length();
		String result[] = new String[2];
		String branchNumber = branchID.substring(length-3);
		String cityCode = branchID.substring(0,length-3);
		result[0]=cityCode;
		result[1]=branchNumber;
		return result;
	}
	
	/**
	 * @deprecated
	 * @param transferID
	 * @return
	 */
	public static String[] splitTransferID(String transferID){
		int length = transferID.length();
		String result[] = new String[2];
		String transferNumber = transferID.substring(length-1);
		String cityCode = transferID.substring(0,length-1);
		result[0]=cityCode;
		result[1]=transferNumber;
		return result;
	}
}
