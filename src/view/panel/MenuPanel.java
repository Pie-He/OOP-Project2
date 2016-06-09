package view.panel;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import view.ViewController;

//����Ϊ���˵����
public class MenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon Image = new ImageIcon("picture/background/���˵�.jpg");
	private Image Background = Image.getImage();
	private ButtonPanel jpButton = new ButtonPanel();

	public MenuPanel() {
		setLayout(null);
		add(jpButton);
		jpButton.setLocation(1000, 550);

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Background != null) {
			g.drawImage(Background, 0, 0, getWidth(), getHeight(), this);
		}
	}

	class ButtonPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private MenuButton jbtStart = new MenuButton(new ImageIcon(
				"picture/word/���ֿ�ʼ��Ϸ.png"), new ImageIcon(
				"picture/word/���ֿ�ʼ��Ϸ1.png"));
		private MenuButton jbtExit = new MenuButton(new ImageIcon(
				"picture/word/�����˳���Ϸ.png"), new ImageIcon(
				"picture/word/�����˳���Ϸ1.png"));

		ButtonPanel() {
			setLayout(new GridLayout(2, 1));
			setSize(170, 100);
			add(jbtStart);
			add(jbtExit);
			jbtStart.addActionListener((e)->{
				ViewController.getInstance().showChoose();
			});
			jbtExit.addActionListener((e)->{
				System.exit(0);
			});
			super.setOpaque(false);
		}

		// �������˵����ְ�ť
		class MenuButton extends mgui.MButton {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			MenuButton(ImageIcon icon, ImageIcon rolloverIcon) {
				super(170, 50, icon, rolloverIcon);
			}
		}
	}

}