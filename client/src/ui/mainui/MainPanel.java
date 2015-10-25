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

import businesslogicservice.facilityblservice._Facility_Stub;
import businesslogicservice.orderblservice._Order_Stub;
import state.ConfirmState;
import state.ResultMessage;
import vo.FacilityVO;
import vo.OrderVO;
import vo.accountvo.DriverVO;

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
	public void _Order_Driver_confirmOperation(){
		System.out.println("--------------------------------------------------");
		_Order_Stub order_Stub = new _Order_Stub();
		ConfirmState confirmState = order_Stub.confirmOperation();
		System.out.println(confirmState);
	}
	public void _Order_Driver_addOrder(){
		System.out.println("--------------------------------------------------");
		_Order_Stub order_Stub = new _Order_Stub();
		@SuppressWarnings("unused")
		ResultMessage rMessage = order_Stub.addOrder(new ArrayList<>(), 
				new OrderVO( "00001",
				"xiaowang", "Nanjing123", "18888888888", "SoftwareCo",
				"xiaoli", "Nanjing233", "16666666666", "HardwareCo",
				"Nanjing156-Nanjing188" , 
				"2015-10-24", "2015-10-26", 6.767));
	}
	public void _Order_Driver_inquireOrder(){
		System.out.println("--------------------------------------------------");
		_Order_Stub order_Stub = new _Order_Stub();
		@SuppressWarnings("unused")
		OrderVO orderVO=order_Stub.inquireOrder("00001", "xiaoli");
	}
	public void _Order_Driver_costAndTime(){
		System.out.println("--------------------------------------------------");
		_Order_Stub order_Stub = new _Order_Stub();
		OrderVO orderVO=order_Stub.inquireOrder("00000", "xiaoli");
		@SuppressWarnings("unused")
		ResultMessage rMessage = order_Stub.costAndTime(orderVO);
	}
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
		@SuppressWarnings("unused")
		FacilityVO facilityVO = facility_Stub.findFacility("Y001:2015-09-22:00008");
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
		@SuppressWarnings("unused")
		DriverVO driverVO =  facility_Stub.findDriver("DY001:2014-6-4:00008");
	}
	
}
