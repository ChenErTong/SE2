package ui.specialui.finance.OpenningStock;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.openingstockblservice.OpeningStockBLService;
import state.ResultMessage;
import ui.image.FinanceImage.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJScrollPane;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.finance.Frame_Finance;
import vo.OpeningStockVO;
/**
 * 显示公司期初建账信息列表的Panel
 * @author zsq
 * @version 2015/11/29 14:20
 */
public class OpenningStockManage extends MyJPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private MyButton insertButton;
	private MyButton searchButton;
	
	private MyJTable transferTable,employTable,facilityTable,inventoryTable,bankAccountTable;
	
	public OpenningStockManage(Frame_Finance frame_Finance) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(530, 20, 300, 40, "公司期初建账管理", 30, true));
		this.initButton(frame_Finance);
		this.initTable();
		this.showAll();
		
	}
	
	private void initTable(){
		String[] headers = {"机构编号", "成立日期","机构类型","机构人数","机构地址","机构人员信息","仓库/转运工具信息"};
		transferTable= new MyJTable(headers,false, this);
		transferTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				OpenningStockManage.this.repaint();
			}
		});
		
		String[] headers2 = {"人员编号", " 日期","姓名","职务权限","工作时间"};
		employTable = new MyJTable(headers2,false,this);
		employTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				OpenningStockManage.this.repaint();
			}
		});
		
		String[] headers3 = {"车辆编号", "日期","车辆购入日期","车牌号","运输历史"};
		facilityTable = new MyJTable(headers3,false,this);
		facilityTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				OpenningStockManage.this.repaint();
			}
		});
		
		String[] headers4 = {"库存编号","区","排","架","位"};
		inventoryTable = new MyJTable(headers4,false,this);
		inventoryTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				OpenningStockManage.this.repaint();
			}
		});
		
		String[] headers5 = {"账户编号","日期", "账户名称", "账户金额"};
		bankAccountTable = new MyJTable(headers5,false,this);
		bankAccountTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				OpenningStockManage.this.repaint();
			}
		});
		
		MyJScrollPane jsp = new MyJScrollPane(185/2, 90-30, 1085,  512/5+16, transferTable);
		jsp.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				OpenningStockManage.this.repaint();
			}
		});
		this.add(jsp);
		
		MyJScrollPane jsp2 = new MyJScrollPane(185/2, 90+ (512/5)*1 + 10+16-30, 1085, 512/5+16, employTable);
		jsp2.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				OpenningStockManage.this.repaint();
			}
		});
		this.add(jsp2);
		
		MyJScrollPane jsp3 = new MyJScrollPane(185/2, 90 + (512/5)*2 + 20+16*2-30, 1085, 512/5+16, facilityTable);
		jsp3.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				OpenningStockManage.this.repaint();
			}
		});
		this.add(jsp3);
		
		MyJScrollPane jsp4 = new MyJScrollPane(185/2, 90 + (512/5)*3 + 30 +16*3-30,1085, 512/5+16, inventoryTable);
		jsp4.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				OpenningStockManage.this.repaint();
			}
		});
		this.add(jsp4);
		
		MyJScrollPane jsp5 = new MyJScrollPane(185/2, 90+(512/5)*4+40+16*3+10-30, 1085, 512/5+16, bankAccountTable);
		jsp5.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				OpenningStockManage.this.repaint();
			}
		});
		this.add(jsp5);
	}
	
	private void initButton(Frame_Finance frame) {
		insertButton = new MyButton(0, 150, 40, 130,
				FinanceImage.getBUTTON_ADDSTOCK());
		insertButton.addActionListener(this);
		this.add(insertButton);
		
		searchButton = new MyButton(0, 280, 40, 130,
				FinanceImage.getBUTTON_VIEWSTOCK());
		searchButton.addActionListener(this);
		this.add(searchButton);
	}
	
	/**
	 * 显示系统当前所有的期初建账历史信息
	 */
	public void showAll(){
		
		DefaultTableModel tableModel = (DefaultTableModel)transferTable.getModel();
		DefaultTableModel tableModel2 = (DefaultTableModel)employTable.getModel();
		DefaultTableModel tableModel3 = (DefaultTableModel) facilityTable.getModel();
		DefaultTableModel tableModel4 = (DefaultTableModel) inventoryTable.getModel();
		DefaultTableModel tableModel5 = (DefaultTableModel) bankAccountTable.getModel();
		
		int rowCount = transferTable.getRowCount();
		int rowCount2 = employTable.getRowCount();
		int rowCount3 = facilityTable.getRowCount();
		int rowCount4 = inventoryTable.getRowCount();
		int rowCount5 = bankAccountTable.getRowCount();
		for(int i = 0; i < rowCount; i++){
			tableModel.removeRow(0);
		}
		for(int i = 0; i < rowCount2; i++){
			tableModel2.removeRow(0);
		}
		for(int i = 0; i < rowCount3; i++){
			tableModel3.removeRow(0);
		}
		for(int i = 0; i < rowCount4; i++){
			tableModel4.removeRow(0);
		}
		for(int i = 0;i < rowCount5; i++){
			
		}
		
		try {
			OpeningStockBLService controller = ControllerFactory.getOpeningController();
			ArrayList<OpeningStockVO> openingStockVO = controller.show();
			if(openingStockVO==null){
				return;
			}
			if(openingStockVO  != null){
				for(int i = 0; i < openingStockVO.size(); i++){
					OpeningStockVO avo = openingStockVO.get(i);
				
				for(int j = 0; j < avo.transfers.size(); j++){
					Object[] rowData = {avo.transfers.get(j).getOrganizationID(), avo.date
							, avo.transfers.get(j).getOrganizationType(),avo.transfers.get(j).getNumberOfPerson(),avo.transfers.get(j).getAddress(),
							avo.transfers.get(j).getAccounts().toString(),avo.transfers.get(j).getInventories().toString()};
					tableModel.addRow(rowData);
				}
				for(int j = 0;j<avo.branchs.size();j++){
					Object[] rowData = {avo.branchs.get(j).getOrganizationID(),avo.date,avo.branchs.get(j).getOrganizationType(),avo.branchs.get(j).getNumberOfPerson(),avo.branchs.get(j).getAddress(),avo.branchs.get(j).getAccounts(),
							avo.branchs.get(j).getFacilities()};
					tableModel.addRow(rowData);
				}
				
				for(int j = 0; j < avo.accounts.size(); j++){
					Object[] rowData = {avo.accounts.get(j).getID(), avo.date, avo.accounts.get(j).getName(),
							avo.accounts.get(j).getDuty(), avo.accounts.get(j).getWorkTime()};
					tableModel2.addRow(rowData);
				}
				
				for(int j = 0; j < avo.facilities.size(); j++){
					Object[] rowData = {avo.facilities.get(j).getID(), avo.date, avo.facilities.get(j).getDate(), avo.facilities.get(j).getVehicleIdentificationNumber(), 
						avo.facilities.get(j).getDeliverHistory().toString()};
					tableModel3.addRow(rowData);
				}
				
				for(int j = 0; j < avo.inventories.size(); j++){
					Object[] rowData = {avo.inventories.get(j).getID(), avo.date, avo.inventories.get(j).getTransferID()};
					tableModel4.addRow(rowData);
				}
				
				for(int j = 0;j<avo.bankAccounts.size();j++){
					Object[] rowData = {avo.bankAccounts.get(j).getID(),avo.date,avo.bankAccounts.get(j).getName(),
							avo.bankAccounts.get(j).getMoney()};
					tableModel5.addRow(rowData);
				}
			}
}
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();ControllerFactory.init();
			return;
		}
 }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchButton){
			this.showAll();
		}else if(e.getSource()==insertButton){
			try {
				OpeningStockBLService controller = ControllerFactory.getOpeningController();
				ResultMessage rsg = controller.add();
				if(rsg.equals(ResultMessage.SUCCESS)){
					new MyNotification(this,"期初建账成功！",Color.GREEN);
					this.showAll();
				}else{
					new MyNotification(this,"期初建账失败！",Color.RED);
				}
			} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();ControllerFactory.init();
				return;
			}
		}
	}
}



