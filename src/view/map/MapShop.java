package view.map;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import bean.item.Player;
import bean.place.Shop;

//道具商店点
public class MapShop extends Map {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final ImageIcon ICON = new ImageIcon("picture/place/商店.png");
	static int[] price = { 15, 20, 20, 20, 30, 30, 35, 80, 100, 100, 120, 120,
			180, 200 };
	public MapShop() {
		super.setSize(120, 120);
		image = ICON.getImage();
		//type = new Shop();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
/*		if (type.isPHere) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(p.getIm(), 0, 0, getWidth(), getHeight(), this);
		} else {*/
			// g.drawImage(pic, 0, 0, getWidth(), getHeight(), this);
			//g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		//}
	}

	public void event(Player p) {

		/*final MFrame frame = new MFrame(p);
		if(p.isAI){
			frame.jpProp.jbClose.doClick();
		}*/
		/*
		 * final java.util.Timer timer = new java.util.Timer();
		 * timer.schedule(new TimerTask() {
		 * 
		 * @Override public void run() { // TODO Auto-generated method stub
		 * frame.dispose(); timer.cancel(); } }, 2000);
		 */
		// GloVarGUI.frame.map.change();
	}
	
	/*class PlacePanel extends JPanel {
		*//**
		 * 
		 *//*
		private static final long serialVersionUID = 1L;
		private ImageIcon ico = new ImageIcon("picture/道具背景.jpg");
		private Image im = ico.getImage();
		PropPanel[] jpProp = new PropPanel[3];
		PricePanel[] jpPrice = new PricePanel[3];
		Person p;
		BT jbF = new BT();
		BT jbN = new BT();
		int num = 0;
		final int h = 60;
		JLabel jlDial = new JLabel();
		JLabel coupon;
		CloseBt1 jbClose;
		// l.setForeground(Color.WHITE);
		// l.setFont(new Font("幼圆", Font.PLAIN, 20));
		PlacePanel(Person p, JFrame frame) {
			this.p = p;
			setLayout(null);
			jbClose = new CloseBt1(frame,p);
			add(jbClose);
			jbClose.setLocation(800, 0);
			jpProp[0] = new PropPanel(p, 0);
			jpProp[1] = new PropPanel(p, 1);
			jpProp[2] = new PropPanel(p, 2);
			jpPrice[0] = new PricePanel(0);
			jpPrice[1] = new PricePanel(1);
			jpPrice[2] = new PricePanel(2);
			for (int i = 0; i < 3; i++) {
				add(jpProp[i]);
				add(jpPrice[i]);
				jpProp[i].setLocation(0, h);
				jpProp[i].setVisible(false);
				jpPrice[i].setLocation(0, h + 128);
				jpPrice[i].setVisible(false);
			}
			jpProp[0].setVisible(true);
			jpPrice[0].setVisible(true);
			add(jbF);
			jbF.setLocation(800, h);
			jbF.setIcon(new ImageIcon("picture/道具箭头1.png"));
			jbF.setRolloverIcon(new ImageIcon("picture/道具箭头10.png"));
			jbF.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					num--;
					if (num < 0) {
						num = 2;
					}
					jpProp[0].setVisible(false);
					jpProp[1].setVisible(false);
					jpProp[2].setVisible(false);
					jpPrice[0].setVisible(false);
					jpPrice[1].setVisible(false);
					jpPrice[2].setVisible(false);
					jpProp[num].setVisible(true);
					jpPrice[num].setVisible(true);
				}
			});
			add(jbN);
			jbN.setLocation(800, h + 80);
			jbN.setIcon(new ImageIcon("picture/道具箭头2.png"));
			jbN.setRolloverIcon(new ImageIcon("picture/道具箭头20.png"));
			jbN.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					num++;
					if (num > 2) {
						num = 0;
					}
					jpProp[0].setVisible(false);
					jpProp[1].setVisible(false);
					jpProp[2].setVisible(false);
					jpPrice[0].setVisible(false);
					jpPrice[1].setVisible(false);
					jpPrice[2].setVisible(false);
					jpProp[num].setVisible(true);
					jpPrice[num].setVisible(true);
				}

			});
			add(p.prop1);
			p.prop1.setLocation(0, 350);
			jlDial.setForeground(Color.WHITE);
			jlDial.setFont(new Font("幼圆", Font.PLAIN, 20));
			jlDial.setBounds(0, 250, 800, 45);
			for (int j = 0; j < 3; j++) {
				for(int k=0;k<14;k++){
				p.prop1.jpProp[j].prop[k].addActionListener(new ButtonListener(p,k));
				}
			}
			add(jlDial);
			coupon = new JLabel(p.getCoupon() + "");
			coupon.setForeground(Color.WHITE);
			coupon.setFont(new Font("幼圆", Font.PLAIN, 20));
			coupon.setBounds(0, 0, 800, 20);
			add(coupon);
			
		}

		protected void paintComponent(Graphics g) {
			// g.setColor(new Color(206, 206, 0));
			g.setColor(Color.ORANGE);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			g.setFont(new Font("华文彩云", Font.PLAIN, 50));
			g.drawString("宝", 200, 50);
			g.drawString("具", 400, 50);
			g.drawString("店", 600, 50);
			// g.setFont(new Font("华文新魏", Font.PLAIN, 20));
			// g.drawString("获得点券" + coupon, 40, 120);
		}

		class ButtonListener implements ActionListener {
			Person p;
			int i;

			ButtonListener(Person p, int i) {
				this.i = i;
				this.p = p;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				p.setPropNum(i, -1);
				p.setCoupon(price[i] / 2);
				jlDial.setText("");
				jlDial.repaint();
				PlacePanel.this.coupon.setText(p.getCoupon() + "");
				PlacePanel.this.coupon.repaint();
			}
		}
		//显示可购买道具
		class PropPanel extends JPanel {

			*//**
			 * 
			 *//*
			private static final long serialVersionUID = 1L;
			private Person p;
			PropButton[] prop = new PropButton[14];
			{
				for (int i = 0; i < prop.length; i++) {
					prop[i] = new PropButton(new ImageIcon("picture/宝具/宝具" + i
							+ ".jpg"), new ImageIcon("picture/宝具/宝具" + i
							+ "_副本.jpg"));
				}
			}

			// private int k=0;
			PropPanel(Person p, int i) {
				this.p = p;
				setLayout(new GridLayout(1, 5));
				setSize(800, 128);
				if (i == 0) {
					for (int j = 0; j < 5; j++) {
						add(prop[j]);
					}
				} else if (i == 1) {
					for (int j = 5; j < 10; j++) {
						add(prop[j]);
					}
				} else if (i == 2) {
					setLayout(new GridLayout(1, 4));
					setSize(640, 128);
					for (int j = 10; j < 14; j++) {
						add(prop[j]);
					}
				}
				for (int k = 0; k < prop.length; k++) {
					prop[k].addActionListener(new ButtonListener(p, k));
				}
			}

			class ButtonListener implements ActionListener {
				Person p;
				int i;

				ButtonListener(Person p, int i) {
					this.i = i;
					this.p = p;
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (p.getCoupon() - price[i] >= 0) {
						PropPanel.this.p.setPropNum(i, 1);
						//System.out.println(p.getPropNum(i));
						p.setCoupon(-price[i]);
						jlDial.setText("");
						jlDial.repaint();
						PlacePanel.this.coupon.setText(p.getCoupon() + "");
						PlacePanel.this.coupon.repaint();
					} else {
						jlDial.setText("点券不足");
						jlDial.repaint();
					}
				}

			}
		}
		//用以显示道具价格
		class PricePanel extends JPanel {

			*//**
			 * 
			 *//*
			private static final long serialVersionUID = 1L;

			PricePanel(int i) {
				super.setOpaque(false);
				setLayout(new GridLayout(1, 5));
				setSize(800, 20);
				if (i == 0) {
					for (int j = 0; j < 5; j++) {
						JLabel l = new JLabel(price[j] + "点券", JLabel.CENTER);
						l.setForeground(Color.WHITE);
						l.setFont(new Font("幼圆", Font.PLAIN, 20));
						add(l);
					}
				} else if (i == 1) {
					for (int j = 5; j < 10; j++) {
						JLabel l = new JLabel(price[j] + "点券", JLabel.CENTER);
						l.setForeground(Color.WHITE);
						l.setFont(new Font("幼圆", Font.PLAIN, 20));
						add(l);
					}
				} else if (i == 2) {
					setLayout(new GridLayout(1, 4));
					setSize(640, 20);
					for (int j = 10; j < 14; j++) {
						JLabel l = new JLabel(price[j] + "点券", JLabel.CENTER);
						l.setForeground(Color.WHITE);
						l.setFont(new Font("幼圆", Font.PLAIN, 20));
						add(l);
					}
				}
			}
		}

		class BT extends MButton {
			*//**
			 * 
			 *//*
			private static final long serialVersionUID = 1L;

			BT() {
				setSize(50, 50);
				// super.setIcon(ico);
				// super.setRolloverIcon(ico1);
				// super.addActionListener(new ButtonListener());
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		}
	}

	class MFrame extends JFrame {
		*//**
		 * 
		 *//*
		private static final long serialVersionUID = 1L;
		Person p;
		PlacePanel jpProp;

		MFrame(Person p) {
			// setLayout(null);
			//super(GloVarGUI.frame,true);
			this.p = p;
			setSize(850, 500);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setUndecorated(true);
			// add(new PlacePanel(p));
			// add(scrollPane);
			// scrollPane.setLocation(130, 0);
			jpProp = new PlacePanel(p, this);
			add(jpProp);
			jpProp.setBounds(0, 0, getWidth(), getHeight());
			// jpProp.setLocation(0, 60);
			setVisible(true);
			GloVarGUI.frame.setEnabled(false);
		}
		public void dispose(){
			GloVarGUI.frame.setEnabled(true);
			super.dispose();
		}
	}
*/
}
