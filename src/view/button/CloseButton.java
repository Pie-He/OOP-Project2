package view.button;

import igui.IButton;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

//���ݴ���dialog�������ر��¼�
@SuppressWarnings("serial")
public class CloseButton extends IButton {
	private final static ImageIcon ICO = new ImageIcon("picture/symbol/��.png");
	// private Image im = ico.getImage();
	private final static ImageIcon ICO1 = new ImageIcon("picture/symbol/��1.png");
	JDialog frame;

	// private Image im1 = ico.getImage();
	public CloseButton(JDialog dialog) {
		super(50,50,ICO,ICO1);
		//setSize(50, 50);
		this.frame = dialog;
		super.setIcon(ICO);
		super.setRolloverIcon(ICO1);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		super.addActionListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
		}
	}
}
