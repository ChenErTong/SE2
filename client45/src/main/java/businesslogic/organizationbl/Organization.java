package businesslogic.organizationbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.branch.BranchTrans;
import businesslogic.transferbl.TransferTrans;
import dataservice.branchdataservice.BranchDataService;
import dataservice.transferdataservice.TransferDataService;
import po.BranchPO;
import po.TransferPO;
import state.ResultMessage;
import vo.BranchVO;
import vo.TransferVO;

public class Organization {
	private BranchDataService branchData;
	private TransferDataService transferData;

	public Organization() {
		try {
			branchData = (BranchDataService) Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + BranchDataService.NAME);
			transferData = (TransferDataService) Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + TransferDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BranchVO> showBranch() throws RemoteException {
		ArrayList<BranchPO> branchPOs = branchData.find();
		return BranchTrans.convertPOstoVOs(branchPOs);
	}

	public String getBranchID()throws RemoteException  {
		return branchData.getID();
	}

	public ResultMessage addBranch(BranchVO vo) throws RemoteException {
		BranchPO po = BranchTrans.convertVOtoPO(vo);
		return branchData.add(po);
	}

	public ResultMessage deleteBranch(String organizationID) throws RemoteException {
		return branchData.delete(organizationID);
	}

	public ResultMessage updateBranch(BranchVO vo)throws RemoteException  {
		BranchPO po = BranchTrans.convertVOtoPO(vo);
		return branchData.modify(po);
	}

	public ArrayList<TransferVO> showTransfer()throws RemoteException  {
		ArrayList<TransferPO> pos = transferData.find();
		return TransferTrans.convertPOstoVOs(pos);
	}

	public String getTransferID()throws RemoteException  {
		return transferData.getID();
	}

	public ResultMessage addTransfer(TransferVO vo)throws RemoteException  {
		TransferPO transferPO = TransferTrans.convertVOtoPO(vo);
		return transferData.add(transferPO);
	}

	public ResultMessage deleteTransfer(String organizationID)throws RemoteException  {
		return transferData.delete(organizationID);
	}

	public ResultMessage updateTransfer(TransferVO vo) throws RemoteException {
		TransferPO transferPO = TransferTrans.convertVOtoPO(vo);
		return transferData.modify(transferPO);
	}
}
