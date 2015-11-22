package businesslogic.fundbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import dataservice.funddataservice.DebitAndPayBillDataService;
import po.BankAccountPO;
import po.receiptpo.DebitAndPayBillPO;
import state.PayBillItem;
import state.ReceiptCondition;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.DebitAndPayBillVO;

public class DebitAndPayBill  {
	private DebitAndPayBillDataService debitAndPayBillData;

	public DebitAndPayBill() {
		try {
			debitAndPayBillData = (DebitAndPayBillDataService) Naming
					.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + DebitAndPayBillDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getExpenseID() throws RemoteException {
		// TODO Auto-generated method stub
		return  debitAndPayBillData.getExpenseID();
	}


	public String getPayID() throws RemoteException {
		// TODO Auto-generated method stub
		return  debitAndPayBillData.getPayID();
	}

	

	public DebitAndPayBillVO find(String ID) throws RemoteException {
		DebitAndPayBillPO PO=debitAndPayBillData.find(ID);
		return  POtoVO(PO);
	}
   
	
	public DebitAndPayBillVO POtoVO(DebitAndPayBillPO PO){
	    ReceiptType type=PO.getType();
	    if(type==ReceiptType.EXPENSE){
	    	//收款单
	    	DebitAndPayBillVO vo=new DebitAndPayBillVO(PO.getID(),PO.getMoney(),PO.getCourierID(),PO.getType(),PO.getOrderNumbers());
	    	 return vo;
	    }
	   if(type==ReceiptType.PAY){
		   //付款单
		   DebitAndPayBillVO vo=new DebitAndPayBillVO(PO.getID(),PO.getMoney(),PO.getPayerName(),PO.getBankAccouts(),PO.getType(),PO.getRentYear(),PO.getSalaryMonth(),PO.getItems(),PO.getTransListNumber());
		   return vo;
	   }
	   else{
	   return null;
	   }
	   
   }

	public HashMap<String, String> getAllBankAccounts() {
		return debitAndPayBillData.getAllBankAccounts();
		
	}

	
	//建立收款单
	public ResultMessage addDebitBill(double money,String courierID,ReceiptType type,ArrayList orderNumbers) throws RemoteException {
		//疑问
		String ID=null;
		DebitAndPayBillVO vo=new DebitAndPayBillVO(ID,money, courierID, type, orderNumbers);
		DebitAndPayBillPO po=VOtoPO(vo);
		return debitAndPayBillData.insert(po);
	}
     
	
	
	//建立付款单
	public ResultMessage addPayBill(double money,String payerName,ArrayList<BankAccountPO>bankAccouts,ReceiptType type,
			String rentYear,String salaryMonth,PayBillItem items,ArrayList transListNumber) throws RemoteException {
		//疑问
				String ID=null;
		DebitAndPayBillVO vo=new DebitAndPayBillVO(ID, money,payerName,bankAccouts, type,
				rentYear, salaryMonth,items, transListNumber);
		DebitAndPayBillPO po=VOtoPO(vo);
		return debitAndPayBillData.insert(po);
	}
	
	
	public DebitAndPayBillPO VOtoPO(DebitAndPayBillVO VO){
	    ReceiptType type=VO.getType();
	    if(type==ReceiptType.EXPENSE){
	    	//收款单
	    	DebitAndPayBillPO po=new DebitAndPayBillPO(VO.getID(),VO.getMoney(),VO.getCourierID(),VO.getType(),VO.getOrderNumbers());
	    	 return po;
	    }
	   if(type==ReceiptType.PAY){
		   //付款单
		   DebitAndPayBillPO po=new DebitAndPayBillPO(VO.getID(),VO.getMoney(),VO.getPayerName(),VO.getBankAccouts(),VO.getType(),VO.getRentYear(),VO.getSalaryMonth(),VO.getItems(),VO.getTransListNumber());
		   return po;
	   }
	   else{
	   return null;
	   }
	   
   }
	
	
	public ResultMessage submit(DebitAndPayBillPO po) throws RemoteException  {
		po.setReceiptCondition(ReceiptCondition.SUBITTED);
		return debitAndPayBillData.update(po);
	}

	
	public ResultMessage save(DebitAndPayBillPO po) throws RemoteException  {
		debitAndPayBillData.insert(po);
		return debitAndPayBillData.insert(po);
	}

	
	public ResultMessage updateDraft(DebitAndPayBillPO po) throws RemoteException {
		debitAndPayBillData.update(po);
		return debitAndPayBillData.update(po);
	}


	
	public ArrayList<DebitAndPayBillVO> showPay() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos=debitAndPayBillData.show(ReceiptType.PAY);
		ArrayList<DebitAndPayBillVO> vos=new ArrayList<DebitAndPayBillVO>();
		for(DebitAndPayBillPO po:pos){
			DebitAndPayBillVO vo=POtoVO(po);
			vos.add(vo);
		}
		return vos;
	}

	
	public ArrayList<DebitAndPayBillVO> showExpense() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos=debitAndPayBillData.show(ReceiptType.EXPENSE);
		ArrayList<DebitAndPayBillVO> vos=new ArrayList<DebitAndPayBillVO>();
		for(DebitAndPayBillPO po:pos){
			DebitAndPayBillVO vo=POtoVO(po);
			vos.add(vo);
		}
		return vos;
	}

	
	public ArrayList<DebitAndPayBillVO> showPayApproving() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos=debitAndPayBillData.show(ReceiptType.PAY,ReceiptState.APPROVALING);
		ArrayList<DebitAndPayBillVO> vos=new ArrayList<DebitAndPayBillVO>();
		for(DebitAndPayBillPO po:pos){
			DebitAndPayBillVO vo=POtoVO(po);
			vos.add(vo);
		}
		return vos;
	}

	
	public ArrayList<DebitAndPayBillVO> showExpenseApproving() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos=debitAndPayBillData.show(ReceiptType.PAY,ReceiptState.APPROVALING);
		ArrayList<DebitAndPayBillVO> vos=new ArrayList<DebitAndPayBillVO>();
		for(DebitAndPayBillPO po:pos){
			DebitAndPayBillVO vo=POtoVO(po);
			vos.add(vo);
		}
		return vos;
	}

	
	public ArrayList<DebitAndPayBillVO> showPayPass() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos=debitAndPayBillData.show(ReceiptType.PAY,ReceiptState.SUCCESS);
		ArrayList<DebitAndPayBillVO> vos=new ArrayList<DebitAndPayBillVO>();
		for(DebitAndPayBillPO po:pos){
			DebitAndPayBillVO vo=POtoVO(po);
			vos.add(vo);
		}
		return vos;
	}

	
	public ArrayList<DebitAndPayBillVO> showExpensePass() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos=debitAndPayBillData.show(ReceiptType.EXPENSE,ReceiptState.SUCCESS);
		ArrayList<DebitAndPayBillVO> vos=new ArrayList<DebitAndPayBillVO>();
		for(DebitAndPayBillPO po:pos){
			DebitAndPayBillVO vo=POtoVO(po);
			vos.add(vo);
		}
		return vos;
	}

	
	public ArrayList<DebitAndPayBillVO> showPayFailure() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos=debitAndPayBillData.show(ReceiptType.PAY,ReceiptState.FAILURE);
		ArrayList<DebitAndPayBillVO> vos=new ArrayList<DebitAndPayBillVO>();
		for(DebitAndPayBillPO po:pos){
			DebitAndPayBillVO vo=POtoVO(po);
			vos.add(vo);
		}
		return vos;
	}

	
	public ArrayList<DebitAndPayBillVO> showExpenseFailure() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos=debitAndPayBillData.show(ReceiptType.EXPENSE,ReceiptState.FAILURE);
		ArrayList<DebitAndPayBillVO> vos=new ArrayList<DebitAndPayBillVO>();
		for(DebitAndPayBillPO po:pos){
			DebitAndPayBillVO vo=POtoVO(po);
			vos.add(vo);
		}
		return vos;
	}

	
	public ArrayList<DebitAndPayBillVO> showPayDraft() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos=debitAndPayBillData.show(ReceiptType.PAY,ReceiptState.DRAFT);
		ArrayList<DebitAndPayBillVO> vos=new ArrayList<DebitAndPayBillVO>();
		for(DebitAndPayBillPO po:pos){
			DebitAndPayBillVO vo=POtoVO(po);
			vos.add(vo);
		}
		return vos;
	}

	
	public ArrayList<DebitAndPayBillVO> showExpenseDraft() throws RemoteException {
		ArrayList<DebitAndPayBillPO> pos=debitAndPayBillData.show(ReceiptType.EXPENSE,ReceiptState.DRAFT);
		ArrayList<DebitAndPayBillVO> vos=new ArrayList<DebitAndPayBillVO>();
		for(DebitAndPayBillPO po:pos){
			DebitAndPayBillVO vo=POtoVO(po);
			vos.add(vo);
		}
		return vos;
	}
	
	

}
