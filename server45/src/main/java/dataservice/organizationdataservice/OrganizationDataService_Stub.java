package dataservice.organizationdataservice;

import java.util.ArrayList;

import po.OrganizationPO;
import state.ResultMessage;

public class OrganizationDataService_Stub implements OrganizationDataService{
	
	private ArrayList<OrganizationPO> organizationPOs;
	private OrganizationPO organizationPO_1;
	private OrganizationPO organizationPO_2;
	
	public OrganizationDataService_Stub(){
		organizationPOs = new ArrayList<OrganizationPO>();
		organizationPO_1 = new OrganizationPO("123","FUCK",120);
		organizationPO_2 = new OrganizationPO("456","FUCKFUCK",150);
		
		organizationPOs.add(organizationPO_1);
		organizationPOs.add(organizationPO_2);
		}

	@Override
	public ResultMessage add(OrganizationPO po) {
		System.out.println("Insert a organization succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String ID) {
		System.out.println("Delete a organization succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(OrganizationPO po) {
		System.out.println("Modify the information of an organizationg succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<OrganizationPO> find() {
		System.out.println("Show all organizations succeed!");
		return new ArrayList<OrganizationPO>();
	}

	

	

}
