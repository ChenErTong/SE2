package businesslogic.fundbl;
/**
 * @author LIUXUANLIN
 */
import po.BankAccountPO;
import po.receiptpo.DebitAndPayBillPO;
import state.ReceiptType;
import vo.BankAccountVO;
import vo.DebitAndPayBillVO;

public class FundTrans {
	public static BankAccountPO convertVOtoPO(BankAccountVO vo){
		if (vo==null) {
			return null;
		}
		else {
			String ID = vo.getID();
			String name  =vo.getName();
			double money = vo.getMoney();
			String level = vo.getLevel();
			return new BankAccountPO(ID, name, money, level);
		}
	}
	
	public static DebitAndPayBillPO convertVOtoPO(DebitAndPayBillVO VO){
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
	
	public static DebitAndPayBillVO convertPOtoVO(DebitAndPayBillPO PO){
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
}
