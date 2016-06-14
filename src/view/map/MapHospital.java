package view.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import bean.item.Player;
import bean.place.Hospital;

//此类定义起点地图
public class MapHospital extends MapJLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final ImageIcon ICON = new ImageIcon("picture/place/圣杯.jpg");

	public MapHospital() {
		super.setSize(120, 120);
		this.image = ICON.getImage();
		//type = new Hospital();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.imageItems.stream().forEach(i -> {
			g.drawImage(i, 0, 0, getWidth(), getHeight(), this);
		});
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
		/*
		 * final MFrameS frame = new MFrameS(); frame.add(new PlacePanel(p));
		 * final java.util.Timer timer = new java.util.Timer();
		 * timer.schedule(new TimerTask() {
		 * 
		 * @Override public void run() { // TODO Auto-generated method stub
		 * frame.dispose(); GloVarGUI.frame.map.change(p); timer.cancel(); } },
		 * 2000);
		 */

	}
	/*
	 * public void Cross(Person p, final Timer time) {
	 * 
	 * final MFrameS frame = new MFrameS(); frame.add(new PlacePanel(p)); final
	 * java.util.Timer timer = new java.util.Timer(); timer.schedule(new
	 * TimerTask() {
	 * 
	 * @Override public void run() { // TODO Auto-generated method stub
	 * frame.dispose(); time.start(); timer.cancel(); } }, 2000);
	 * 
	 * } class PlacePanel extends JPanel { private ImageIcon ico = new
	 * ImageIcon("picture/起点.jpg"); private Image im = ico.getImage(); private
	 * Person p; private int coupon;
	 * 
	 * PlacePanel(Person p) { this.p = p; setLayout(null); setSize(400, 200);
	 * type.event(p); }
	 * 
	 * protected void paintComponent(Graphics g) { // g.setColor(new Color(206,
	 * 206, 0)); g.setColor(Color.red); g.drawImage(im, 0, 0, getWidth(),
	 * getHeight(), this); g.setFont(new Font("隶书", Font.PLAIN, 20));
	 * g.drawString("经过起点", 20, 20); g.setFont(new Font("隶书", Font.PLAIN, 30));
	 * g.drawString("奖励2000", 5, 50); } }
	 */
}

/*
 * class MFrameS extends JFrame { MFrameS() { setSize(400, 200);
 * setLocationRelativeTo(null); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 * setUndecorated(true); setVisible(true); GloVarGUI.frame.setEnabled(false); }
 * 
 * public void dispose() { GloVarGUI.frame.setEnabled(true); super.dispose(); }
 * }
 */