package view.map;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import bean.item.Player;
import bean.place.House;


//����Ϊ���ص�ͼ��
public class MapHouse extends MapJLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient MapLv lv = new MapLv();
	private transient RoundRectangle2D clip = new RoundRectangle2D.Double(0, 0,
			39, 39, 10, 10);
	String[] houseSell = new String[25];

	public MapHouse() {
		super.setSize(40, 40);
		//type = new House();
		//type.setLv(0);
		for (int i = 0; i < houseSell.length; i++) {
			houseSell[i] = "1";
		}
		// type.setOwner(GloVar.p1);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
/*		if (type.isPHere) {
			g.setClip(clip);
			g.drawImage(p.getImage(), 0, 0, getWidth(), getHeight(), this);
			g.setClip(null);
			g.setColor(Color.ORANGE);
			g.drawRoundRect(0, 0, 39, 39, 10, 10);
		} else {
			// g.drawImage(pic, 0, 0, getWidth(), getHeight(), this);
			if (type.getOwner() == null) {*/
				g.setColor(Color.ORANGE);
				g.drawRoundRect(0, 0, 39, 39, 10, 10);
			/*} else {
				g.setColor(Color.ORANGE);
				g.drawRoundRect(0, 0, 39, 39, 10, 10);
				g.setClip(clip);
				g.drawImage(type.owner.getHSImage(), 0, 0, getWidth(),
						getHeight(), this);
			}*/
		
	}

	/*
	 * @Override public void setPHere(Person p, boolean isPHere) { // TODO
	 * Auto-generated method stub if (isPHere) {
	 * 
	 * super.setHere(true); this.p = p; repaint(); } else { this.p = p.rival;
	 * super.setHere(false); repaint(); } }
	 */
	@Override
	public MapLv getLv() {
		// TODO Auto-generated method stub
		return lv;
	}

	@Override
	public void setLv(int i) {
		// TODO Auto-generated method stub

		lv.setLv(i);
	}

	// ���������¼�
	public void event(final Player p) {
		/*if (type.getOwner() == null) {
			if (p.getCash() - type.getInit() >= 0) {
				// �ɹ����������
				MFrame0 frame = new MFrame0();
				frame.add(new PlacePanel(p, frame, 1));
			} else {
				// �ֽ𲻹���������
				final MFrame0 frame = new MFrame0();
				// if (p.getCash() - type.getToll() >= 0) {
				frame.add(new PlacePanel(p, frame, 5));
				final java.util.Timer timer = new java.util.Timer();
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						frame.dispose();
						GloVarGUI.frame.map.change(p);
						timer.cancel();
					}
				}, 1000);
			}
		} else if (type.getOwner() == p) {
			if (!(type.getLv() == 6)) {
				if (p.getCash() - type.getInit() / 2 >= 0) {
					// �������������
					MFrame0 frame = new MFrame0();
					frame.add(new PlacePanel(p, frame, 2));
				} else {
					// �½����������������
					final MFrame0 frame = new MFrame0();
					// if (p.getCash() - type.getToll() >= 0) {
					frame.add(new PlacePanel(p, frame, 5));
					final java.util.Timer timer = new java.util.Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							frame.dispose();
							GloVarGUI.frame.map.change(p);
							timer.cancel();
						}
					}, 1000);
				}
			} else {
				// �����Ѵﶥ�����
				GloVarGUI.frame.map.change(p);
			}
		} else {
			if (p.getCash() + p.getDeposit() - type.Toll() >= 0) {
				if (p.getNoFee() == 0) {
					// ����·��
					final MFrame0 frame = new MFrame0();
					// if (p.getCash() - type.getToll() >= 0) {
					frame.add(new PlacePanel(p, frame, 3));
					type.event(p);
					final java.util.Timer timer = new java.util.Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							frame.dispose();
							GloVarGUI.frame.map.change(p);
							timer.cancel();
						}
					}, 2000);
				} else {
					// ���⸶��·�����
					final MFrame0 frame = new MFrame0();
					// if (p.getCash() - type.getToll() >= 0) {
					frame.add(new PlacePanel(p, frame, 6));
					final java.util.Timer timer = new java.util.Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							frame.dispose();
							GloVarGUI.frame.map.change(p);
							timer.cancel();
						}
					}, 2000);
					p.setNoFee(p.getNoFee() - 1);
				}
			} else {
				if (p.getNoFee() == 0) {
					// �����������֧����·��
					final MFrame0 frame = new MFrame0();
					// if (p.getCash() - type.getToll() >= 0) {
					frame.add(new PlacePanel(p, frame, 3));
					type.event(p);
					final java.util.Timer timer = new java.util.Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							frame.dispose();
							timer.cancel();
						}
					}, 2000);
				} else {
					// �⸶��·��
					final MFrame0 frame = new MFrame0();
					// if (p.getCash() - type.getToll() >= 0) {
					frame.add(new PlacePanel(p, frame, 6));
					final java.util.Timer timer = new java.util.Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							frame.dispose();
							GloVarGUI.frame.map.change(p);
							timer.cancel();
						}
					}, 2000);
					p.setNoFee(p.getNoFee() - 1);
				}
			}
		}*/
	}

	/*
	 * JFrame frame = new JFrame(); frame.setSize(500, 400); frame.add(new
	 * PlacePanel(p, frame, 2)); frame.setLocationRelativeTo(null);
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * frame.setUndecorated(true); frame.setVisible(true); } else { if
	 * (p.getCash() - type.getToll() >= 0) { JFrame frame = new JFrame();
	 * frame.setSize(500, 400); frame.add(new PlacePanel(p, frame, 3));
	 * frame.setLocationRelativeTo(null);
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * frame.setUndecorated(true); frame.setVisible(true); }else
	 * if(p.getCash()+p.getDeposit()-type.getToll()>=0){ JFrame frame = new
	 * JFrame(); frame.setSize(500, 400); frame.add(new PlacePanel(p, frame,
	 * 4)); frame.setLocationRelativeTo(null);
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * frame.setUndecorated(true); frame.setVisible(true); }else
	 * if(p.getProperty()>=type.getToll()){ JFrame frame = new JFrame();
	 * frame.setSize(500, 400); frame.add(new PlacePanel(p, frame, 5));
	 * frame.setLocationRelativeTo(null);
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * frame.setUndecorated(true); frame.setVisible(true); } }
	 */

	/*class PlacePanel extends JPanel {
		*//**
		 * 
		 *//*
		private static final long serialVersionUID = 1L;
		// Place type;
		Person p;
		// private ImageIcon[] ico = new ImageIcon[8];
		// private Image[] im = new Image[ico.length];
		private ImageIcon ico = new ImageIcon("picture/map0.jpg");
		private Image im = ico.getImage();
		
		 * { for (int i = 0; i < ico.length; i++) { ico[i] = new
		 * ImageIcon("picture/map" + i + ".jpg"); im[i] = ico[i].getImage(); } }
		 
		private ImageIcon jbIco1 = new ImageIcon("picture/���ֹ���.png");
		// private Image im = ico.getImage();
		private ImageIcon jbIco10 = new ImageIcon("picture/���ֹ���1.png");
		private ImageIcon jbIco2 = new ImageIcon("picture/��������.png");
		// private Image im = ico.getImage();
		private ImageIcon jbIco20 = new ImageIcon("picture/��������1.png");
		private CheckBt jbCheck1 = new CheckBt(jbIco1, jbIco10);
		private CheckBt jbCheck2 = new CheckBt(jbIco2, jbIco20);

		JFrame frame;
		int i;

		PlacePanel(Person p, JFrame frame, int i) {
			this.p = p;
			this.frame = frame;
			this.i = i;
			setLayout(null);
			setSize(500, 400);
			CloseBt1 jbClose = new CloseBt1(frame, p);
			// CloseBt jbClose0 = new CloseBt(frame);
			if (i == 1) {
				add(jbCheck1);
				jbCheck1.setLocation(80, 330);
				add(jbClose);
				jbClose.setLocation(450, 0);
				if (p.isAI) {
					jbCheck1.doClick();
				}

			} else if (i == 2) {
				add(jbCheck2);
				jbCheck2.setLocation(80, 330);
				add(jbClose);
				jbClose.setLocation(450, 0);
				if (p.isAI) {
					jbCheck2.doClick();
				}
			}
		}

		protected void paintComponent(Graphics g) {
			// g.setColor(Color.WHITE);
			// ���ݲ�ͬ�������ʾ��ͬ��Ϣ
			if (i == 1) {
				// ��������
				g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
				g.setColor(Color.black);
				g.setFont(new Font("������κ", Font.PLAIN, 40));
				g.drawString("��������?", 50, 60);
				// g.setColor(new Color(206, 206, 0));
				g.setFont(new Font("������κ", Font.PLAIN, 40));
				g.drawString("$" + type.getInit(), 70, 120);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 40));
				// g.setColor(Color.BLACK);
				g.drawString(type.name, 60, 180);
			} else if (i == 2) {
				// ��������
				g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
				g.setColor(Color.BLACK);
				g.setFont(new Font("������κ", Font.PLAIN, 40));
				g.drawString("��������?", 50, 60);
				// g.setColor(new Color(206, 206, 0));
				g.setFont(new Font("������κ", Font.PLAIN, 40));
				g.drawString("$" + type.getInit(), 70, 120);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 40));
				// g.setColor(Color.GRAY);
				g.drawString(type.name, 60, 180);
			} else if (i == 3) {
				// ����·��
				g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
				g.setColor(Color.black);
				g.setFont(new Font("������κ", Font.PLAIN, 40));
				g.drawString("�븶��", 50, 60);
				// g.setColor(new Color(206, 206, 0));
				g.setFont(new Font("������κ", Font.PLAIN, 40));
				g.drawString("$" + type.Toll(), 70, 120);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 40));
				// g.setColor(Color.BLACK);
				g.drawString(type.name, 60, 180);
			} else if (i == 4) {
				// �����չ�����
				g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
				g.setColor(Color.BLACK);
				g.setFont(new Font("������κ", Font.PLAIN, 40));
				g.drawString("�����չ���Щ����", 50, 60);
				// g.setColor(Color.BLACK);
				g.setFont(new Font("������κ", Font.PLAIN, 20));
				for (int k = 0; k < houseSell.length; k++) {
					g.drawString(houseSell[k], 50 + 20 * (k), 120);
				}
				g.setFont(new Font("΢���ź�", Font.PLAIN, 40));
				// g.setColor(Color.BLACK);
				// g.drawString(type.name, 60, 180);
			} else if (i == 5) {
				// �޷���������
				g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
				g.setColor(Color.BLUE);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 40));
				g.drawString("", 50, 60);
				// g.setColor(Color.BLACK);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				g.drawString("�����ʽ���", 70, 120);
				g.drawString("�޷�Ͷ��", 70, 170);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 40));
				// g.setColor(Color.BLACK);
				g.drawString(type.name, 60, 250);
			} else if (i == 6) {
				// �⸶��·��
				g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
				g.setColor(Color.BLUE);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 40));
				g.drawString("", 50, 60);
				// g.setColor(Color.BLACK);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				g.drawString("������", 70, 120);
				g.drawString("�⸶��·��", 70, 170);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 40));
				// g.setColor(Color.BLACK);
				g.drawString(type.name, 60, 250);
			} else if (i == 7) {
				// ���ع�ǿռ����
				g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
				g.setColor(Color.BLUE);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 40));
				g.drawString("", 50, 60);
				// g.setColor(Color.BLACK);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				g.drawString("���ع�����", 70, 120);
				g.drawString("������ռΪ����", 70, 170);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 40));
				// g.setColor(Color.BLACK);
				g.drawString(type.name, 60, 250);
			} else if (i == 8) {
				// ��������
				g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
				g.setColor(Color.BLUE);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 40));
				g.drawString("", 50, 60);
				// g.setColor(Color.BLACK);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 20));
				g.drawString("������ز���", 70, 120);
				g.drawString("��������", 70, 170);
				g.setFont(new Font("΢���ź�", Font.PLAIN, 40));
				// g.setColor(Color.BLACK);
				g.drawString(type.name, 60, 250);
			}
		}

		// ������������ذ�ť
		class CheckBt extends MButton {

			*//**
			 * 
			 *//*
			private static final long serialVersionUID = 1L;

			// private Image im1 = ico.getImage();
			CheckBt(Icon ico, Icon ico1) {
				super(ico, ico1);
				setSize(100, 50);
				super.setIcon(ico);
				super.setRolloverIcon(ico1);
				super.addActionListener(new ButtonListener());
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			class ButtonListener implements ActionListener {
				private int count = 0;
				Timer timer = new Timer(500, new TimerListener());

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					count = 0;
					timer.start();
					if (i == 1 || i == 2) {
						frame.dispose();
						type.event(p);
						setLv(type.getLv());
					}
				}

				private class TimerListener implements ActionListener {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						count++;
						if (count == 2) {
							GloVarGUI.frame.map.change(PlacePanel.this.p);
							timer.stop();
						}
					}

				}
			}
		}

		
		 * class CloseBt extends MButton { private ImageIcon ico = new
		 * ImageIcon("picture/��.png"); // private Image im = ico.getImage();
		 * private ImageIcon ico1 = new ImageIcon("picture/��1.png");
		 * 
		 * // private Image im1 = ico.getImage(); CloseBt() { setSize(50, 50);
		 * super.setIcon(ico); super.setRolloverIcon(ico1);
		 * super.addActionListener(new ButtonListener());
		 * setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); }
		 

	}

	// �չ�����
	public void sellHS(Person p) {
		// �������غ����صȼ�Ϊ0��������ʾ
		this.setLv(0);
		GloVarGUI.frame.map.refresh();
	}

	// ��ʾ��Щ���ؿ��չ�
	public void showSell(final Person p, String[] s) {
		for (int i = 0; i < houseSell.length; i++) {
			houseSell[i] = s[i];
		}
		final MFrame0 frame = new MFrame0();
		frame.add(new PlacePanel(p, frame, 4));
		final java.util.Timer timer = new java.util.Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				frame.dispose();
				GloVarGUI.frame.map.change(p);
				timer.cancel();
			}
		}, 2000);
	}

	// ������������
	public void changeOwner(Person p, int i) {
		p.setHousePP(GloVar.Map[p.getStep()].type.getPrice());
		if (this.type.getOwner() == p.rival) {
			p.rival.setHousePP(-GloVar.Map[p.getStep()].type.getPrice());
		} else if (this.type.getOwner() == p) {

		} else {
			this.setLv(1);
			type.setLv(1);
		}
		this.type.setOwner(p);
		if (i == 1) {
			// ǿ����
			p.setCash(-GloVar.Map[p.getStep()].type.getPrice());
		}
		this.repaint();
		if (i == 1) {
			final MFrame0 frame = new MFrame0();
			// if (p.getCash() - type.getToll() >= 0) {
			frame.add(new PlacePanel(p, frame, 8));
			final java.util.Timer timer = new java.util.Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					frame.dispose();
					timer.cancel();
				}
			}, 1000);
		} else if (i == 2) {
			final MFrame0 frame = new MFrame0();
			// if (p.getCash() - type.getToll() >= 0) {
			frame.add(new PlacePanel(p, frame, 7));
			final java.util.Timer timer = new java.util.Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					frame.dispose();
					timer.cancel();
				}
			}, 1000);
		}
	}
}

class MFrame0 extends JFrame {
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;

	MFrame0() {
		// super(GloVarGUI.frame,false);
		GloVarGUI.frame.setEnabled(false);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);

		// setModal(true);
	}

	public void dispose() {
		GloVarGUI.frame.setEnabled(true);
		super.dispose();

	}*/
}
