package state;

public enum UserAuthority {
	HIGHESTLEVEL("管理员权限"),//
	COMMONLEVEL("普通员工权限"),//
	MANAGER_LEVEL("总经理权限"),//
	ADVANCE_FINANCE("高级财务权限");
	
	public  final String value;

	UserAuthority(String value) {
		this.value = value;
	}
}
