package state;

public enum UserAuthority {
	HIGHESTLEVEL("管理员权限"),//
	COMMONLEVEL("普通用户权限"),//
	MANAGER_LEVEL("总经理权限"),//
	ADVANCE_FINANCE("高级财务人员");
	
	public  final String value;

	UserAuthority(String value) {
		this.value = value;
	}
}
