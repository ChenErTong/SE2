package ui.commonui.receipt_constructor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.filechooser.FileSystemView;

import businesslogic.ControllerFactory;
import businesslogicservice.receiptblservice.ReceiptBLService;
import state.ReceiptState;
import state.ReceiptType;
import ui.image.LoginImage;
import ui.myui.MyButton;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJComboBox;
import ui.myui.MyJFrame;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import vo.ValueObject;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.PaymentBillVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.RecipientConfirmReceiptVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;
/**
 * 查看草稿状态单据的详细内容 
 * @author zsq
 * @version 2015/12/02 18:47
 */
public class SaveDraftPanel extends MyJPanel implements ActionListener{
	MyButton check,export;
	MyEmptyTextArea ta;
	MyJComboBox cbb;
	ArrayList<ReceiptType> typePool;
	ArrayList<ValueObject> billPool;
	
	static ReceiptType billType;
	static ValueObject bill;
	
	public SaveDraftPanel() {
		super(0,0,1280,720);
		this.initCompoment();
	}

	private void initCompoment() {
		typePool = new ArrayList<ReceiptType>();
		billPool = new ArrayList<ValueObject>();
		this.add(new MyJLabel(530,70,300,40,"单据查看",30,true));
		
		ta = new MyEmptyTextArea(50,150,1180,550);
		ta.setEditable(false);
		
		JScrollPane jsp2 = new JScrollPane(ta);
		jsp2.setBounds(25, 40 + 50, 650, 465);
		this.add(jsp2);
		
		check = new MyButton(10,300,30,30,LoginImage.getBUTTON_LOGISTIC());
		check.setActionCommand("CheckReceipt");
		check.addActionListener(this);
		
	//	export = new MyJButton(0,430,40,130,"<html><br>导<br>出<br>单<br>据</br>",18);
	//	export.setActionCommand("ExportReceipt");
	//	export.addActionListener(this);
		
		this.add(new MyJLabel(0,0,0,0,"请选择要查看的草稿单据！",18,true));
		
		try {
			cbb = new MyJComboBox(0,0,0,0,getSaveDraft());
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
			e.printStackTrace();
		}
		this.add(cbb);
	}

	private static final long serialVersionUID = 1L;

	private String[] getSaveDraft() throws MalformedURLException, RemoteException, NotBoundException{
		String str = "";
		typePool.clear();
		billPool.clear();
		if(MyJFrame.frameName.equals("Frame_Branch")){
			ReceiptBLService receiptController = ControllerFactory.getReceiptController();
			ArrayList<BranchArrivalListVO> list;
			try {
				
				list = receiptController.show(ReceiptType.BRANCH_ARRIVAL, ReceiptState.DRAFT);
				if(list != null){
					for(int i = 0; i < list.size(); i++){
						str = str + list.get(i).ID + ";";
						typePool.add(ReceiptType.BRANCH_ARRIVAL);
						billPool.add(list.get(i));
					}
				}
			} catch (RemoteException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
			}
	
			ArrayList<DeliveryListVO> list_2;
			try {
				list_2 = receiptController.show(ReceiptType.BRANCH_DELIVER, ReceiptState.DRAFT);
				if(list_2 != null){
					for(int i = 0; i < list_2.size(); i++){
						str = str + list_2.get(i).ID + ";";
						typePool.add(ReceiptType.BRANCH_DELIVER);
						billPool.add(list_2.get(i));
					}
				}
			} catch (RemoteException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				e.printStackTrace();
			}
		
			ArrayList<LoadingListVO> list_3;
			try {
				list_3 = receiptController.show(ReceiptType.BRANCH_TRUCK, ReceiptState.DRAFT);
				if(list_3 != null){
					for(int i = 0; i < list_3.size(); i++){
						str = str + list_3.get(i).ID + ";";
						typePool.add(ReceiptType.BRANCH_TRUCK);
						billPool.add(list_3.get(i));
					}
				}
			} catch (RemoteException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				e.printStackTrace();
			}
			
			ArrayList<DebitBillVO> list_4;
			try {
				list_4 = receiptController.show(ReceiptType.DEBIT, ReceiptState.DRAFT);
				if(list_4!=null){
					for(int i = 0;i<list_4.size();i++){
						str = str+list_4.get(i).ID+";";
						typePool.add(ReceiptType.DEBIT);
						billPool.add(list_4.get(i));
					}
				}
			} catch (RemoteException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				e.printStackTrace();
			}
	
		}else if(MyJFrame.frameName.equals("Frame_Courier")){
			ReceiptBLService receiptController = ControllerFactory.getReceiptController();
			
			ArrayList<RecipientConfirmReceiptVO> list;
			try {
				list = receiptController.show(ReceiptType.CONFIRM, ReceiptState.DRAFT);
				if(list != null){
					for(int i = 0; i < list.size(); i++){
						str = str + list.get(i).ID + ";";
						typePool.add(ReceiptType.CONFIRM);
						billPool.add(list.get(i));
					}
				}
				
			} catch (RemoteException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				e.printStackTrace();
			}

			
			ArrayList<ReceiptVO> list_2;
			try {
				list_2 = receiptController.show(ReceiptType.ORDER, ReceiptState.DRAFT);
				if(list_2 != null){
					for(int i = 0; i < list_2.size(); i++){
						str = str + list_2.get(i).ID + ";";
						typePool.add(ReceiptType.ORDER);
						billPool.add(list_2.get(i));
					}
				}
			} catch (RemoteException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				e.printStackTrace();
			}
		
		}else if(MyJFrame.frameName.equals("Frame_Finance")){
			ReceiptBLService receiptController = ControllerFactory.getReceiptController();
			
			ArrayList<PaymentBillVO> list;
			try {
				list = receiptController.show(ReceiptType.PAY, ReceiptState.DRAFT);
				if(list != null){
					for(int i = 0; i < list.size(); i++){
						str = str + list.get(i).ID + ";";
						typePool.add(ReceiptType.PAY);
						billPool.add(list.get(i));
					}
				}
			} catch (RemoteException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				e.printStackTrace();
			}
			
		}else if(MyJFrame.frameName.equals("Frame_Inventory")){
			ReceiptBLService receiptController = ControllerFactory.getReceiptController();
			
			ArrayList<InventoryImportReceiptVO> list;
			try {
				list = receiptController.show(ReceiptType.INSTOCK, ReceiptState.DRAFT);
				if(list != null){
					for(int i = 0; i < list.size(); i++){
						str = str + list.get(i).ID + ";";
						typePool.add(ReceiptType.INSTOCK);
						billPool.add(list.get(i));
					}
				}
			} catch (RemoteException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				e.printStackTrace();
			}
	
			
			ArrayList<InventoryExportReceiptVO> list_2;
			try {
				list_2 = receiptController.show(ReceiptType.OUTSTOCK, ReceiptState.DRAFT);
				if(list_2 != null){
					for(int i = 0; i < list_2.size(); i++){
						str = str + list_2.get(i).ID + ";";
						typePool.add(ReceiptType.OUTSTOCK);
						billPool.add(list_2.get(i));
					}
				}
			} catch (RemoteException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				e.printStackTrace();
			}
			
		}else if(MyJFrame.frameName.equals("Frame_Transfer")){
			ReceiptBLService receiptController = ControllerFactory.getReceiptController();
			
			ArrayList<TransferArrivalListVO> list;
			try {
				list = receiptController.show(ReceiptType.TRANS_ARRIVAL, ReceiptState.DRAFT);
				if(list != null){
					for(int i = 0; i < list.size(); i++){
						str = str + list.get(i).ID + ";";
						typePool.add(ReceiptType.TRANS_ARRIVAL);
						billPool.add(list.get(i));
					}
				}
			} catch (RemoteException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				e.printStackTrace();
			}
			
			ArrayList<TransferOrderVO> list_2;
			try {
				list_2 = receiptController.show(ReceiptType.TRANS_PLANE, ReceiptState.DRAFT);
				if(list_2 != null){
					for(int i = 0; i < list_2.size(); i++){
						str = str + list_2.get(i).ID + ";";
						typePool.add(ReceiptType.TRANS_PLANE);
						billPool.add(list_2.get(i));
					}
				}
			} catch (RemoteException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				e.printStackTrace();
			}
			
			
		}
		if(typePool.size() != 0){
			return str.split(";");
		}else{
			String[] str2 = {"无"};
			return str2;
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("CheckReceipt")){
			if(cbb.getSelectedItem().toString().equals("无")){
				new MyNotification(this,"目前无单据可以查看！",Color.RED);
			}else{
				billType = typePool.get(cbb.getSelectedIndex());
				bill = billPool.get(cbb.getSelectedIndex());
				ReceiptConductor rc = new ReceiptConductor();
				ta.setText(rc.writeReceipt(billType, bill));
			}
			
		}else if(e.getActionCommand().equals("ExportReceipt")){
			if(cbb.getSelectedItem().toString().equals("无")){
				new MyNotification(this,"目前没有单据可以导出！",Color.RED);
			}else{
				FileSystemView fsv = FileSystemView.getFileSystemView();
				String file=String.valueOf(fsv.getHomeDirectory())+"/草稿单" + bill.ID + ".txt";		
				writeto(ta.getText().replaceAll("\n", "\r\n"),file);
				new MyNotification(this,"单据成功导出至桌面！",Color.GREEN);
				
			}
		}
	}
/**
 * 写入文件
 * @param a 待写入的字符串
 * @param file 写入的文件名字
 */
	private void writeto(String a, String file) {
		try {
			File filename=new File(file);
			
			if (!filename.exists()) { 
				filename.createNewFile();}
			
			FileWriter fw=new FileWriter(filename);
			fw.write(a);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
