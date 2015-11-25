package ui.specialui.manager.HandleReceipt;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import businesslogic.receiptbl.ReceiptController;
import state.ReceiptType;
import state.ResultMessage;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.manager.FrameManager;
import vo.ValueObject;
import vo.receiptvo.ReceiptVO;
/**
 * 处理单据的总Panel
 * @author zsq
 * @time 2015/11/18 23:58
 */
public class Panel_Manager_HandleReceipt extends MyJPanel {
	private static final long serialVersionUID = 1L;
	private ReceiptController receiptController;
	private Panel_Manager_SearchReceipt searchPanel;
	private Panel_Manager_ReceiptInfo receiptInfo;
	
	static ArrayList<ValueObject> listPool;
	static ArrayList<ReceiptType> typePool;
	static int index = -1;
	ArrayList<ValueObject> passList;
	ArrayList<ReceiptType> passType;
	
	private MyJButton ViewReceiptInfo;
	private MyJButton PassSelectedReceipts;
	private MyJButton ModifyReceiptInfo;
	private MyJButton PassThisReceipt;
	private MyJButton DontPassThisReceipt;
	private MyJButton ExportReceipt;
	public Panel_Manager_HandleReceipt(FrameManager frame_Manager) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Manager);
		listPool = new ArrayList<ValueObject>();
		typePool = new ArrayList<ReceiptType>();
		
		passList = new ArrayList<ValueObject>();
		passType = new ArrayList<ReceiptType>();
	}
	
	private void initComponent(FrameManager frame_Manager) {
		this.add(new MyJLabel(550, 20, 210, 90, "公司运营单据处理", 24, true));
		searchPanel = new Panel_Manager_SearchReceipt();
		this.add(searchPanel);
		
		receiptInfo = new Panel_Manager_ReceiptInfo();
		this.add(receiptInfo);

		this.initButton(frame_Manager);	
		
		index = -1;
	}
	
	private void initButton(FrameManager frame_Manager){
		ViewReceiptInfo = new MyJButton(85, 650, 150, 40,"查看当前所选单据",14);
		ViewReceiptInfo.setActionCommand("ViewReceiptInfo");
		ViewReceiptInfo.addActionListener(frame_Manager);
		this.add(ViewReceiptInfo);
		ViewReceiptInfo.setVisible(true);
		
		PassSelectedReceipts = new MyJButton(255, 650, 150, 40,"通过所有选中单据",14);
		PassSelectedReceipts.setActionCommand("PassSelectedReceipts");
		PassSelectedReceipts.addActionListener(frame_Manager);
		this.add(PassSelectedReceipts);
		PassSelectedReceipts.setVisible(true);
		
		ModifyReceiptInfo = new MyJButton(425, 650, 150, 40,"修改单据内容",14);
		
		ModifyReceiptInfo.setActionCommand("ModifyReceiptInfo");
		ModifyReceiptInfo.addActionListener(frame_Manager);
		this.add(ModifyReceiptInfo);
		ModifyReceiptInfo.setVisible(true);
		
		PassThisReceipt = new MyJButton(705,650,150,40,"通过此单据",14);
		PassThisReceipt.setActionCommand("PassThisReceipt");
		PassThisReceipt.addActionListener(frame_Manager);
		this.add(PassThisReceipt);
		PassThisReceipt.setVisible(true);
		
		DontPassThisReceipt = new MyJButton(875, 650, 150, 40,"不通过此单据",14);
		DontPassThisReceipt.setActionCommand("DontPassThisReceipt");
		DontPassThisReceipt.addActionListener(frame_Manager);
		this.add(DontPassThisReceipt);
		
		ExportReceipt = new MyJButton(1045, 650, 150, 40,"导出单据",14);
		ExportReceipt.setActionCommand("ExportReceipt");
		ExportReceipt.addActionListener(frame_Manager);
		this.add(ExportReceipt);
	}
	
	public void actionPerformed(ActionEvent events){
		if(events.getSource()==DontPassThisReceipt){
			receiptController = new ReceiptController();
			ArrayList<ReceiptVO> dontPassList = new ArrayList<ReceiptVO>();
			ReceiptType dontPassType = ReceiptType.BRANCH_ARRIVAL;
			
			dontPassList.add((ReceiptVO) listPool.get(index));
			//TODO 要改接口吗orz
			//ResultMessage resultMsg = receiptController.dontPassReceipt(dontPassList,dontPassType);
			/*if(resultMsg.equals(ResultMessage.FAILURE)){
				this.add(new MyNotification());
			}else{
				//进行查询搜索
				 this.add(new MyNotification());
			}*/
		}
		//if(events.getSource()==)
	}

}
