package view.map;

import igui.IDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Session;
import controller.MapController;
import view.button.CloseButton;
import view.panel.PropPanel;
import view.panel.PropPanel.PropPerPanel;
import bean.item.Player;
import bean.other.Prop;

//道具商店点
@SuppressWarnings("serial")
public class MapShop extends Map {
	private static final ImageIcon ICON = new ImageIcon("picture/place/商店.png");
	static int[] price = { 15, 20, 20, 20, 30, 30, 35, 80, 100, 100, 120, 120,
			180, 200 };

	private int[] PlayerPropNum = new int[Prop.values().length];
	private int PlayerCoupon = 0;

	public MapShop() {
		super.setSize(120, 120);
		image = ICON.getImage();
		// type = new Shop();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/*
		 * if (type.isPHere) { g.drawImage(image, 0, 0, getWidth(), getHeight(),
		 * this); g.drawImage(p.getIm(), 0, 0, getWidth(), getHeight(), this); }
		 * else {
		 */
		// g.drawImage(pic, 0, 0, getWidth(), getHeight(), this);
		// g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		// }
	}

	public void event(Player p) {
		Session session = new Session("player", p);

		MDialog dialog = new MDialog(p);
		dialog.setVisible(true);
		session.put("coupon", this.PlayerCoupon);
		session.put("propsNum", this.PlayerPropNum);

		MapController.getInstance().event(type, session);

	}

	class PlacePanel extends JPanel {

		private ImageIcon ico = new ImageIcon("picture/place/道具背景.jpg");
		private Image im = ico.getImage();
		private PropPanel shop;
		private PropPanel playerProp;
		private JLabel jlDial = new JLabel();
		private JLabel couponLabel;
		private CloseButton jbClose;
		private int coupon;
		private int[] propNum = new int[Prop.values().length];

		PlacePanel(Player p, JDialog dialog) {
			super.setOpaque(false);
			setLayout(null);
			jbClose = new CloseButton(dialog);
			add(jbClose);
			jbClose.setLocation(800, 0);
			shop = new PropPanel(jlDial);
			shop.setLocation(0, 60);
			add(shop);

			coupon = p.getCoupon();
			for (int i = 0; i < Prop.values().length; i++) {
				propNum[i] = p.getpropNum(Prop.values()[i]);
			}

			playerProp = new PropPanel(p, jlDial);
			playerProp.setLocation(0, 350);
			add(playerProp);

			jlDial.setForeground(Color.WHITE);
			jlDial.setFont(new Font("幼圆", Font.PLAIN, 20));
			jlDial.setBounds(0, 250, 800, 45);
			add(jlDial);
			couponLabel = new JLabel(coupon + "");
			couponLabel.setForeground(Color.WHITE);
			couponLabel.setFont(new Font("幼圆", Font.PLAIN, 20));
			couponLabel.setBounds(0, 0, 800, 20);
			add(couponLabel);
			// for()
			init();
			detected();
		}

		private void init() {
			PropPerPanel[] shops = shop.props;
			PropPerPanel[] players = playerProp.props;
			for (int i = 0; i < shops.length; i++) {
				Prop prop = shops[i].prop;
				int j = i;
				shops[j].propBtn.addActionListener((e) -> {
					++propNum[j];
					coupon -= prop.getPrice();
					detected();
				});
				players[j].propBtn.addActionListener((e) -> {
					int num = --propNum[j];
					players[j].setText(num + "");
					coupon += prop.getPrice();
					detected();
				});
			}
		}

		private void detected() {
			PropPerPanel[] shops = shop.props;
			PropPerPanel[] players = playerProp.props;
			for (int i = 0; i < shops.length; i++) {
				Prop prop = shops[i].prop;
				if (coupon < prop.getPrice())
					shops[i].propBtn.setEnabled(false);
				else
					shops[i].propBtn.setEnabled(true);
				if (propNum[i] == 0)
					players[i].propBtn.setEnabled(false);
				else
					players[i].propBtn.setEnabled(true);
				players[i].setText(propNum[i] + "");
			}
			couponLabel.setText(coupon + "");
			couponLabel.repaint();
		}

		protected void paintComponent(Graphics g) {
			// g.setColor(new Color(206, 206, 0));
			g.setColor(Color.ORANGE);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			g.setFont(new Font("华文彩云", Font.PLAIN, 50));
			g.drawString("道", 200, 50);
			g.drawString("具", 400, 50);
			g.drawString("店", 600, 50);
		}
	}

	class MDialog extends IDialog {

		private static final long serialVersionUID = 1L;
		Player p;
		PlacePanel jpProp;

		MDialog(Player p) {
			super(850, 500);
			this.p = p;
			jpProp = new PlacePanel(p, this);
			add(jpProp);
			jpProp.setBounds(0, 0, getWidth(), getHeight());
		}

		public void dispose() {
			super.dispose();
			PlayerPropNum = jpProp.propNum;
			PlayerCoupon = jpProp.coupon;
		}

	}
}
