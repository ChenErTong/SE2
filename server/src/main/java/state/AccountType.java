package state;
/**
 * 这个类可能用不到了
 * @author Ann
 *
 */
@Deprecated
public enum AccountType {
	//还会改，比如应该是司机啊什么之类的
	COURIER("快递员"),
	GENERAL_MANAGER("总经理"),
	INVENTORY_MANAGER("库存管理人员"),
	FINANCE_MANAGER("财务人员"),
	BRANCH_COUNTERMAN("营业厅业务员"),
	TRANSFER_CONTERMAN("中转中心业务员"),
	ADMIN("管理员"),
	DRIVER("司机");
	public  final String value;

	AccountType(String value) {
		this.value = value;
	}
}
