package view.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import bean.item.Player;
import bean.place.Bank;

//银行地图
public class MapBank extends MapJLabel {

	private static final ImageIcon ICON = new ImageIcon("picture/place/美刀.jpg");
	private transient Timer time;

	public MapBank() {
		super();
		super.setSize(40, 40);
		this.image = ICON.getImage();
		//type = new Bank();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/*this.imageItems.stream().forEach(i -> {
			g.drawImage(i, 0, 0, getWidth(), getHeight(), this);
		});*/
		/*
		 * if (type.isPHere) { g.drawImage(image, 0, 0, getWidth(), getHeight(),
		 * this); g.drawImage(p.getHSImage(), 0, 0, getWidth(), getHeight(),
		 * this); } else {
		 */
		// g.drawImage(pic, 0, 0, getWidth(), getHeight(), this);
		//g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		// }
	}

	// 到达银行触发事件
	public void event(Player p) {
		// public static void main(String args[]) {
		// Player p = new Saber();
		/*MFrameB frame = new MFrameB();
		PlacePanel jpPlace = new PlacePanel(p, 1, frame);
		frame.add(jpPlace);
		frame.setVisible(true);
		if (p.isAI) {
			jpPlace.jbtDraw.doClick();
			p.setCash(p.getDeposit());
			p.setDeposit(-p.getDeposit());
		}*/
	}

	// 经过银行触发事件
	public void Cross(Player p, Timer time) {
		/*this.time = time;
		MFrameB frame = new MFrameB();
		PlacePanel jpPlace = new PlacePanel(p, 2, frame);
		frame.add(jpPlace);
		frame.setVisible(true);
		if (p.isAI) {
			jpPlace.jbtDraw.doClick();
			p.setCash(p.getDeposit());
			p.setDeposit(-p.getDeposit());
		}*/
	}

/*	class PlacePanel extends JPanel {
		/**
		 * 
		 
		private static final long serialVersionUID = 1L;
		private ImageIcon ico = new ImageIcon("picture/银行背景.jpg");
		private Image im = ico.getImage();
		private Player p;
		private JLabel label = new JLabel(0 + "", JLabel.CENTER);
		private MSlider slSave;
		private MSlider slDraw;
		private CloseBt1 close1;
		private CloseBt2 close2;
		private Button jbtSave;
		Button jbtDraw;
		private JFrame frame;

		PlacePanel(final Player p, int cho, JFrame frame) {
			this.p = p;
			this.frame = frame;
			setLayout(null);
			setSize(300, 400);
			label.setForeground(Color.WHITE);
			label.setFont(new Font("幼圆", Font.PLAIN, 40));
			add(label);
			label.setBounds(50, 250, 200, 40);
			slSave = new MSlider(p.getCash());
			add(slSave);
			slSave.setBounds(0, 40, 80, 300);
			slDraw = new MSlider(p.getDeposit());
			add(slDraw);
			slDraw.setBounds(200, 40, 80, 300);
			if (cho == 1) {
				close1 = new CloseBt1(frame, p);
				add(close1);
				close1.setLocation(250, 0);
				jbtSave = new Button(new ImageIcon("picture/文字存款.png"),
						new ImageIcon("picture/文字存款1.png"), 1);
				jbtDraw = new Button(new ImageIcon("picture/文字取款.png"),
						new ImageIcon("picture/文字取款1.png"), 1);

			} else if (cho == 2) {
				close2 = new CloseBt2(frame);
				add(close2);
				close2.setLocation(250, 0);
				close2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						MapBank.this.time.start();
					}
				});
				jbtSave = new Button(new ImageIcon("picture/文字存款.png"),
						new ImageIcon("picture/文字存款1.png"), 2);
				jbtDraw = new Button(new ImageIcon("picture/文字取款.png"),
						new ImageIcon("picture/文字取款1.png"), 2);
				
				 * jbtDraw.addActionListener(new ActionListener() {
				 * 
				 * @Override public void actionPerformed(ActionEvent e) { //
				 * TODO Auto-generated method stub //如果为经过银行事件，玩家还需继续行走
				 * MapBank.this.time.start(); }
				 * 
				 * }); jbtSave.addActionListener(new ActionListener() {
				 * 
				 * @Override public void actionPerformed(ActionEvent e) { //
				 * TODO Auto-generated method stub //如果为经过银行事件，玩家还需继续行走
				 * MapBank.this.time.start(); }
				 * 
				 * });
				 
			}
			add(jbtSave);
			jbtSave.setLocation(20, 340);
			add(jbtDraw);
			jbtDraw.setLocation(200, 340);

		}

		protected void paintComponent(Graphics g) {
			// g.setColor(new Color(206, 206, 0));
			super.paintComponent(g);
			g.setColor(Color.ORANGE);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			
			 * g.setFont(new Font("华文新魏", Font.PLAIN, 40)); g.drawString("恭喜！",
			 * 50, 60); g.setFont(new Font("华文新魏", Font.PLAIN, 20));
			 * g.drawString("获得点券" + coupon, 40, 120);
			 
		}

		// 此类选择存取款金额的滑条
		class MSlider extends JSlider {
			*//**
			 * 
			 *//*
			private static final long serialVersionUID = 1L;

			MSlider(int max) {
				super(JSlider.VERTICAL);
				super.setMaximum(max);
				super.setValue(0);
				// super.setOrientation(SwingConstants.VERTICAL);
				// super.setInverted(true);
				// super.setPaintTrack(true);
				// setMajorTickSpacing(max);
				// setPaintTicks(true);
				// setPaintLabels(true);
				setInverted(true);
				setMaximum(max);
				setPaintLabels(true);
				setPaintTicks(true);
				setMajorTickSpacing(max);
				// setMinorTickSpacing(1);
				super.setOpaque(false);
				super.setFont(new Font("幼圆", Font.PLAIN, 15));
				super.setForeground(Color.white);
				addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent e) {
						label.setText(MSlider.this.getValue() + "");// 返回当前滑块值
					}

				});
			}
		}

		class Button extends MButton {
			int i;

			Button(Icon ico, Icon ico1, final int i) {
				super(80, 50);
				this.i = i;
				super.setIcon(ico);
				super.setRolloverIcon(ico1);
				super.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (e.getSource() == jbtSave) {
							p.setDeposit(slSave.getValue());
							p.setCash(-slSave.getValue());
							frame.dispose();
							if (i == 1) {
								GloVarGUI.frame.map.change(p);
							} else if (i == 2) {
								MapBank.this.time.start();
							}
						} else if (e.getSource() == jbtDraw) {
							p.setDeposit(-slDraw.getValue());
							p.setCash(slDraw.getValue());
							frame.dispose();
							if (i == 1) {
								GloVarGUI.frame.map.change(p);
							} else if (i == 2) {
								MapBank.this.time.start();
							}
						}
					}

				});
			}
		}
	}

	class MFrameB extends JFrame {
		MFrameB() {
			setSize(300, 400);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setUndecorated(true);
			// setVisible(true);
			GloVarGUI.frame.setEnabled(false);
		}

		public void dispose() {
			GloVarGUI.frame.setEnabled(true);
			super.dispose();
		}
	}*/
}

/*
 * @Override public void setPHere(Player p, boolean isPHere) { // TODO
 * Auto-generated method stub if (isPHere) { super.setHere(true); this.p = p;
 * repaint(); } else { this.p = p.rival; super.setHere(false); repaint(); } }
 */

