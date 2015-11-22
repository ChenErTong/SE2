package businesslogic.inventory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.inventoryblservice.InventoryBLService;
import dataservice.basedataservice.BaseDataService;
import dataservice.inventorydataservice.InventoryDataService;
import dataservice.transferdataservice.TransferDataService;
import po.InventoryPO;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.TransferArrivalListPO;
import state.ResultMessage;
import vo.InventoryCheckVO;
import vo.InventoryVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.TransferArrivalListVO;

public class Inventory implements InventoryBLService {
	private InventoryDataService inventoryData;
	private TransferDataService transferData;
	public Inventory() {
		try {
			inventoryData= (InventoryDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+InventoryDataService.NAME);
			transferData= (TransferDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+TransferDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public InventoryViewVO viewInventory(String beginDate, String endDate) throws RemoteException  {
		   ArrayList<InventoryVO> VOs=new ArrayList<InventoryVO>();
		   ArrayList<InventoryPO> POs=inventoryData.getInventoryPOList(endDate);
		   for(InventoryPO po : POs) {
				InventoryVO vo = POtoVO(po);
				VOs.add(vo);
			}
			InventoryViewVO viewVO=new InventoryViewVO (inventoryData.getimportNumber(beginDate,  endDate), inventoryData.getexportNumber( beginDate, endDate), inventoryData.getNum( beginDate,  endDate),VOs);
		   return viewVO;
	}
	
	private InventoryVO POtoVO(InventoryPO po) throws RemoteException {
		InventoryVO vo = new InventoryVO(po.getID(),po.getA(),po.getB(),po.getC(),po.getD(),po.getEmptyOrFull());
		return vo;
	}
	@Override
	public InventoryCheckVO checkRecord(String enddate) throws RemoteException {
		ArrayList<InventoryImportReceiptPO> POs=inventoryData.showImport(enddate);
		ArrayList<InventoryImportReceiptVO> VOs = new ArrayList<InventoryImportReceiptVO>();
		//记得补充一个生成方法
		String lotNum = null;
		for(InventoryImportReceiptPO po : POs) {
			InventoryImportReceiptVO vo = POtoVO(po);
			VOs.add(vo);
		}
		InventoryCheckVO checkVO=new InventoryCheckVO(VOs,lotNum);
		return checkVO;
	}

	private InventoryImportReceiptVO POtoVO(InventoryImportReceiptPO po) throws RemoteException {
		InventoryImportReceiptVO vo = new InventoryImportReceiptVO(po.getCommoditiesID(),po.getDestination(),po.getA(),po.getB(),po.getC(),po.getD());
		return vo;
	}
	
	@Override
	public String getImportID() throws RemoteException {
		// TODO Auto-generated method stub
		String ID=inventoryData.getImportID();
		return ID;
	}

	@Override
	public InventoryImportReceiptPO addCommodities(String ArrivalListID,InventoryVO vo) throws RemoteException {
		  TransferArrivalListPO receipt=transferData.findList(ArrivalListID);
		  String ID=inventoryData.getImportID();
		  String commodities=receipt.getTransferCenterID();
		  String destination=receipt.getDestination();
		  String depture=receipt.getDeparture();
		  int a=vo.getA();
		  int b=vo.getB();
		  int c=vo.getC();
	 	  int d=vo.getD();
	 	  InventoryPO inventorypo=new InventoryPO(inventoryData.getInventoryID(),a,b,c,d,"full");
		  InventoryImportReceiptPO po=new InventoryImportReceiptPO(ID,destination,depture,commodities,a,b,c,d);
		  inventoryData.insertImport(po);
		  inventoryData.insertInventory(inventorypo);
		  return po;
		 
	}


	@Override
	public ResultMessage submitImport(InventoryImportReceiptVO importReceipt) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public String getExportID() throws RemoteException {
		String ID=inventoryData.getExportID();
		return ID;
	}
	
	@Override
	public InventoryExportReceiptPO minusCommodities(String ImportID,String Transfer) throws RemoteException {
	    InventoryImportReceiptPO importPo=inventoryData.findImport(ImportID);
		  int a=importPo.getA();
		  int b=importPo.getB();
		  int c=importPo.getC();
	 	  int d=importPo.getD();
	 	InventoryPO inventorypo=inventoryData.getInventoryPO(a,b,c,d);
		 String ID=inventoryData.getExportID();
		 String depture=importPo.getDepture(); 
		 String TransferID=inventoryData.getTransferID();
		 String destination=importPo.getDestination();
		 String Commodities=importPo.getCommoditiesID();
		 InventoryExportReceiptPO po=new InventoryExportReceiptPO(ID, destination, depture,Transfer, TransferID, Commodities, a, b, c, d);
		 inventoryData.insertExport(po);
		 inventoryData.modifyInventory(inventorypo, a, b, c, d,"empty");
		return po;
			
		
	}

	@Override
	public ResultMessage submitExport(InventoryExportReceiptVO exportReceipt) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public String getAdjustID() throws RemoteException {
		String ID=inventoryData.getImportID();
		return ID;
	}

	@Override
	public ResultMessage adjust(InventoryVO before,InventoryVO now) throws RemoteException {
		int exA = before.getA();
		int exB = before.getB();
		int exC = before.getC();
		int exD = before.getD();
		int afA = now.getA();
		int afB = now.getB();
		int afC = now.getC();
		int afD = now.getD();
		String ID=inventoryData.getImportID();
		AdjustReceiptPO po=new AdjustReceiptPO(ID,exA,exB, exC,exD, afA,afB, afC,afD);
		InventoryPO beforePO=VoToPo(before);
		InventoryPO afterPO=VoToPo(now);
		inventoryData.modifyInventory(beforePO, exA,exB,exC, exD,"empty");
		inventoryData.modifyInventory(afterPO, afA, afB,afC,afD, "full");
		inventoryData.insertAdjust(po);
		
		return ResultMessage.SUCCESS;
	   
	}
	public InventoryPO VoToPo(InventoryVO vo) throws RemoteException{
		InventoryPO po=new InventoryPO(vo.getID(), vo.getA(), vo.getB(), vo.getC(), vo.getD(), vo.getEmptyOrFull());
		return po;
		
		
	}
	

}
