package ui.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import server.RMIManage;
import ui.CommonImage;
import ui.ServerButton;
import ui.ServerLabel;
import ui.ServerPanel;

public class StartPanel extends ServerPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	/** 显示系统信息 */
	private ServerInfoPanel serverInfoPanel;

	/** 启动服务器按钮 */
	private ServerButton startBtn;
	/** 关闭服务器按钮 */
	private ServerButton stopBtn;
	
	private RMIManage server;
	
	public StartPanel() {
		super(0,0,900,506);
		this.setOpaque(false);
		this.initComponent();
		this.repaint();
		
	}
	private void initComponent(){
		server = new RMIManage();
		serverInfoPanel = new ServerInfoPanel(server.getHostAddr(), server.getHostName());
		this.add(serverInfoPanel);
		this.addStartStopButton();
		this.add(new ServerLabel(750/2,40,150,30,"服务器信息",30,true));
	}
	
	/**
	 * 添加开始和关闭按钮
	 */
	private void addStartStopButton() {
		startBtn = new ServerButton(325,257,200,60,CommonImage.getBUTTON_OPEN());
		startBtn.addActionListener(this);
		this.add(startBtn);
		stopBtn = new ServerButton(325,257+60+20,200,60,CommonImage.getCLOSE());
		stopBtn.addActionListener(this);
		this.add(stopBtn);
		stopBtn.setEnabled(false);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startBtn) {
			if (!server.isOpen()) {
				startBtn.setEnabled(false);
				stopBtn.setEnabled(true);
				stopBtn.setImage(0, CommonImage.getCLOSE());
				server.startServer(serverInfoPanel);
			}
		} else if (e.getSource() == stopBtn) {
			if (server.isOpen()) {
				startBtn.setEnabled(true);
				stopBtn.setEnabled(false);
				startBtn.setImage(0, CommonImage.getBUTTON_OPEN());
				server.stopServer();
				serverInfoPanel.setStarted(false);
			}
		}
	}
}
