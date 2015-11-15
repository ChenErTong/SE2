package businesslogicservice.baseblservice;

import java.util.ArrayList;

import state.ConfirmState;
import state.FindTypeBase;
import state.ResultMessage;
import vo.BaseVO;

public class BaseBLService_Stub implements BaseBLService{

	@Override
	public ConfirmState confirmOperation() {
		System.out.println("Please confirm your operation!");
		
		return ConfirmState.CANCEL;
	}

	@Override
	public ArrayList<BaseVO> show(FindTypeBase baseType) {
		System.out.println("Show"+ baseType +"base value!");
		
		return new ArrayList<BaseVO>(){};
	}

	@Override
	public String getID(FindTypeBase baseType) {
		System.out.println("Please offer an available number for the new base!");
		return "123";
	}

	@Override
	public ResultMessage addBase(BaseVO vo) {
		System.out.println("Add a new base!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteBase(String ID) {
		System.out.println("Delete a base!");
		return  ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateBase(BaseVO vo) {
		System.out.println("The value of the base has been modified!");
		return ResultMessage.SUCCESS;
		
	}

}
