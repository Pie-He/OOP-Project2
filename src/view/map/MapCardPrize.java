package view.map;

import static controller.MapController.getInstance;
import igui.IDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.ViewController;
import controller.EventSession;
import bean.Prop;
import bean.item.Player;
import bean.place.CardPrize;

//�������ߵ�
@SuppressWarnings("serial")
public class MapCardPrize extends Map {
	private final static ImageIcon ICON = new ImageIcon("picture/place/ʥ��.png");
	static String[] pName = { "������", "�ڹ꿨", "ת��", "��Ǩ��", "���ؿ�", "��˰��", "�ӶῨ",
			"ң������", "����", "����", "���ؿ�", "���޿�", "��ħ��", "������" };

	public MapCardPrize() {
		super.setSize(120, 120);
		this.image = ICON.getImage();
		// type=new CardPrize();
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

	public void event(final Player p) {

		EventSession session = new EventSession("player", p);
		EventSession response = getInstance().event(type, session);
		Prop prop=(Prop) response.get("prop");
		final IDialog dialog = new IDialog(400,200);
		dialog.getContentPane().add(new PlacePanel(prop.toText()));
		final java.util.Timer timer = new java.util.Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				dialog.dispose();
				timer.cancel();
			}
		}, 2000);
		dialog.setVisible(true);
	}

	class PlacePanel extends JPanel {
		private ImageIcon ico = new ImageIcon("picture/place/���߽���.jpg");
		private Image im = ico.getImage();
		private String prop;

		PlacePanel(String prop) {
			this.prop = prop;
			setLayout(null);
			setSize(400, 200);
		}

		protected void paintComponent(Graphics g) {
			// g.setColor(new Color(206, 206, 0));
			g.setColor(Color.BLACK);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			g.setFont(new Font("΢���ź�", Font.PLAIN, 40));
			g.drawString("��ϲ��", 50, 60);
			g.setFont(new Font("΢���ź�", Font.PLAIN, 20));
			g.drawString("��õ���" + prop, 20, 120);
		}
	}
}