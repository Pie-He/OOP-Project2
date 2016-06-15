package view.label;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import util.PersonType;
import mgui.MButton;
import bean.item.Player;

//����Ϊ������Ϣ��ʾlabel����������ʹ�ü�����ʹ��
public class PlayerMessLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TitledBorder border = new TitledBorder(
			BorderFactory.createLineBorder(Color.WHITE), "������Ϣ");
	private Player p = new Player();
	MessLabel mess = new MessLabel();
	public PButton jbProp;
	public SButton jbSkill;
	int i = 0;

	public PlayerMessLabel(Player p) {
		this.p = p;
		setLayout(null);
		setSize(300, 400);
		border.setTitleColor(Color.white);
		setBorder(border);
		add(mess);
		mess.setLocation(20, 250);
		jbProp = new PButton(p);
		add(jbProp);
		jbProp.setLocation(20, 205);
		jbSkill = new SButton(p);
		add(jbSkill);
		jbSkill.setLocation(160, 205);
	}

	public void resetP(Player p) {
		this.p = p;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon image1 = p.getType().getImage();
		ImageIcon image2 = p.getType().getNameImage();
		if (image1 != null) {
			g.drawImage(image1.getImage(), 20, 20, 180, 180, this);
			g.drawImage(image2.getImage(), 220, 20, 60, 180, this);
		}
	}

	class MessLabel extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private mLabel jl1 = new mLabel(p.getCash() + "", JLabel.RIGHT);
		private mLabel jl2 = new mLabel(p.getDeposit() + "", JLabel.RIGHT);
		private mLabel jl3 = new mLabel(p.getHouseProperty() + "", JLabel.RIGHT);
		private mLabel jl4 = new mLabel(p.getCoupon() + "", JLabel.RIGHT);
		private mLabel jl5 = new mLabel(p.getProperty() + "", JLabel.RIGHT);

		MessLabel() {
			setLayout(new GridLayout(5, 2));
			setSize(260, 150);
			add(new mLabel("�ֽ�"));
			add(jl1);
			add(new mLabel("���"));
			add(jl2);
			add(new mLabel("����"));
			add(jl3);
			add(new mLabel("��ȯ"));
			add(jl4);
			add(new mLabel("�ʲ�"));
			add(jl5);

		}

		class mLabel extends JLabel {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			mLabel(String s) {
				super(s);
				setForeground(Color.WHITE);
				setFont(new Font("��Բ", Font.PLAIN, 20));
			}

			mLabel(String s, int alignment) {
				super(s, alignment);
				setForeground(Color.WHITE);
				setFont(new Font("��Բ", Font.PLAIN, 20));
			}
		}

		void refresh() {
			jl1.setText(p.getCash() + "");
			jl2.setText(p.getDeposit() + "");
			jl3.setText(p.getHouseProperty() + "");
			jl4.setText(p.getCoupon() + "");
			jl5.setText(p.getProperty() + "");
			jl1.repaint();
			jl2.repaint();
			jl3.repaint();
			jl4.repaint();
			jl5.repaint();

		}
	}

	public void refresh() {
		mess.refresh();
	}

	// �������ʹ�ð�ť
	public class PButton extends MButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public Listener listener = new Listener();

		PButton(Player p) {
			setSize(125, 45);
			setIcon(new ImageIcon("picture/word/���ֵ���.png"));
			setRolloverIcon(new ImageIcon("picture/word/���ֵ���1.png"));
			super.addActionListener(listener);
		}

		public class Listener implements ActionListener {
			// public MFrame frame;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// frame = new MFrame(PlayerMessLabel.this.p);
			}
		}
	}

	// ���弼��ʹ�ð�ť
	class SButton extends MButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Player p;

		SButton(Player p) {
			this.p = p;
			setSize(125, 45);
			setIcon(new ImageIcon("picture/word/���ֹ�Ʊ.png"));
			setRolloverIcon(new ImageIcon("picture/word/���ֹ�Ʊ1.png"));
		}
	}

	/*
	 * public class MFrame extends JFrame { /**
	 */
	/*
	 * private static final long serialVersionUID = 1L; PropPanel prop; Player
	 * p;
	 * 
	 * MFrame(Player p) { // super(GloVarGUI.frame,true);
	 * //GloVarGUI.frame.setEnabled(false); this.p = p; setSize(850, 250);
	 * setLocationRelativeTo(null);
	 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setUndecorated(true);
	 * prop = new PropPanel(p); add(prop); prop.setLocation(0, 0);
	 * setVisible(true); }
	 * 
	 * public void dispose() { //GloVarGUI.frame.setEnabled(true);
	 * super.dispose(); }
	 * 
	 * // ��ʾ�����б� class PropPanel extends JPanel { /**
	 */
	/*
	 * private static final long serialVersionUID = 1L; //CloseBt2 close = new
	 * CloseBt2(MFrame.this); private ImageIcon Icon0 = new
	 * ImageIcon("picture/�ҵĵ��߱���.jpg"); private Image im = Icon0.getImage();
	 * Player p; IntrLabel jlIntr = new IntrLabel();
	 * 
	 * PropPanel(Player p) { this.p = p; setLayout(null); setSize(850, 250);
	 * add(p.prop);s p.prop.setLocation(0, 102); add(close);
	 * close.setLocation(800, 0); add(jlIntr); jlIntr.setLocation(0, 0); for
	 * (int i = 0; i < 3; i++) { for (int k = 0; k < 14; k++) {
	 * p.prop.jpProp[i].prop[k] .addMouseListener(new MoListener(k)); } } }
	 * 
	 * protected void paintComponent(Graphics g) { // super.paintComponent(g);
	 * g.drawImage(im, 0, 0, getWidth(), getHeight(), this); }
	 * 
	 * class IntrLabel extends JLabel { /**
	 */
	/*
	 * private static final long serialVersionUID = 1L;
	 * 
	 * IntrLabel() { setSize(750, 100); setForeground(Color.WHITE); setFont(new
	 * Font("��Բ", Font.PLAIN, 20)); } }
	 * 
	 * class MoListener extends MouseAdapter { int i;
	 * 
	 * MoListener(int i) { this.i = i; }
	 * 
	 * @Override public void mouseEntered(MouseEvent e) { // TODO Auto-generated
	 * method stub jlIntr.setText(GloVar.intr1[i]); jlIntr.repaint(); }
	 * 
	 * @Override public void mouseExited(MouseEvent e) { // TODO Auto-generated
	 * method stub jlIntr.setText(""); jlIntr.repaint(); }
	 * 
	 * } } }
	 */

	/*
	 * public void closeFrame() { this.jbProp.listener.frame.dispose(); }
	 */
}
