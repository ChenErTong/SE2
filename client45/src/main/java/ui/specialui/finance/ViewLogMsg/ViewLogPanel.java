package ui.specialui.finance.ViewLogMsg;

import ui.myui.MyJPanel;
import ui.myui.MyJTextField;
import ui.specialui.finance.Frame_Finance;
import ui.specialui.manager.FrameManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
@SuppressWarnings("unused")
public class ViewLogPanel extends MyJPanel{
	private DateLabel[] dateLabel;
	private MyJTextField[] input;
	private Point inPanelPoint = new Point(0,25);
	public ViewLogPanel(Frame_Finance frame_Finance) {
		super(0, 25, 1280, 720-25);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}

	private void initComponent(Frame_Finance frame_Finance) {
		
		
		
	}

	private static final long serialVersionUID = 1L;
	class DateLabel extends JLabel {

		/** serialVersionUID */
		private static final long serialVersionUID = 11733136455717335L;

		public DateLabel(String Text) {
			super(Text, JLabel.LEFT);
			this.setFont(getFont());
		}
	}
}
