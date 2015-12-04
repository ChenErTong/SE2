package state;
/**
 * 进行银行账户查询时的查找方式（类型）
 * @author zsq
 * @version Oct 22,2015
 */
public enum FindTypeAccount {
	ID("账户ID"),
	NAME("账户名称"),
	MONEY("账户余额");
	public final String value;
	
	FindTypeAccount(String value){
		this.value = value;
	}
	/**
	 * 根据类型返回要调用的方法名
	 * 使用反射调用BankAccountPO的方法
	 * @author Ann
	 * @param type
	 * @return
	 */
	public static String toMethodName(FindTypeAccount type) {
		if(type==null)			return "toString";
		else if(type==ID)  return "getID";
		else if(type==NAME) return "getName";
		else if(type==MONEY) return "getMoneyString";
		else return null;
	}
}
