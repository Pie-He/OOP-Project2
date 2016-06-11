package view.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import bean.item.Player;
import bean.place.Coupon;


//此类为获得点券地图类
public class MapCoupon extends MapJLabel {
	private transient RoundRectangle2D clip = new RoundRectangle2D.Double(0, 0, 39, 39,
			39, 39);
	private static final ImageIcon ICON = new ImageIcon("picture/place/点券.png");

	public MapCoupon() {
		super.setSize(40, 40);
		this.image = ICON.getImage();
		type = new Coupon();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/*if (type.isPHere) {
			g.setClip(clip);
			g.drawImage(p.getImage(), 0, 0, getWidth(), getHeight(), this);
			g.setClip(null);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		} else {*/
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		//}
	}

	// 触发获得点券事件
	public void Event(final Player p) {

		/*final MFrame1 frame = new MFrame1();
		frame.add(new PlacePanel(p));
		final java.util.Timer timer = new java.util.Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				frame.dispose();
				timer.cancel();
				GloVarGUI.frame.map.change(p);
			}
		}, 2000);*/
	}

	/*class PlacePanel extends JPanel {
		*//**
		 * 
		 *//*
		private static final long serialVersionUID = 1L;
		private ImageIcon ico = new ImageIcon("picture/彩票.jpg");
		private Image im = ico.getImage();
		private int coupon;

		PlacePanel(Person p) {
			setLayout(null);
			setSize(400, 200);
			//获得随机点券
			coupon = type.returnEvent(p);
		}

		protected void paintComponent(Graphics g) {
			// g.setColor(new Color(206, 206, 0));
			g.setColor(Color.ORANGE);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			g.setFont(new Font("华文新魏", Font.PLAIN, 40));
			g.drawString("恭喜！", 50, 60);
			g.setFont(new Font("华文新魏", Font.PLAIN, 20));
			g.drawString("获得点券" + coupon, 40, 120);
		}
	}
}

class MFrame1 extends JFrame {
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;

	MFrame1() {
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		GloVarGUI.frame.setEnabled(false);
	}

	public void dispose() {
		GloVarGUI.frame.setEnabled(true);
		super.dispose();
	}*/
}