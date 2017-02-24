package state;

public enum OrderState {
	TO_BE_EXPORTED,//等待运送
	EXPORTING,//运送中
	IN_STOCK,//在仓库中（这个状态估计用不到）
	RECEIVE,//快件收取
	MANAGER_APPROVING;//总经理审批中
}
