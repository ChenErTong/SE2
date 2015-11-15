package businesslogicservice.inventoryblservice;

import java.util.ArrayList;

import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ResultMessage;
import vo.InventoryCheckVO;
import vo.InventoryVO;
import vo.InventoryViewVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.TransferArrivalListVO;

public class InventoryBLService_Driver {


public void drive(InventoryBLService inventoryBLBLService){
	
	  int exportNumber=78;
	
	  int importNumber=98;
      ArrayList<InventoryVO> inventoryCondition = new ArrayList<InventoryVO>();
      ArrayList<InventoryImportReceiptVO> receipts=new ArrayList<InventoryImportReceiptVO>();
      String date="20151010"; 
      String lotNum="12";
	  String importDestination="上海";
	  int a=1000; int b=500; int c=250; int d=125;
	  String exportDestination="上海"; 
	  String transfer="火车";
	  String exA="1区"; 
	  String exB="1排";
	  String exC="1架";
	  String exD="1位";
	  String aftA="1区";
	  String aftB="1排";
	  String aftC="1架"; 
	  String aftD="1位";
	  String begindate="20151010";
	  String enddate="20151028";
		
		 InventoryViewVO inventoryviewvo=inventoryBLBLService.viewInventory(begindate, enddate); 
	     System.out.println("显示"+begindate+"到"+enddate+"库存盘点数据");
	
		 InventoryCheckVO inventorycheckvo=inventoryBLBLService.checkRecord();
		 System.out.println("显示截止"+enddate+"的库存快照");
		 
		 String importID=inventoryBLBLService.getImportID();
		 System.out.println("自动生成的importID");
	
		 TransferArrivalListVO transferReceipt = null;
		ResultMessage resultAdd=inventoryBLBLService.addCommodities( transferReceipt);
		 System.out.println("添加部分入库信息成功");
	   
		 InventoryImportReceiptPO inventoryimportreceipt=inventoryBLBLService.buildImport();
		 System.out.println("生成完整进货单据");
	
         InventoryImportReceiptVO importReceipt = null;
		ResultMessage resultimport=inventoryBLBLService.submitImport( importReceipt);
         System.out.println("入货单提交成功");
         
       	 String exportID=inventoryBLBLService.getExportID();
         System.out.println("自动生成的exportID");
         
	     ResultMessage resultminus =inventoryBLBLService.minusCommodities(transferReceipt) ;
	     System.out.println("添加部分出库信息成功");
	     
		 InventoryExportReceiptPO inventoryexportreceipt=inventoryBLBLService.buildExport();
		 System.out.println("生成完整出货单据");
	
	    InventoryExportReceiptVO exportReceipt = null;
		ResultMessage resulrexport=inventoryBLBLService.submitExport(exportReceipt);
	     System.out.println("出货单提交成功");

	    String adjustID=inventoryBLBLService.getAdjustID();
	     System.out.println("自动生成的adjustID");
      }

       public static void main(String[] args){
    	   int exportNumber = 0;
    		
    		  int importNumber = 0;
    	      ArrayList<InventoryVO> inventoryCondition = null;
    	      ArrayList<InventoryImportReceiptVO> receipts=new ArrayList<InventoryImportReceiptVO>();
    	      String date = null; 
    	      String lotNum = null;
    		  String importDestination = null;
    		  int a=1000; int b=500; int c=250; int d=125;
    		  String exportDestination = null; 
    		  String transfer = null;
    		  int exA = 0; 
    		  int exB = 0;
    		  int exC = 0;
    		  int exD = 0;
    		  int aftA = 0;
    		  int aftB = 0;
    		  int aftC = 0; 
    		  int aftD =0;
    		  String importID = null;
    		  String exportID = null;
    		  String adjustID = null;
    		ResultMessage resultadd = null;
    		ResultMessage resultimport = null;
    		ResultMessage resultminus = null;
    		ResultMessage resultexport = null;
    	  
		
		
		InventoryBLService_Stub inventoryblservice_stub=new InventoryBLService_Stub( exportNumber,  importNumber,inventoryCondition,
				 receipts,  date,  lotNum,  importID, exportID,
				 adjustID, resultadd, resultimport,
				 resultminus, resultexport, importDestination,
				 a, b, c, d, exportDestination,  transfer,  exA,  exB,  exC,
				 exD,  aftA, aftB,  aftC,  aftD);
	      InventoryBLService_Driver inventoryblservice_driver=new InventoryBLService_Driver();
	      inventoryblservice_driver.drive(inventoryblservice_stub);
}
}
