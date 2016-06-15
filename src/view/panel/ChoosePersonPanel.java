package view.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.MapController;
import controller.PlayerController;
import util.PersonType;
import view.ViewController;
import view.panel.ChoosePersonPanel.PlayerPanel.PersonChoosePanel.PersonButton;
import mgui.MButton;

public class ChoosePersonPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon Image = new ImageIcon("picture/background/背景01.jpg");
	private Image Background = Image.getImage();
	private PersonType[] person = PersonType.values();
	private PersonLabel[] jPL = new PersonLabel[PersonType.values().length];
	private PlayerPanel[] per = new PlayerPanel[4];
	{
		for (int i = 0; i < jPL.length; i++) {
			jPL[i] = new PersonLabel(PersonType.values()[i].getImage(),
					person[i].getName());
		}
		for (int i = 0; i < per.length; i++) {
			per[i] = new PlayerPanel("PLAYER " + (i + 1));
		}
	}
	private ButtonPanel jpButton = new ButtonPanel();

	private NumberPanel numberPanel = new NumberPanel();

	public ChoosePersonPanel() {
		setLayout(null);
		add(jpButton);
		jpButton.setLocation(1050, 450);
		for (int i = 0; i < per.length; i++) {
			add(per[i]);
			per[i].setLocation(50 + 210 * i, 50);
		}
		per[2].setVisible(false);
		per[3].setVisible(false);
		for (int i = 0; i < jPL.length; i++) {
			add(jPL[i]);
			jPL[i].setLocation(920, 100);
			jPL[i].setVisible(false);

		}
		add(numberPanel);
		numberPanel.setLocation(50, 600);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Background != null) {
			g.drawImage(Background, 0, 0, getWidth(), getHeight(), this);
		}
	}

	// 此面板为确认按钮的面板
	class ButtonPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private MButton jbtYes = new MButton(100, 50, new ImageIcon(
				"picture/word/文字确定.png"), new ImageIcon(
				"picture/word/文字确定1.png"));
		private MButton jbtBack = new MButton(100, 50, new ImageIcon(
				"picture/word/文字返回.png"), new ImageIcon(
				"picture/word/文字返回1.png"));

		ButtonPanel() {
			setSize(100, 100);
			setLayout(new GridLayout(2, 0));
			super.setOpaque(false);
			add(jbtYes);
			add(jbtBack);
			jbtYes.setEnabled(false);
			jbtYes.addActionListener((e) -> {
				int number = numberPanel.getSelected();
				for (int i = 0; i < number; i++) {
					int select = per[i].getSelected();
					PlayerController.getInstance().createPlayer(
							person[select].getName(), select);
				}
				MapController.getInstance().init();
				ViewController.getInstance().showMap();
			});
			jbtBack.addActionListener((e) -> {
				ViewController.getInstance().showMenu();
			});
		}
	}

	@SuppressWarnings("serial")
	class PlayerPanel extends JPanel {
		private PerLabel pl;
		private PersonChoosePanel JPpersonChoose = new PersonChoosePanel();

		PlayerPanel(String text) {
			this.setSize(200, 500);
			pl = new PerLabel(text);
			add(pl);
			pl.setLocation(0, 0);
			add(JPpersonChoose);
			JPpersonChoose.setLocation(0, 50);
			this.setOpaque(false);

		}

		int getSelected() {
			PersonButton[] jrb = this.JPpersonChoose.jrb;
			for (int i = 0; i < jrb.length; i++) {
				if (jrb[i].isSelected())
					return i;
			}
			return -1;
		}

		class PerLabel extends JLabel {
			private static final long serialVersionUID = 1858920048404155611L;

			PerLabel(String text) {
				super(text);
				setSize(200, 50);
				this.setForeground(Color.WHITE);
				this.setFont(new Font("consolas", Font.BOLD, 40));
			}

		}

		// 选人面板
		class PersonChoosePanel extends JPanel {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			PersonButton[] jrb = new PersonButton[person.length];
			private ButtonGroup group = new ButtonGroup();

			// private int i=0;
			PersonChoosePanel() {

				setLayout(new GridLayout(0, 2));
				setSize(200, 400);
				setBorder(BorderFactory.createLineBorder(Color.WHITE));
				for (int i = 0; i < jrb.length; i++) {
					add(jrb[i] = new PersonButton(person[i].getIcon()));
					group.add(jrb[i]);
					jrb[i].setRolloverIcon(person[i].getIconSelected());
					jrb[i].setSelectedIcon(person[i].getIconSelected());
					jrb[i].addMouseListener(new MyMouseListener());
				}
				setOpaque(false);
				for (int i = 0; i < jrb.length; i++) {
					jrb[i].addActionListener((e) -> next());
				}
			}

			PersonButton getJrb(int i) {
				return jrb[i];
			}

			class MyMouseListener extends MouseAdapter {

				// 当鼠标移入不同角色按钮，显示不同角色信息
				@Override
				public void mouseEntered(MouseEvent e) {
					for (int i = 0; i < jrb.length; i++) {
						if (e.getSource() == jrb[i]) {
							showMess(i);
							break;
						}
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					for (int i = 0; i < jPL.length; i++) {
						jPL[i].setVisible(false);
					}
				}

				public void showMess(int i) {
					for (int j = 0; j < jPL.length; j++) {
						jPL[j].setVisible(false);
					}
					ChoosePersonPanel.this.jPL[i].setVisible(true);
				}
			}

			// 选人多选按钮
			class PersonButton extends JRadioButton {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				PersonButton(ImageIcon im) {
					super(im);
					setSize(100, 100);
					setOpaque(false);
					super.setBorderPainted(false);
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}

		}
	}

	class PersonLabel extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image im;
		JLabel intr;

		PersonLabel(ImageIcon im, String text) {
			setSize(240, 300);
			this.im = im.getImage();
			setBorder(BorderFactory.createLineBorder(Color.WHITE));
			intr = new JLabel(text);
			intr.setForeground(Color.WHITE);
			intr.setFont(new Font("幼圆", Font.PLAIN, 20));
			intr.setBounds(80, 205, 200, 90);
			add(intr);
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im, 20, 20, 200, 200, this);
		}
	}

	@SuppressWarnings("serial")
	class NumberPanel extends JPanel {
		private MButton[] buttons = new MButton[3];
		private int selected = 2;

		NumberPanel() {
			new GridLayout(1, 3);
			this.setSize(210, 70);
			for (int i = 0; i < buttons.length; i++) {
				buttons[i] = new MButton(70, 70);
				buttons[i].setText((i + 2) + "");
				buttons[i].setForeground(Color.WHITE);
				buttons[i].setBorderPainted(true);
				add(buttons[i]);
				int k = i;
				buttons[i].addActionListener((e) -> {
					this.selected = k + 2;
					int x = 0;
					for (; x < k + 2; x++)
						per[x].setVisible(true);
					for (; x < per.length; x++) {
						per[x].setVisible(false);
					}
					next();
				});
			}
			this.setOpaque(false);
			// buttons[0].doClick();
		}

		public int getSelected() {
			return selected;
		}

	}

	void next() {
		int number = numberPanel.getSelected();
		for (int j = 0; j < number; j++) {
			if (per[j].getSelected() < 0) {
				jpButton.jbtYes.setEnabled(false);
				break;
			}
			jpButton.jbtYes.setEnabled(true);
		}
	}

}