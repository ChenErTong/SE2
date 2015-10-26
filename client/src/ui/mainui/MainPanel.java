package ui.mainui;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import po.BranchPO;
import po.FacilityPO;
import po.TransferPO;
import po.accountpo.AccountPO;
import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.CommodityState;
import state.ConfirmState;
import state.ResultMessage;
import vo.FacilityVO;
import vo.OrderVO;
import vo.accountvo.DriverVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.TransferArrivalListVO;
import businesslogicservice.branchblservice._Branch_Stub;
import businesslogicservice.facilityblservice._Facility_Stub;
import businesslogicservice.inventoryblservice._Inventory_Stub;
import businesslogicservice.orderblservice._Order_Stub;
import businesslogicservice.transferblservice._Transfer_Stub;
import dataservice.branchdataservice._Branch_Data_Stub;
import dataservice.inventorydataservice._Inventory_Data_Stub;
import dataservice.transferdataservice._Transfer_Data_Stub;

public class MainPanel extends JPanel{

	/**
	 * default serial UID
	 */
	private static final long serialVersionUID = 1L;
	//Buttons,text of buttons and the methods which buttons call
	/**
	 * All Buttons
	 */
	JButton buttons[];
	/**
	 * Text of buttons
	 */
	ArrayList<String> buttonString=new ArrayList<>();
	/**
	 * Methods' names which buttons call
	 */
	ArrayList<String> allMethodNames=new ArrayList<>();
	
	public MainPanel(){
		//Initiate panel
		initPanel();
	}

	private void initPanel() {
		//Set layout to FlowLayout
		setLayout(new FlowLayout(FlowLayout.LEFT));
		//Read data from Config file
		getConfigFromFile();
		//Initiate buttons
		initButtons();
		//Set panel visible
		setVisible(true);
	}
	
	private void getConfigFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("tempUiConfig.txt"));
			String line="";
			//button的text
			String buttonText;
			//相应button要调用的方法名
			String methodName;
			while((line=br.readLine())!=null){
				buttonText=line.split(",")[0];
				methodName=line.split(",")[1];
				buttonString.add(buttonText);
				allMethodNames.add(methodName);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void initButtons() {
		//获得按钮的个数
		int size=buttonString.size();
		buttons = new JButton[size];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i]=new JButton();
			buttons[i].setText(buttonString.get(i));
			//添加监听类
			buttons[i].addMouseListener(new TestMethodAdapter(allMethodNames.get(i)));
			buttons[i].setVisible(true);
			this.add(buttons[i]);
		}
	}
	
	
	/**
	 * 监听类
	 * @author Ann
	 * 按钮要调用的方法名写在文件里，
	 * 按钮按下时，通过反射机制调用方法，
	 * 方法名在构造监听类时传入
	 */
	class TestMethodAdapter extends MouseAdapter{
		//方法名
		private String methodName;
		
		public TestMethodAdapter(String methodName){
			this.methodName=methodName;
		}
		/**
		 * 通过反射机制调用在MainPanel中的方法
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				//获得MainPanel引用
				MainPanel.this
				//获得MainPanel类
				.getClass()
				//根据方法名和参数列表得到相应方法（测试时参数为空）
				.getMethod(methodName, new Class[]{})
				//调用方法
				.invoke(MainPanel.this, new Object[]{});
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e1) {
				e1.printStackTrace();
			}
		}
	}
	//==============================Order==============================
	public void _Order_Driver_confirmOperation(){
		System.out.println("--------------------------------------------------");
		_Order_Stub order_Stub = new _Order_Stub();
		ConfirmState confirmState = order_Stub.confirmOperation();
		System.out.println(confirmState);
	}
	public void _Order_Driver_addOrder(){
		System.out.println("--------------------------------------------------");
		_Order_Stub order_Stub = new _Order_Stub();
		order_Stub.addOrder(new ArrayList<>(), 
				new OrderVO( "00001",
				"xiaowang", "Nanjing123", "18888888888", "SoftwareCo",
				"xiaoli", "Nanjing233", "16666666666", "HardwareCo",
				"Nanjing156-Nanjing188" , 
				"2015-10-24", "2015-10-26", 6.767));
	}
	public void _Order_Driver_updateOrder(){
		System.out.println("--------------------------------------------------");
		_Order_Stub order_Stub = new _Order_Stub();
		order_Stub.updateOrder(new ArrayList<>(), 
				new OrderVO( "00001",
				"xiaowang", "Nanjing123", "18888888888", "SoftwareCo",
				"xiaoli", "Nanjing233", "16666666666", "HardwareCo",
				"Nanjing156-Nanjing188" , 
				"2015-10-24", "2015-10-26", 6.767));
	}
	public void _Order_Driver_inquireOrder(){
		System.out.println("--------------------------------------------------");
		_Order_Stub order_Stub = new _Order_Stub();
		order_Stub.inquireOrder("00001", "xiaowang");
	}
	public void _Order_Driver_costAndTime(){
		System.out.println("--------------------------------------------------");
		_Order_Stub order_Stub = new _Order_Stub();
		OrderVO orderVO=order_Stub.inquireOrder("00001", "xiaowang");
		order_Stub.costAndTime(orderVO);
	}
	//==============================Branch==============================
	public void _Facility_Driver_confirmOperation(){
		System.out.println("--------------------------------------------------");
		_Facility_Stub facility_Stub = new _Facility_Stub();
		ConfirmState confirmState = facility_Stub.confirmOperation();
		System.out.println(confirmState);
	}

	public void _Facility_Driver_addFacility() {
		System.out.println("--------------------------------------------------");
		_Facility_Stub facility_Stub = new _Facility_Stub();
		FacilityVO facilityVO = new FacilityVO("123233", new ArrayList<>(), "Y001:2015-09-22:00008", "2015-09-22");
		ResultMessage resultMessage = facility_Stub.addFacility(facilityVO);
		System.out.println(resultMessage);
	}
	
	public void _Facility_Driver_deleteFacility() {
		System.out.println("--------------------------------------------------");
		_Facility_Stub facility_Stub = new _Facility_Stub();
		FacilityVO facilityVO = new FacilityVO("123233", new ArrayList<>(), "Y001:2015-09-22:00008", "2015-09-22");
		ResultMessage resultMessage = facility_Stub.deleteFacility(facilityVO);
		System.out.println(resultMessage);
	}
	
	public void _Facility_Driver_modifyFacility() {
		System.out.println("--------------------------------------------------");
		_Facility_Stub facility_Stub = new _Facility_Stub();
		FacilityVO facilityVO = new FacilityVO("123233", new ArrayList<>(), "Y001:2015-09-22:00008", "2015-09-22");
		ResultMessage resultMessage = facility_Stub.modifyFacility(facilityVO);
		System.out.println(resultMessage);
	}
	
	public void _Facility_Driver_findFacility() {
		System.out.println("--------------------------------------------------");
		_Facility_Stub facility_Stub = new _Facility_Stub();
		facility_Stub.findFacility("Y001:2015-09-22:00008");
	}
	
	public void _Facility_Driver_addDriver() {
		System.out.println("--------------------------------------------------");
		_Facility_Stub facility_Stub = new _Facility_Stub();
		DriverVO driverVO = new DriverVO(
				"DY001:2014-6-4:00008", "Old driver", 
				"YunNan", "1990-10-24", "731050199010247391", 
				"16868688686", 1500.0, "2years", 100);
		ResultMessage resultMessage = facility_Stub.addDriver(driverVO);
		System.out.println(resultMessage);
	}
	
	public void _Facility_Driver_deleteDriver() {
		System.out.println("--------------------------------------------------");
		_Facility_Stub facility_Stub = new _Facility_Stub();
		DriverVO driverVO = new DriverVO(
				"DY001:2014-6-4:00008", "Old driver", 
				"YunNan", "1990-10-24", "731050199010247391", 
				"16868688686", 1500.0, "2years", 100);
		ResultMessage resultMessage = facility_Stub.deleteDriver(driverVO);
		System.out.println(resultMessage);
	}
	
	public void _Facility_Driver_modifyDriver() {
		System.out.println("--------------------------------------------------");
		_Facility_Stub facility_Stub = new _Facility_Stub();
		DriverVO driverVO = new DriverVO(
				"DY001:2014-6-4:00008", "Old driver", 
				"YunNan", "1990-10-24", "731050199010247391", 
				"16868688686", 1500.0, "2years", 100);
		ResultMessage resultMessage = facility_Stub.modifyDriver(driverVO);
		System.out.println(resultMessage);
	}
	
	public void _Facility_Driver_findDriver() {
		System.out.println("--------------------------------------------------");
		_Facility_Stub facility_Stub = new _Facility_Stub();
		facility_Stub.findDriver("DY001:2014-6-4:00008");
	}
	//==============================Branch==============================
	public void _Branch_Driver_confirmOperation(){
		System.out.println("--------------------------------------------------");
		_Branch_Stub branch_Stub = new _Branch_Stub();
		ConfirmState confirmState = branch_Stub.confirmOperation();
		System.out.println(confirmState);
	}
	
	public void _Branch_Driver_getAllCommodities(){
		System.out.println("--------------------------------------------------");
		_Branch_Stub branch_Stub = new _Branch_Stub();
		branch_Stub.getAllCommodities();
	}
	
	public void _Branch_Driver_getAllOrderNumber(){
		System.out.println("--------------------------------------------------");
		_Branch_Stub branch_Stub = new _Branch_Stub();
		branch_Stub.getAllOrderNumber();
	}
	
	public void _Branch_Driver_getBranchArrivalList(){
		System.out.println("--------------------------------------------------");
		_Branch_Stub branch_Stub = new _Branch_Stub();
		branch_Stub.getBranchArrivalList("ZZ001", "Nanjing Xianlin", CommodityState.Success	, new ArrayList<>());
	}
	
	public void _Branch_Driver_getDeliveryList(){
		System.out.println("--------------------------------------------------");
		_Branch_Stub branch_Stub = new _Branch_Stub();
		branch_Stub.getDeliveryList(new ArrayList<>(), "Lao Wang");
	}
	
	public void _Branch_Driver_truckDeliver(){
		System.out.println("--------------------------------------------------");
		_Branch_Stub branch_Stub = new _Branch_Stub();
		branch_Stub.truckDeliver("Branch001", "Nanjing Gulou", "B001:2015-09-21", "Lao Wang", new ArrayList<>());
	}
	public void _Branch_Driver_insert(){
		System.out.println("--------------------------------------------------");
		_Branch_Data_Stub branch_Data_Stub = new _Branch_Data_Stub();
		BranchPO branchPO = new BranchPO("Br001", "Nanjing", "2015-6-7", new ArrayList<AccountPO>(), new ArrayList<FacilityPO>());
		branch_Data_Stub.insert(branchPO);
	}
	public void _Branch_Driver_find(){
		System.out.println("--------------------------------------------------");
		_Branch_Data_Stub branch_Data_Stub = new _Branch_Data_Stub();
		branch_Data_Stub.find("Br001");
	}
	public void _Branch_Driver_update(){
		System.out.println("--------------------------------------------------");
		_Branch_Data_Stub branch_Data_Stub = new _Branch_Data_Stub();
		BranchPO branchPO = new BranchPO("Br002", "Nanjing", "2015-6-8", new ArrayList<AccountPO>(), new ArrayList<FacilityPO>());
		branch_Data_Stub.update(branchPO);
	}
	
	//==============================Transfer==============================
	public void _Transfer_Driver_confirmOperation(){
		System.out.println("--------------------------------------------------");
		_Transfer_Stub transfer_Stub = new _Transfer_Stub();
		ConfirmState confirmState = transfer_Stub.confirmOperation();
		System.out.println(confirmState);
	}
	public void _Transfer_Driver_getAllCommodities(){
		System.out.println("--------------------------------------------------");
		_Transfer_Stub transfer_Stub = new _Transfer_Stub();
		transfer_Stub.getAllCommodities();
	}
	public void _Transfer_Driver_planeTransfer(){
		System.out.println("--------------------------------------------------");
		_Transfer_Stub transfer_Stub = new _Transfer_Stub();
		transfer_Stub.planeTransfer("CZ1903", "Nanjing", "Beijing", "LaoLi", new ArrayList<>());
	}
	public void _Transfer_Driver_truckTransfer(){
		System.out.println("--------------------------------------------------");
		_Transfer_Stub transfer_Stub = new _Transfer_Stub();
		transfer_Stub.truckTransfer("B001:2015-09-21", "Nanjing", "Beijing", "LaoLi", new ArrayList<>());
	}
	public void _Transfer_Driver_trainTransfer(){
		System.out.println("--------------------------------------------------");
		_Transfer_Stub transfer_Stub = new _Transfer_Stub();
		transfer_Stub.trainTransfer("G9703", "Nanjing", "Beijing", "LaoLi", new ArrayList<>());
	}
	public void _Transfer_Driver_receiptList(){
		System.out.println("--------------------------------------------------");
		_Transfer_Stub transfer_Stub = new _Transfer_Stub();
		transfer_Stub.receiptList("ZZ001", "Nanjing", CommodityState.Success, new ArrayList<>());
	}
	public void _Transfer_Driver_insert(){
		System.out.println("--------------------------------------------------");
		_Transfer_Data_Stub transfer_Data_Stub = new _Transfer_Data_Stub();
		TransferPO transferPO = new TransferPO("Tr001", "2015-6-7", "Nanjing", new ArrayList<>(), new ArrayList<>());
		transfer_Data_Stub.insert(transferPO);
	}
	public void _Transfer_Driver_find(){
		System.out.println("--------------------------------------------------");
		_Transfer_Data_Stub transfer_Data_Stub = new _Transfer_Data_Stub();
		transfer_Data_Stub.find("Tr001");
	}
	public void _Transfer_Driver_update(){
		System.out.println("--------------------------------------------------");
		_Transfer_Data_Stub transfer_Data_Stub = new _Transfer_Data_Stub();
		TransferPO transferPO = new TransferPO("Tr001", "2015-6-7", "Nanjing", new ArrayList<>(), new ArrayList<>());
		transfer_Data_Stub.update(transferPO);
	}
	
	//==============================Inventory==============================
	public void _Inventory_Driver_viewInventory(){
		System.out.println("--------------------------------------------------");
		_Inventory_Stub inventory_stub = new _Inventory_Stub();
		inventory_stub.viewInventory("2015-01-01", "2015-02-28");
	}
	
	public void _Inventory_Driver_checkRecord(){
		System.out.println("--------------------------------------------------");
		_Inventory_Stub inventory_stub = new _Inventory_Stub();
		inventory_stub.checkRecord();
	}
	
	public void _Inventory_Driver_getImportID(){
		System.out.println("--------------------------------------------------");
		_Inventory_Stub inventory_stub = new _Inventory_Stub();
		inventory_stub.getImportID();
	}
	
	public void _Inventory_Driver_addCommodities(){
		System.out.println("--------------------------------------------------");
		_Inventory_Stub inventory_stub = new _Inventory_Stub();
		ArrayList<String> orders = new ArrayList<String>();
		orders.add("1234567890");
		TransferArrivalListVO traVO = new TransferArrivalListVO("0123456789", "012", "Nanjing", CommodityState.Success, orders);
		inventory_stub.addCommodities(traVO);
	}
	
	public void _Inventory_Driver_buildAndSubmitImport(){
		System.out.println("--------------------------------------------------");
		_Inventory_Stub inventory_stub = new _Inventory_Stub();
		InventoryImportReceiptPO iirPO = inventory_stub.buildImport();
		InventoryImportReceiptVO iirVO = new InventoryImportReceiptVO(iirPO.getID(), iirPO.getDestination(), iirPO.getA(), iirPO.getB(), iirPO.getC(), iirPO.getD());
		inventory_stub.submitImport(iirVO);
	}
	
	public void _Inventory_Driver_getExportID(){
		System.out.println("--------------------------------------------------");
		_Inventory_Stub inventory_stub = new _Inventory_Stub();
		inventory_stub.getExportID();
	}
	
	public void _Inventory_Driver_minusCommodities(){
		System.out.println("--------------------------------------------------");
		_Inventory_Stub inventory_stub = new _Inventory_Stub();
		ArrayList<String> orders = new ArrayList<String>();
		orders.add("1234567890");
		TransferArrivalListVO receipt = new TransferArrivalListVO("0123456789", "012", "Nanjing", CommodityState.Success, orders);
		inventory_stub.minusCommodities(receipt);
	}
	
	public void _Inventory_Driver_buildAndSubmitExport(){
		System.out.println("--------------------------------------------------");
		_Inventory_Stub inventory_stub = new _Inventory_Stub();
		InventoryExportReceiptPO ierPO = inventory_stub.buildExport();
		InventoryExportReceiptVO ierVO = new InventoryExportReceiptVO(ierPO.getID(), ierPO.getDestination(), ierPO.getTransfer());
		inventory_stub.submitExport(ierVO);
	}
	
	public void _Inventory_Driver_getAdjustID(){
		System.out.println("--------------------------------------------------");
		_Inventory_Stub inventory_stub = new _Inventory_Stub();
		inventory_stub.getAdjustID();
	}
	
	public void _Inventory_Driver_Adjust(){
		System.out.println("--------------------------------------------------");
		_Inventory_Stub inventory_stub = new _Inventory_Stub();
		inventory_stub.adjust();
	}
	
	public void _Inventory_Driver_init(){
		System.out.println("--------------------------------------------------");
		_Inventory_Data_Stub inventory_Data_Stub = new _Inventory_Data_Stub();
		inventory_Data_Stub.init();
	}
	
	public void _Inventory_Driver_getSize(){
		System.out.println("--------------------------------------------------");
		_Inventory_Data_Stub inventory_Data_Stub = new _Inventory_Data_Stub();
		inventory_Data_Stub.getASize();
		inventory_Data_Stub.getBSize();
		inventory_Data_Stub.getCSize();
		inventory_Data_Stub.getDSize();
	}
	
	public void _Inventory_Driver_insertImport(){
		System.out.println("--------------------------------------------------");
		_Inventory_Data_Stub inventory_Data_Stub = new _Inventory_Data_Stub();
		@SuppressWarnings("unused")
		ResultMessage resultMessage = inventory_Data_Stub.insertImport(new InventoryImportReceiptPO("0123456789", "Shanghai", 1, 1, 1, 1));
	}
	
	public void _Inventory_Driver_insertExport(){
		System.out.println("--------------------------------------------------");
		_Inventory_Data_Stub inventory_Data_Stub = new _Inventory_Data_Stub();
		@SuppressWarnings("unused")
		ResultMessage resultMessage = inventory_Data_Stub.insertExport(new InventoryExportReceiptPO("1234567890", "Nanjing", "plane"));
	}
	
	public void _Inventory_Driver_insertAdjust(){
		System.out.println("--------------------------------------------------");
		_Inventory_Data_Stub inventory_Data_Stub = new _Inventory_Data_Stub();
		@SuppressWarnings("unused")
		ResultMessage resultMessage = inventory_Data_Stub.insertAdjust(new AdjustReceiptPO("0123456789", 1, 1, 1, 1, 2, 2, 2, 2));
	}
}