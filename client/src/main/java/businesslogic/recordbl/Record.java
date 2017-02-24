package businesslogic.recordbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogic.fundbl.DebitAndPayBillShowInfo;
import util.ExportExcel;
import vo.BussinessConditionVO;
import vo.BussinessOneDayVO;
import vo.BussinessProcessExportVO;
import vo.BussinessProcessVO;
import vo.receiptvo.DebitAndPayBillVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:19
 */
public class Record {
	private DebitAndPayBillShowInfo_Record showInfo;

	public Record() throws MalformedURLException, RemoteException, NotBoundException {
		showInfo = new DebitAndPayBillShowInfo();
	}

	/**
	 * 生成成本收益
	 * 
	 * @param begin
	 *            String型，开始日期
	 * @param end
	 *            String型，结束日期
	 * @return ArrayList<DebitAndPayBillVO>型，日期内收付款单列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end) throws RemoteException {
		return showInfo.getBusinessProcess(begin, end);
	}

	/**
	 * 生成经营情况表
	 * 
	 * @param end
	 *            String型，结束日期
	 * @return BussinessConditionVO型，经营情况表
	 * @throws RemoteException
	 *             远程异常
	 */
	public BussinessConditionVO bussinessCondition(String end) throws RemoteException {
		return showInfo.getBussinessCondition(end);
	}

	/**
	 * 返回某一个营业厅一天的收款单
	 * 
	 * @param branchIDString
	 *            型，营业厅编号
	 * @param date
	 *            String型，日期
	 * @return BussinessOneDayVO型，某营业厅单日收款单列表值对象
	 * @throws RemoteException
	 *             远程异常
	 */
	public BussinessOneDayVO bussinessOneDay(String branchID, String date) throws RemoteException {
		return showInfo.getBussinessOneDayIncome(branchID, date);
	}

	/**
	 * 将成本收益表输出到excel
	 * 
	 * @param vo
	 *            BussinessProcessVO型，成本收益表
	 */
	public void exportBussinessProcessToExcel(BussinessProcessVO vo,String fileDirectoryPath) {
		if(fileDirectoryPath.equals(""))
			fileDirectoryPath="output";
		String fileName = fileDirectoryPath+"/" + vo.beginDate + "至" + vo.endDate.split(" ")[0] + "经营情况报表" + ".xls";
		System.out.println(fileName);
		String head = vo.beginDate + "-" + vo.endDate.split(" ")[0] + "经营情况报表";
		String[] title = { "单据编号", "日期", "金额", "单据类型","涉及银行账号", "快递员编号（收款单）", "订单号（收款单）", "姓名（付款单）", "付款类型（付款单）",
				"备注（付款单）" };
		List<Object> list = new ArrayList<>();
		for (DebitAndPayBillVO receipt : vo.receipt) {
			list.add(new BussinessProcessExportVO(receipt));
		}
		System.out.println(ExportExcel.exportExcel(fileName, head, title, list));
	}

	/**
	 * 将经营情况表输出到excel
	 * 
	 * @param vo
	 *            BussinessConditionVO型，经营情况表
	 */
	public void exportBussinessConditionToExcel(BussinessConditionVO vo,String fileDirectoryPath) {
		if(fileDirectoryPath.equals(""))
			fileDirectoryPath="output";
		String fileName = fileDirectoryPath+"/" + "截至" + vo.end + "成本收益报表" + ".xls";
		String head = "截至" + vo.end + "成本收益报表";
		String[] title = { "日期", "总收入", "总支出", "总利润" };
		List<Object> list = new ArrayList<>();
		list.add(vo);
		System.out.println(ExportExcel.exportExcel(fileName, head, title, list));
	}
}
