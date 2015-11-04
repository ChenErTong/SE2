package dataservice.organizationdataservice;

import java.util.ArrayList;

import po.OrganizationPO;
import po.PersistentObject;
import state.ResultMessage;

public class OrganizationDataService_Stub implements OrganizationDataService{
	
	private ArrayList<OrganizationPO> organizationPOs;
	private OrganizationPO organizationPO_1;
	private OrganizationPO organizationPO_2;
	
	public OrganizationDataService_Stub(){
		organizationPOs = new ArrayList<OrganizationPO>();
		organizationPO_1 = new OrganizationPO("123","¾ÅÏçºÓ163ºÅ",120);
		organizationPO_2 = new OrganizationPO("456","¹ÄÂ¥",150);
		
		organizationPOs.add(organizationPO_1);
		organizationPOs.add(organizationPO_2);
		}

	@Override
	public ResultMessage insert(PersistentObject po) {
		System.out.println("Insert a organization succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String ID) {
		System.out.println("Delete a organization succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(PersistentObject po) {
		System.out.println("Modify the information of an organizationg succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<OrganizationPO> show() {
		System.out.println("Show all organizations succeed!");
		return new ArrayList<OrganizationPO>(){};
	}

}
