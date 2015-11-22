package state;

/**
 * 用户的身份：快递员、营业厅业务员、中转中心业务员、中转中心库存管理人员、财务人员、总经理、管理员
 * @author zsq
 *@version Oct 22,2015
 */
public enum UserIdentity {
	COURIER("快递员"),
	GENERAL_MANAGER("总经理"),
	INVENTORY_MANAGER("库存管理人员"),
	FINANCE_MANAGER("财务人员"),
	BRANCH_COUNTERMAN("营业厅业务员"),
	TRANSFER_CONTERMAN("中转中心业务员"),
	ADMIN("管理员");
	
	public final String value;

	UserIdentity(String value) {
		this.value = value;
	}
}
