package ui.specialui.manager.AdjustBase;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.baseblservice.BaseBLService;
import state.ResultMessage;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.manager.FrameManager;

import vo.BaseVO;


public class Panel_Manager_AdjustBase extends MyJPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private AddBase addBase;
	private ModifyAccountInfo modifyBase;
	private BaseInfoList baseInfo;
	private MyJButton add;
	private MyJButton modify;
	private MyJButton deleteButton;
	private MyJButton modifyButton;
	private MyJTable table;
	private BaseBLService controller = ControllerFactory.getBaseController();
	static ArrayList<BaseVO> basePool;
	static String baseID = " ";
	public Panel_Manager_AdjustBase(FrameManager frameManager) {
		
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frameManager);
		
	}
	

	private void initComponent(FrameManager frameManager) {
		this.add(new MyJLabel(530, 20, 250, 90, "公司成本常量制定", 24, true));
		addBase = new AddBase();
		this.add(addBase);
		modifyBase = new ModifyAccountInfo();
		this.add(modifyBase);
	
		basePool = new ArrayList<BaseVO>();
		baseInfo = new BaseInfoList(this);
		this.add(baseInfo);
		deleteButton = new MyJButton(150,660,180,30,"删除所选常量",16);
		deleteButton.setActionCommand("DeleteBase");
		deleteButton.addActionListener(this);
		this.add(deleteButton);
		
		modifyButton = new MyJButton(350,660,180,30,"修改所选常量信息",16);
		modifyButton.setActionCommand("ModifyBase");
		modifyButton.addActionListener(this);
		this.add(modifyButton);
	
		add = new MyJButton(880,346,120,30,"确认添加",16);	
		add.setActionCommand("CheckAdd");
		add.addActionListener(this);
		this.add(add);
		
		modify= new MyJButton(880,640,120,30,"确认修改",16);	
		modify.setActionCommand("CheckModify");
		modify.addActionListener(this);
		this.add(modify);
		this.showAll();
	}
	
private void showAll() {
	table = baseInfo.getTable();
	DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	
	int rowCount = table.getRowCount();
	
	for(int i = 0; i < rowCount; i++){
		tableModel.removeRow(0);
	}
	
	basePool.clear();
	baseID = "";
	ArrayList<BaseVO> baseVO = controller.show();
	
	for(int i = 0; i < baseVO.size(); i++){
		String[] rowData = {baseVO.get(i).cityFrom,baseVO.get(i).cityTo,baseVO.get(i).distance+"km",baseVO.get(i).price+"元/km"};
		tableModel.addRow(rowData);
		basePool.add(baseVO.get(i));
	}
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("CheckAdd")){
		String[] data = addBase.getData();
		if(data[0].equals(data[1])){
			new MyNotification(this,"出发城市和到达城市不能相同！",Color.RED);
			return;
		}
		if(addBase.getData()==null){
			new MyNotification(this,"请检查常量信息填写是否完整！",Color.RED);
		}else{
			ResultMessage rsg = controller.addBase(new BaseVO(controller.getID(),data[0],data[1],Double.parseDouble(data[2]),Double.parseDouble(data[3])));
				if(rsg.equals(ResultMessage.SUCCESS)){
					System.out.println("AddSucceed!");
					this.showAll();
					new MyNotification(this,"常量添加成功！",Color.GREEN);
			}else{
				new MyNotification(this,"常量添加失败！",Color.RED);
			}
		}
	}else if(e.getActionCommand().equals("DeleteBase")){
		table = baseInfo.getTable();
		if(table.getSelectedRowCount() == 0){
			new MyNotification(this,"请先选择要删除的常量！",Color.RED);
		}else{
			new MyNotification(this,"正在删除常量！！",Color.RED);
			this.deleteBase();
		}
	}else if(e.getActionCommand().equals("ModifyBase")){
	
		table = baseInfo.getTable();
		if(table.getSelectedRowCount() == 0){
			new MyNotification(this,"请先选择要修改常量！",Color.RED);
		}else{
			baseID = basePool.get(table.getSelectedRow()).ID;
			String[] data = new String[4];
			data[0] = basePool.get(table.getSelectedRow()).cityFrom;
			data[1] = basePool.get(table.getSelectedRow()).cityTo;
			data[2] = basePool.get(table.getSelectedRow()).distance+"";
			data[3] = basePool.get(table.getSelectedRow()).price+"";
			modifyBase.setData(data);
		}
	}else if(e.getActionCommand().equals("CheckModify")){
		table = baseInfo.getTable();
		baseID = basePool.get(table.getSelectedRow()).ID;
			if(modifyBase.getData()==null){
				new MyNotification(this,"请检查常量信息填写是否完整！",Color.RED);
			}else{
				new MyNotification(this,"正在修改常量信息！",Color.GREEN);
				this.modifyBase();
			}
	}else if(e.getActionCommand().equals("Search")){
		table = baseInfo.getTable();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int rowCount = table.getRowCount();
		
		for(int i = 0; i < rowCount; i++){
			tableModel.removeRow(0);
		}
		
		basePool.clear();
		baseID  = "";
		
		ArrayList<BaseVO> baseVO = new ArrayList<BaseVO>();
		String[] data = baseInfo.getData();
		if(data!=null){
			switch(Integer.parseInt(data[0])){
				case 0 :// baseVO = controller.show(SalaryPolicy.BYTIMES)
				case 1 ://baseVO = controller.find();break;
				case 2 : //baseVO = controller.find();break;
				default :// baseVO = controller.find();break;
			}
		
			for(int i = 0; i <baseVO.size(); i++){
			String[] rowData = {};
			tableModel.addRow(rowData);
			basePool.add(baseVO.get(i));
			System.out.println("SearchSucceed!");
				new MyNotification(this,"共有"+table.getRowCount()+"个常量满足条件！",Color.GREEN);
			}	
			}else {
				new MyNotification(this,"请输入查询的常量类型！",Color.RED);
			}
	}
	
}


	private void modifyBase() {
		table = baseInfo.getTable();
		String[] data = modifyBase.getData();
		//这里不能getID来new会出错
		ResultMessage rsg = controller.updateBase(new BaseVO(controller.getID(),data[0],data[1],Double.parseDouble(data[2]),Double.parseDouble(data[3])));
			if(rsg.equals(ResultMessage.SUCCESS)){
				System.out.println("ModifySucceed!");
				this.showAll();
				new MyNotification(this,"常量修改成功！",Color.GREEN);		
			}else{
				new MyNotification(this,"常量修改失败！",Color.RED);
			}
	
	}
	private void deleteBase() {
		table =  baseInfo.getTable();
	
		ResultMessage rsg = controller.deleteBase(basePool.get(table.getSelectedRow()).ID);
		if(rsg.equals(ResultMessage.SUCCESS)){
			System.out.println("DeleteSucceed!");
			this.showAll();
			new MyNotification(this,"常量删除成功！",Color.GREEN);
		}else{
			new MyNotification(this,"常量删除失败！",Color.RED);
		}
	
	}
}
