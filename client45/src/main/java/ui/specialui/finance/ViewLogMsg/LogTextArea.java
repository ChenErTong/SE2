package ui.specialui.finance.ViewLogMsg;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
/**
 * 负责显示系统log日志的滚动条区域
 * @author zsq
 * @version 2015/12/5 17:00
 */
public class LogTextArea extends JScrollPane{
	private static final long serialVersionUID = 1L;
	
	/** 真正的TextArea在这 */
	private JTextArea textArea;

	//	/** 边框标题 */
	//	private String title;

	public LogTextArea() {
		this.setOpaque(false);	// 将JScrollPane设置为透明
		this.getViewport().setOpaque(false);	// 将中间的viewport设置为透明
		this.addMouseWheelListener(new WheelListener()); // 设置鼠标滚轮监听
		this.addTextArea();	// 添加文本域
		this.setBorder();	// 设置边框
		this.modifyScrollBar();	// 修改滚动条样式
	}

	private void modifyScrollBar() {
		JScrollBar bar = this.getVerticalScrollBar();
		bar.setBackground(Color.LIGHT_GRAY);
		bar.setOpaque(false);
		bar.setBorder(new EmptyBorder(0, 0, 0, 0));
	}

	private void addTextArea() {
		textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		// 最新的在前面显示
	/*	for(int i = 0; i < LogMsgController.getCurLogs().size(); i++) {
			LogMessage log = LogMsgController.getCurLogs().get(i);
			textArea.append(log.toString() + "\r\n");
		}*/
		textArea.setLineWrap(true);
		textArea.setFont(getFont());
		textArea.setOpaque(false);
		textArea.setEditable(false);
		this.setViewportView(textArea);
	}

	private void setBorder() {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// title = sdf.format(new Date()); // 初始化标题为当前日期
		this.setBorder(null);
		// this.setBorder(BorderFactory.createTitledBorder(null, title, TitledBorder.CENTER, TitledBorder.TOP, LogUIConfig.TEXT_FONT));
	}

	public void setTitle(String title) {
		// this.title = title;
		this.setBorder(null);
		// this.setBorder(BorderFactory.createTitledBorder(getBorder(), title, TitledBorder.CENTER, TitledBorder.TOP, LogUIConfig.TEXT_FONT));
		this.repaint();
	}

	/**
	 * 将存放在ArrayList里的LogMessage显示在TextArea中
	 */
	@SuppressWarnings("rawtypes")
	public void append(ArrayList logs) {
		if (logs == null) {
			return;
		}
		//for(LogMessage log : logs) {
			//textArea.append(log.toString() + "\r\n");
		//}
	}

	public void append(String text) {
		textArea.append(text);
	}

	public void setText(String text) {
		textArea.setText(text);
	}

	private class WheelListener implements MouseWheelListener {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			JScrollBar onlineFriendsBar = LogTextArea.this.getVerticalScrollBar();
			if (!((onlineFriendsBar.getValue() == onlineFriendsBar.getMinimum() && e.getWheelRotation() <= 0) || (onlineFriendsBar.getValue() == onlineFriendsBar.getMaximum() && e.getWheelRotation() >= 0))) {
				if (onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement() * e.getUnitsToScroll() * 2 >= onlineFriendsBar.getMaximum()) {
					onlineFriendsBar.setValue(onlineFriendsBar.getMaximum());
				} else if (onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement() * e.getUnitsToScroll() * 2 <= onlineFriendsBar.getMinimum()) {
					onlineFriendsBar.setValue(onlineFriendsBar.getMinimum());
				} else {
					onlineFriendsBar.setValue(onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement()
												* e.getUnitsToScroll() * 10);
				}
			}
		}
	}
}
