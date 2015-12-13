package businesslogic.fundbl;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author LIUXUANLIN
 */
import po.BankAccountPO;
import po.ExpensePO;
import po.receiptpo.DebitAndPayBillPO;
import po.receiptpo.DebitBillPO;
import po.receiptpo.PaymentBillPO;
import state.PayBillItem;
import state.ReceiptType;
import vo.BankAccountVO;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.ExpenseVO;
import vo.receiptvo.PaymentBillVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:35:08
 */
public class FundTrans {
	public static BankAccountPO convertVOtoPO(BankAccountVO vo) {
		if (vo == null) {
			return null;
		} else {
			String ID = vo.ID;
			String name = vo.name;
			BigDecimal money = vo.money;
			String level = vo.level;
			return new BankAccountPO(ID, name, money, level);
		}
	}

	public static ExpensePO convertVOtoPO(ExpenseVO vo) {
		if (vo == null) {
			return null;
		} else {
			String ID = vo.ID;
			String workshop = vo.workshop;
			BigDecimal money = vo.money;
			String address = vo.address;
			return new ExpensePO(ID, workshop, money, address);
		}
	}

	public static DebitAndPayBillPO convertVOtoPO(DebitAndPayBillVO VO) {
		/** 类似factory */
		ReceiptType type = VO.type;
		if (type == ReceiptType.DEBIT)
			return convertVOtoPO((DebitBillVO) VO);
		if (type == ReceiptType.PAY)
			return convertVOtoPO((PaymentBillVO) VO);
		else
			return null;
	}

	public static DebitAndPayBillVO convertPOtoVO(DebitAndPayBillPO PO) {
		/** 类似factory */
		ReceiptType type = PO.getReceiptType();
		if (type == ReceiptType.DEBIT)
			return convertPOtoVO((DebitBillPO) PO);
		if (type == ReceiptType.PAY)
			return convertPOtoVO((PaymentBillPO) PO);
		else
			return null;
	}

	public static DebitBillVO convertPOtoVO(DebitBillPO po) {
		if (po == null)
			return null;
		else {
			String id = po.getID();
			ReceiptType type = po.getReceiptType();
			String courierID = po.getCourierID();
			BigDecimal money = po.getMoney();
			ArrayList<String> orderNumbers = po.getOrderNumbers();
			String date = po.getDate();
			String bankAccountID = po.getBankAccountID();
			return new DebitBillVO(id, type, courierID, money, orderNumbers, date,bankAccountID);
		}
	}

	public static DebitBillPO convertVOtoPO(DebitBillVO vo) {
		if (vo == null)
			return null;
		else {
			String id = vo.ID;
			ReceiptType type = vo.type;
			String courierID = vo.courierID;
			String bankAccountID = vo.bankAccountID;
			BigDecimal money = vo.money;
			ArrayList<String> orderNumbers = vo.orderNumbers;
			String date = vo.date;
			return new DebitBillPO(id, type, courierID, money, orderNumbers, date,bankAccountID);
		}
	}

	public static PaymentBillVO convertPOtoVO(PaymentBillPO po) {
		if (po == null)
			return null;
		else {
			String iD = po.getID();
			String date = po.getDate();
			ReceiptType type = po.getReceiptType();
			BigDecimal money = po.getMoney();
			String payerName = po.getPayerName();
			String accountID = po.getBankAccountID();
			PayBillItem items = po.getPayBillItem();
			String remarks = po.getRemarks();
			return new PaymentBillVO(iD, date, type, money, payerName, accountID, items, remarks);
		}
	}

	public static PaymentBillPO convertVOtoPO(PaymentBillVO vo) {
		if (vo == null)
			return null;
		else {
			String ID = vo.ID;
			ReceiptType type = vo.type;
			BigDecimal money = vo.money;
			String payerName = vo.payerName;
			String accountID = vo.bankAccountID;
			PayBillItem items = vo.items;
			String remarks = vo.remarks;
			return new PaymentBillPO(ID, type, money, payerName, items, accountID, remarks);
		}
	}

	public static BankAccountVO convertPOtoVO(BankAccountPO po) {
		BankAccountVO vo = new BankAccountVO(po.getID(), po.getName(), po.getMoney(), po.getLevel());
		return vo;
	}

	public static ExpenseVO convertPOtoVO(ExpensePO po) {
		ExpenseVO vo = new ExpenseVO(po.getID(), po.getWorkshop(), po.getMoney(), po.getAddress());
		return vo;
	}

	public static ArrayList<BankAccountVO> convertBankAccountPOstoVOs(ArrayList<BankAccountPO> pos) {
		ArrayList<BankAccountVO> vos = new ArrayList<>();
		for (BankAccountPO bankAccountPO : pos) {
			BankAccountVO vo = convertPOtoVO(bankAccountPO);
			vos.add(vo);
		}
		return vos;
	}

	public static ArrayList<DebitAndPayBillVO> convertDebitAndPayBillPOstoVOs(ArrayList<DebitAndPayBillPO> pos) {
		ArrayList<DebitAndPayBillVO> vos = new ArrayList<>();
		for (DebitAndPayBillPO debitAndPayBillPO : pos) {
			DebitAndPayBillVO vo = convertPOtoVO(debitAndPayBillPO);
			vos.add(vo);
		}
		return vos;
	}

	public static ArrayList<ExpenseVO> convertExpensePOstoVOs(ArrayList<ExpensePO> pos) {
		ArrayList<ExpenseVO> vos = new ArrayList<>();
		for (ExpensePO expensePO : pos) {
			ExpenseVO vo = convertPOtoVO(expensePO);
			vos.add(vo);
		}
		return vos;
	}

	public static ArrayList<BankAccountPO> convertVOstoPOs(ArrayList<BankAccountVO> vos) {
		ArrayList<BankAccountPO> pos = new ArrayList<>();
		for (BankAccountVO vo : vos) {
			BankAccountPO po = convertVOtoPO(vo);
			pos.add(po);
		}
		return pos;
	}

	public static DebitBillVO convertDebitPOtoDebitVO(DebitBillPO po) {
		DebitBillVO vo = new DebitBillVO(po.getID(), po.getReceiptType(), po.getCourierID(), po.getMoney(),
				po.getOrderNumbers(), po.getDate(),po.getBankAccountID());
		return vo;
	}
}
