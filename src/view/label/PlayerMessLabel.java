package view.label;

import igui.IButton;
import igui.IOption;

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

import controller.TimeController;
import util.Const;

import view.dialog.PropDialog;
import view.dialog.StockDialog;
import bean.item.Player;

//此类为人物信息显示label，包括道具使用及技能使用
@SuppressWarnings("serial")
public class PlayerMessLabel extends JLabel {
	TitledBorder border = new TitledBorder(
			BorderFactory.createLineBorder(Color.WHITE), "人物信息");
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
		private mLabel jl1 = new mLabel(p.getCash() + "", JLabel.RIGHT);
		private mLabel jl2 = new mLabel(p.getDeposit() + "", JLabel.RIGHT);
		private mLabel jl3 = new mLabel(p.getHouseProperty() + "", JLabel.RIGHT);
		private mLabel jl4 = new mLabel(p.getCoupon() + "", JLabel.RIGHT);
		private mLabel jl5 = new mLabel(p.getProperty() + "", JLabel.RIGHT);
		private mLabel jl6 = new mLabel(p.getDirection() > 0 ? "顺时针" : "逆时针",
				JLabel.RIGHT);

		MessLabel() {
			setLayout(new GridLayout(6, 2));
			setSize(260, 150);
			add(new mLabel("现金"));
			add(jl1);
			add(new mLabel("存款"));
			add(jl2);
			add(new mLabel("房产"));
			add(jl3);
			add(new mLabel("点券"));
			add(jl4);
			add(new mLabel("资产"));
			add(jl5);
			add(new mLabel("方向"));
			add(jl6);

		}

		class mLabel extends JLabel {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			mLabel(String s) {
				super(s);
				setForeground(Color.WHITE);
				setFont(new Font("幼圆", Font.PLAIN, 20));
			}

			mLabel(String s, int alignment) {
				super(s, alignment);
				setForeground(Color.WHITE);
				setFont(new Font("幼圆", Font.PLAIN, 20));
			}
		}

		void refresh() {
			jl1.setText(p.getCash() + "");
			jl2.setText(p.getDeposit() + "");
			jl3.setText(p.getHouseProperty() + "");
			jl4.setText(p.getCoupon() + "");
			jl5.setText(p.getProperty() + "");
			jl6.setText(p.getDirection() > 0 ? "顺时针" : "逆时针");
			jl1.repaint();
			jl2.repaint();
			jl3.repaint();
			jl4.repaint();
			jl5.repaint();
			jl6.repaint();

		}
	}

	public void refresh() {
		mess.refresh();
	}

	// 定义道具使用按钮
	public class PButton extends IButton {
		public Listener listener = new Listener();
		Player player;

		PButton(Player p) {
			setSize(125, 45);
			setIcon(new ImageIcon("picture/word/文字道具.png"));
			setRolloverIcon(new ImageIcon("picture/word/文字道具1.png"));
			super.addActionListener(listener);
			this.player = p;
		}

		public class Listener implements ActionListener {
			// public MFrame frame;

			@Override
			public void actionPerformed(ActionEvent e) {
				PropDialog dialog = new PropDialog(player);
				dialog.setVisible(true);
			}
		}
	}

	// 定义股票使用按钮
	class SButton extends IButton {
		Player p;

		SButton(Player p) {
			this.p = p;
			setSize(125, 45);
			setIcon(new ImageIcon("picture/word/文字股票.png"));
			setRolloverIcon(new ImageIcon("picture/word/文字股票1.png"));
			this.addActionListener((e) -> {
				if (TimeController.getInstance().isWeekend()) {
					IOption.showMessage(Const.TIME_BANK_CLOSE);
				} else {
					StockDialog dialog = new StockDialog(p);
					dialog.setVisible(true);
				}

			});
		}
	}

	public boolean isPlayer(Player player) {
		return this.p == player;
	}

}
