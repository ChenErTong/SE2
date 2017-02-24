package ui.commonui.receipt_constructor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;

public class SaveDraft extends MyJFrame implements ActionListener{

	private SaveDraftPanel savePanel;
	private MyJPanel subPanel;
	public SaveDraft(String userID) {
		super(userID);
		savePanel = new SaveDraftPanel();
		this.add(savePanel);
		this.returnButton.addActionListener(this);
		this.setBackground(CommonImage.BACKGROUND);
		
	}

	private static final long serialVersionUID = 1L;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("return")){
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				savePanel.setVisible(true);
			}
		}
	}

}
