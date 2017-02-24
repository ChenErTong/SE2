package ui.specialui.manager.HandleReceipt;

import javax.swing.table.DefaultTableModel;

public class ReceiptTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	
	String[] header = {"选择","单据种类","单据编号","通过状态" }; 
	
	public ReceiptTableModel(){
		this.setDataVector(null, header); 
	}
	
	public boolean isCellEditable(int row, int column) { 
		if(column != 0){
			return false;
		}else{
			return true;
		}
	}

    @SuppressWarnings("rawtypes")
	Class[] typeArray={Boolean.class, Object.class,Object.class,Object.class};  
  
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int columnIndex) {  
        return typeArray[columnIndex];// 返回每一列的数据类型  
    }
}
 