package state;

/**
 * 用户的身份：快递员、营业厅业务员、中转中心业务员、中转中心库存管理人员、财务人员、总经理、管理员
 * @author zsq
 *@version Oct 22,2015
 */
public enum UserIdentity {
	COURIER("快递员","6"),
	GENERAL_MANAGER("总经理","0"),
	INVENTORY_MANAGER("库存管理人员","4"),
	FINANCE_MANAGER("财务人员","1"),
	BRANCH_COUNTERMAN("营业厅业务员","5"),
	TRANSFER_CONTERMAN("中转中心业务员","3"),
	DRIVER("司机","9"),
	ADMIN("管理员","2");
	
	public  final String value;
	public  final String userIDMidFix;

	UserIdentity(String value,String userIDMidFix) {
		this.value = value;
		this.userIDMidFix=userIDMidFix;
	}
	
	
}
