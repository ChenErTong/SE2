package state;
/**
 * 需要进行审批的单据的类型
 * @author zsq
 * @version Oct 22,2015
 */
/**
 * 增为所有单据类型
 * 
 * @author LIUXUANLIN
 *
 */
public enum ReceiptType {
	CONFIRM("收件确认单", "SJQRD"),
	ORDER("寄件订单", "JJDD"),
	BRANCH_TRUCK("装车单", "ZCD"),
	BRANCH_ARRIVAL("营业厅到达单", "YYTDDD"),
	BRANCH_DELIVER("营业厅派件单", "YYTPJD"),
	DEBIT("收款单", "SKD"),
	PAY("付款单","FKD"),
	TRANS_ARRIVAL("中转中心到达单", "ZZZXDDD"),
	TRANS_ORDER("转运单", "FJZYD"),
	
	INSTOCK("入库单","RKD"),
	OUTSTOCK("出库单","CCD"),
	TAKINGSTOCK("库存调整单","KCTZD");
	
	
	public final String value;
	public final String prefix;
	
	ReceiptType(String value,String prefix){
		this.value = value;
		this.prefix = prefix;
	}
	
	public boolean equals(ReceiptType type){
		if(type==null)
			return true;
		else
			return super.equals(type);
	}
}
