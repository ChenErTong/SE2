package businesslogic.record;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.recordblservice.RecordBLService;
import dataservice.funddataservice.DebitAndPayBillDataService;
import dataservice.recorddataservice.RecordDataService;
import po.BankAccountPO;
import po.BussinessProcessPO;
import po.DebitAndPayBillPO;
import po.receiptpo.DebitBillPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.PaymentBillPO;
import state.PayBillItem;
import state.ReceiptType;
import state.ResultMessage;
import vo.BussinessConditionVO;
import vo.BussinessProcessVO;
import vo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.PaymentBillVO;

public class record implements RecordBLService{
	private RecordDataService recordData;
	private  DebitAndPayBillDataService  DebitAndPayBillData;
	public record() {
		try {
			recordData= (RecordDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+RecordDataService.NAME);
			DebitAndPayBillData = (DebitAndPayBillDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+ RecordDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end) throws RemoteException {
		ArrayList<DebitAndPayBillPO> POs=DebitAndPayBillData.showList(begin,end);
		ArrayList<DebitAndPayBillVO> VOs = null;
		for(DebitAndPayBillPO po : POs) {
			DebitAndPayBillVO vo = poTOvo(po);
			VOs.add(vo);
		}
		return VOs;
	}
   
	@Override
	public BussinessConditionVO bussinessCondition(String end) throws RemoteException {
		String begin=recordData.getBegin();
		ArrayList<DebitAndPayBillPO> POs=DebitAndPayBillData.showList(begin,end);
		ArrayList<DebitAndPayBillVO> VOs = null;
		double income=0;
		double expense=0;
		double profit=0;
		for(DebitAndPayBillPO po : POs) {
			 ReceiptType type=po.getType();
			   //如果是收款单
			   if(type==ReceiptType.EXPENSE){
				 income=income+po.getMoney();
			   }
			 //如果是付款单
			   if(type==ReceiptType.PAY){
				  expense=expense+po.getMoney();
			   }
		}
		profit=income-expense;
		BussinessConditionVO vo=new BussinessConditionVO(end, income, expense, profit);
		return vo;
		
	}
   
   public DebitAndPayBillVO poTOvo(DebitAndPayBillPO po){
	   ReceiptType type=po.getType();
	   //如果是收款单
	   if(type==ReceiptType.EXPENSE){
		   DebitAndPayBillVO vo1=new DebitAndPayBillVO(po.getID(),po.getMoney(),po.getCourierID(),po.getType(),po.getOrderNumbers());
	       return vo1;
	   }
	 //如果是付款单
	   if(type==ReceiptType.PAY){
		   DebitAndPayBillVO vo2=new DebitAndPayBillVO(po.getID(),po.getMoney(),po.getPayerName(),po.getBankAccouts(),po.getType(),po.getRentYear(),po.getSalaryMonth(),po.getItems(),po.getTransListNumber());
	       return vo2;
	   }
	  return null;
   }
@Override
public double income(String end) throws RemoteException {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public double earning(String end) throws RemoteException {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public double expense(String end) throws RemoteException {
	// TODO Auto-generated method stub
	return 0;
}
    


}
