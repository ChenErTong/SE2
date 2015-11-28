package ui.specialui.branch_conuterman.debitNoteBuild;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.specialui.branch_conuterman.Frame_Branch;
/**
 * 收款单建立界面
 * @author czw
 * @time 2015年11月22日下午2:20:29
 */
public class DebitNoteBuild extends MyJPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField courierId;
	private MyJButton searchCourier;
	private MyEmptyTextArea courierBill;
	
	public DebitNoteBuild(Frame_Branch frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(550, 30, 210, 45, "收款单建立", 30, true));
		this.add(new MyJLabel(385, 119, 105, 21, "快递员编号", 20, true));
		
		courierId = new MyJTextField(500, 115, 250, 30);
		courierId.setOnlyInteger(9);
		this.add(courierId);
		searchCourier = new MyJButton(760, 115, 60, 30, "查询", 20);
		searchCourier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!DebitNoteBuild.this.searchCourier(courierId.getText())){
					new MyNotification(frame, "不存在该快递员", Color.RED);
				}				
			}
		});
		this.add(searchCourier);
		
		this.add(new MyJLabel(545, 190, 189, 21, "快递员当日收款信息", 18, true));
		courierBill = new MyEmptyTextArea(410, 190, 440, 405);
		this.add(courierBill);
		
		MyJButton produceDebitNote = new MyJButton(575, 630, 115, 23,
				"生成收款单", 18);
		produceDebitNote.setActionCommand("produceDebitNote");
		produceDebitNote.addActionListener(frame);
		this.add(produceDebitNote);
	}
	
	/**
	 * 清空界面上所有数据
	 */
	public void refresh(){
		courierId.setText(null);
		courierBill.setText(null);
	}
	
	/**
	 * 查询快递员
	 * @param courierId 
	 * @return
	 */
	private boolean searchCourier(String courierId) {
		// TODO
		// 根据快递员编号查找快递员
		return false;
	}
	
	/**
	 * 建立收款单
	 * @return
	 */
	public int produceDebitNote() {
		if(courierBill.getText().equals("")){
			return 1;
		}
		return 0;
	}
}