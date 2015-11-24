package ui.myui;

import java.awt.Color;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
/**
 * 下拉框
 * @author czw
 * @time 2015年11月18日上午12:04:12
 */
public class MyJComboBox extends JComboBox<String> {
	private static final long serialVersionUID = 1L;
	/**
	 * @param x 横坐标
	 * @param y 纵坐标
	 * @param width 宽度
	 * @param height 高度
	 * @param items 可选条目(首位为缺省值)
	 */
	public MyJComboBox(int x, int y, int width, int height, String[] items){
		this.setFont(new MyFont(15));
		this.setBounds(x, y, width, height);
		this.setForeground(Color.BLACK);
		for(int i = 0; i < items.length; i++){
			this.addItem(items[i]);
		}
		if(items.length > 0){
			this.setSelectedItem(items[0]);
		}	
		this.setMaximumRowCount(4);
		this.setVisible(true);
	}
	
	/**
	 * 重设选项列表中的数据
	 * @param newItem
	 */
	public void reset(String[] newItem){
		this.removeAllItems();
		for(int i = 0; i < newItem.length; i ++){
			this.addItem(newItem[i]);
		}
	}
}