package view.map;

import static controller.MapController.getInstance;
import igui.IDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.EventSession;
import view.ViewController;
import bean.item.Item;
import bean.item.Player;

//����Ϊ��õ�ȯ��ͼ��
@SuppressWarnings("serial")
public class MapCoupon extends Map {
	private transient RoundRectangle2D clip = new RoundRectangle2D.Double(0, 0,
			39, 39, 39, 39);
	private static final ImageIcon ICON = new ImageIcon("picture/place/��ȯ.png");

	public MapCoupon() {
		super.setSize(40, 40);
		this.image = ICON.getImage();
		// type = new Coupon();
	}

	public void paintComponent(Graphics g) {
		g.setClip(clip);
		List<Item> items = this.type.getItems();
		// ImageIcon i=new ImageIcon();
		// System.out.println(type.getDescription()+items.size());
		items.stream().forEach(i -> {
			Image image = i.getType().getIcon().getImage();
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		});
		g.setClip(null);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

		/*
		 * if (type.isPHere) { g.setClip(clip); g.drawImage(p.getImage(), 0, 0,
		 * getWidth(), getHeight(), this); g.setClip(null); g.drawImage(image,
		 * 0, 0, getWidth(), getHeight(), this); } else {
		 */
		// g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		// }
	}

	// ������õ�ȯ�¼�
	public void event(final Player p) {

		final IDialog dialog = new IDialog(400, 200);
		EventSession session = new EventSession("player", p);
		EventSession response = getInstance().event(type, session);
		int coupon = (int) response.get("coupon");
		dialog.getContentPane().add(new PlacePanel(coupon));
		final java.util.Timer timer = new java.util.Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				dialog.dispose();
				timer.cancel();
				// GloVarGUI.frame.map.change(p);
			}
		}, 2000);
		dialog.setVisible(true);
	}

	class PlacePanel extends JPanel {
		private ImageIcon ico = new ImageIcon("picture/place/��Ʊ.jpg");
		private Image im = ico.getImage();
		private int coupon;

		PlacePanel(int coupon) {
			setLayout(null);
			setSize(400, 200);
			// ��������ȯ
			this.coupon = coupon;
		}

		protected void paintComponent(Graphics g) {
			// g.setColor(new Color(206, 206, 0));
			g.setColor(Color.ORANGE);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			g.setFont(new Font("������κ", Font.PLAIN, 40));
			g.drawString("��ϲ��", 50, 60);
			g.setFont(new Font("������κ", Font.PLAIN, 20));
			g.drawString("��õ�ȯ" + coupon, 40, 120);
		}
	}
}
