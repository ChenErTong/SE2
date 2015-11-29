package businesslogic.recordbl;

/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.fundbl.DebitAndPayBillShowInfo;
import businesslogic.fundbl.FundTrans;
import config.RMIConfig;
import dataservice.accountdataservice.AccountDataService;
import dataservice.funddataservice.DebitAndPayBillDataService;
import po.accountpo.AccountPO;
import po.receiptpo.DebitAndPayBillPO;
import po.receiptpo.DebitBillPO;
import state.ReceiptType;
import vo.BussinessConditionVO;
import vo.BussinessOneDayVO;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;

public class Record {
	private DebitAndPayBillDataService DebitAndPayBillData;
	private AccountDataService AccountData;

	public Record() {
		try {
			DebitAndPayBillData = (DebitAndPayBillDataService) Naming.lookup(RMIConfig.PREFIX + DebitAndPayBillDataService.NAME);
			AccountData = (AccountDataService) Naming.lookup(RMIConfig.PREFIX + AccountDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
   
	
	public ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end) throws RemoteException {
		DebitAndPayBillShowInfo_Record showInfo = new DebitAndPayBillShowInfo();
		return showInfo.getBusinessProcess(begin, end);
	}

	public BussinessConditionVO bussinessCondition(String end) throws RemoteException {
		DebitAndPayBillShowInfo_Record showInfo = new DebitAndPayBillShowInfo();
		return showInfo.getBussinessCondition(end);
	}
	/**
	 * 返回某一个营业厅一天的收款单
	 * @param WorkPlace
	 * @param date
	 * @return
	 * @throws RemoteException
	 */
	public BussinessOneDayVO bussinessOneDay(String WorkPlace,String date) throws RemoteException {
		ArrayList<AccountPO> AccountPos=AccountData.find();
		String ID = null;
		for (AccountPO po : AccountPos) {
			if(WorkPlace==po.getBranchID()){
				 ID= po.getID();
			}
	 }
		ArrayList<DebitBillPO> POs = DebitAndPayBillData.showDate(date);
		ArrayList<DebitBillVO> VOs=new ArrayList<DebitBillVO>();
		double income = 0;

		for (DebitBillPO po : POs) {
				income = income + po.getMoney();
              if( po.getCourierID()==ID){
            	  VOs.add(FundTrans.convertDebitPOtoDebitVO(po));
              }
		 }
		BussinessOneDayVO bussinessOneDayvo=new BussinessOneDayVO(VOs,income);
		return bussinessOneDayvo;
		 
	}
}

