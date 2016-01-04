package ui.myui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

@SuppressWarnings("rawtypes")
public class MyRenderer extends JLabel implements ListCellRenderer {
	private static final long serialVersionUID = 1L;

	public MyRenderer(){
		this.setOpaque(true);
		this.setFont(new MyFont(15, true));
		this.setForeground(new Color(0, 0, 0, 0.6f));
	}
	
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		this.setText((String)value);
		if(isSelected){
			this.setBackground(new Color(210, 188, 153));
		}else{
			this.setBackground(new Color(244, 224, 193));
		}
		return this;
	}
}