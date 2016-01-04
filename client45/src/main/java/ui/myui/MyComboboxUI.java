package ui.myui;

import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class MyComboboxUI extends BasicComboBoxUI {
	
	// 隐藏下拉按钮
	protected JButton createArrowButton() {
		JButton button = new JButton() {
			private static final long serialVersionUID = 1L;

			// 不绘画任何图案
			public void paint(Graphics g) {
			}
		};
		return button;
	}

	/**
	 * 隐藏滚动条
	 */
	protected ComboPopup createPopup() {
		BasicComboPopup popup = new BasicComboPopup(comboBox) {
			private static final long serialVersionUID = 1L;;

			protected JScrollPane createScroller() {
				JScrollPane jsp = new JScrollPane(list,
						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				jsp.getVerticalScrollBar().setUI(null);
				return jsp;
			}
		};
		return popup;
	}
}