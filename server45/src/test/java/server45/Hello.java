package server45;

import java.util.ArrayList;

import po.InventoryPO;
import po.TransferPO;
import po.accountpo.AccountPO;

public class Hello extends TransferPO {

	public Hello(String id, String date, String address, ArrayList<AccountPO> accounts,
			ArrayList<InventoryPO> inventories) {
		super(id, date, address, accounts, inventories);
		// TODO Auto-generated constructor stub
	}

}
