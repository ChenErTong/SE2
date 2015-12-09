package ui.specialui.manager.AdjustBase;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.baseblservice.BaseBLService;
import state.ResultMessage;
import ui.image.ManagerImage;
import ui.image.FinanceImage.BankAccountImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.manager.FrameManager;
import vo.BaseVO;

/**
 * 负责公司常量管理中所有操作Panel的转换
 * @author zsq
 * @version 2015/12/5 13:30
 */
public class AdjustBase extends MyJPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private AddBase addBase;
	private ModifyAccountInfo modifyBase;
	private SearchBaseInfo baseInfo;
	private MyButton add;
	private MyButton modify;
	private MyButton deleteButton;
	private MyButton modifyButton;
	private MyJTable table;
	private BaseBLService controller = ControllerFactory.getBaseController();

	static ArrayList<BaseVO> basePool;
	static String baseID = " ";
	
	public AdjustBase(FrameManager frameManager) {
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
		baseInfo = new SearchBaseInfo(this);
		this.add(baseInfo);
		deleteButton = new MyButton(150,660,150,40,ManagerImage.getBUTTON_DELETEBASE());
		deleteButton.setActionCommand("DeleteBase");
		deleteButton.addActionListener(this);
		this.add(deleteButton);
		
		modifyButton = new MyButton(350,660,150,40,ManagerImage.getBUTTON_MODIFYBASE());
		modifyButton.setActionCommand("ModifyBase");
		modifyButton.addActionListener(this);
		this.add(modifyButton);
	
		add = new MyButton(880,346,120,30,BankAccountImage.getBUTTON_ADD());	
		add.setActionCommand("CheckAdd");
		add.addActionListener(this);
		this.add(add);
		
		modify= new MyButton(880,640,120,30,ManagerImage.getBUTTON_CONFIRMMODIFY());	
		modify.setActionCommand("CheckModify");
		modify.addActionListener(this);
		this.add(modify);
		this.showAll();
	}
	/**
	 * 显示所有的常量信息
	 */
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
			if(addBase.getData()==null){
				new MyNotification(this,"请检查常量信息填写是否完整！",Color.RED);
			}
			if(this.isTheSameCity(data)){
				new MyNotification(this,"出发城市和到达城市不能相同！",Color.RED);
			}
			if((!this.isLegal(data[3]))||(!this.isLegal(data[2]))){
				new MyNotification(this,"输入的距离和单价不合法！",Color.RED);
			}else{
				ResultMessage rsg = controller.addBase(new BaseVO(controller.getID(),data[0],data[1],new BigDecimal(data[2]),new BigDecimal(data[3])));
				if(rsg.equals(ResultMessage.SUCCESS)){
					this.showAll();
					addBase.refresh();
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
			
			//ArrayList<BaseVO> baseVO = new ArrayList<BaseVO>();
		//	String[] data = baseInfo.getData();
			String data = baseInfo.getData();
			if(data!=null){
				/*switch(Integer.parseInt(data[0])){
					case 0 :// baseVO = controller.show(SalaryPolicy.BYTIMES)
					case 1 ://baseVO = controller.find();break;
					case 2 : //baseVO = controller.find();break;
					default :// baseVO = controller.find();break;
				}*/
				
				BaseVO baseVO = controller.find(data);
				String [] rowData = {baseVO.cityFrom,baseVO.cityTo,baseVO.distance+"",baseVO.price+""};
				tableModel.addRow(rowData);
				basePool.add(baseVO);
			
			/*	for(int i = 0; i <baseVO.size(); i++){
				String[] rowData = {};
				tableModel.addRow(rowData);
				basePool.add(baseVO.get(i));
				System.out.println("SearchSucceed!");
					new MyNotification(this,"共有"+table.getRowCount()+"个常量满足条件！",Color.GREEN);
				}	*/
				}else {
					new MyNotification(this,"请输入查询的常量ID！",Color.RED);
				}
		}
	}

	private void modifyBase() {
		table = baseInfo.getTable();
		String[] data = modifyBase.getData();

		if(modifyBase.getData()==null){
			new MyNotification(this,"请检查常量信息填写是否完整！",Color.RED);
		}
		if(this.isTheSameCity(data)){
			new MyNotification(this,"出发城市和到达城市不能相同！",Color.RED);
		}
		if((!this.isLegal(data[3]))||(!this.isLegal(data[2]))){
			new MyNotification(this,"输入的距离和单价不合法！",Color.RED);
		}else{
			ResultMessage rsg = controller.updateBase(new BaseVO(basePool.get(table.getSelectedRow()).ID,data[0],
					data[1],new BigDecimal(data[2]),new BigDecimal(data[3])));
			if(rsg.equals(ResultMessage.SUCCESS)){
				System.out.println("ModifySucceed!");
				this.showAll();
				modifyBase.refresh();
				new MyNotification(this,"常量修改成功！",Color.GREEN);		
			}else{
				new MyNotification(this,"常量修改失败！",Color.RED);
			}
		}
	}
	private void deleteBase() {
		table =  baseInfo.getTable();
		
		ResultMessage rsg = controller.deleteBase(basePool.get(table.getSelectedRow()).ID);
		if(rsg.equals(ResultMessage.SUCCESS)){
			System.out.println("DeleteSucceed!");
			this.showAll();
			this.repaint();
			new MyNotification(this,"常量删除成功！",Color.GREEN);
		}else{
			new MyNotification(this,"常量删除失败！",Color.RED);
		}
	}
	/**
	 * 判断出发城市和到达城市是否相同
	 * @param data
	 * @return 是否相同
	 */
	private boolean isTheSameCity(String[] data){
		if(data[0].equals(data[1])){
			return true;
		}
		return false;
	}

	/**
	 * 判断输入的距离、单价是否合法
	 * @param num
	 * @return true为合法，false为不合法
	 */
	private boolean isLegal (String num){
		
		try{
			if(BigDecimal.valueOf(Double.parseDouble(num)).compareTo(BigDecimal.ZERO)<0){
				return false;
			}
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
}
