package ui.specialui.courier;

import ui.image.CourierImage;
import ui.myui.MyButton;
import ui.myui.MyJPanel;
import ui.myui.MyLogo;
import ui.myui.MyTitle;
/**
 * 快递员主界面
 * @author czw
 * @time 2015年11月15日下午10:38:11
 */
public class Panel_Courier_Total extends MyJPanel{
	private static final long serialVersionUID = 1L;

	public Panel_Courier_Total(Frame_Courier frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		MyLogo.setLogo(this);
		MyTitle.setTitle(this, "快递员界面", 510, 120, 251, 58);
		
		this.initComponent(frame);
	}
	private void initComponent(Frame_Courier frame){
		MyButton OrderInput = new MyButton(511, 360, 257, 46, CourierImage.getBUTTON_DINGDAN());
		OrderInput.setActionCommand("OrderInput");
		OrderInput.addActionListener(frame);
		this.add(OrderInput);
		
		MyButton ReceiveInput = new MyButton(511, 460, 257, 46, CourierImage.getBUTTON_SHOUJIAN());
		ReceiveInput.setActionCommand("ReceiveInput");
		ReceiveInput.addActionListener(frame);
		this.add(ReceiveInput);
		
		MyButton TimeCostManager = new MyButton(511, 560, 257, 46, CourierImage.getBUTTON_BAOJIASHIJIAN());
		TimeCostManager.setActionCommand("TimeCostManager");
		TimeCostManager.addActionListener(frame);
		this.add(TimeCostManager);
	}
}