package view.map;

import static controller.MapController.getInstance;

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

import util.Const;
import view.button.CloseButton;
import controller.EventSession;
import controller.MapController;
import bean.item.Player;
import bean.place.House;
import igui.IButton;
import igui.IDialog;

//此类为土地地图类
public class MapHouse extends Map {
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
		// type = new House();
		// type.setLv(0);
		for (int i = 0; i < houseSell.length; i++) {
			houseSell[i] = "1";
		}
		// type.setOwner(GloVar.p1);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/*
		 * if (type.isPHere) { g.setClip(clip); g.drawImage(p.getImage(), 0, 0,
		 * getWidth(), getHeight(), this); g.setClip(null);
		 * g.setColor(Color.ORANGE); g.drawRoundRect(0, 0, 39, 39, 10, 10); }
		 * else { // g.drawImage(pic, 0, 0, getWidth(), getHeight(), this); if
		 * (type.getOwner() == null) {
		 */
		g.setColor(Color.ORANGE);
		g.drawRoundRect(0, 0, 39, 39, 10, 10);
		/*
		 * } else { g.setColor(Color.ORANGE); g.drawRoundRect(0, 0, 39, 39, 10,
		 * 10); g.setClip(clip); g.drawImage(type.owner.getHSImage(), 0, 0,
		 * getWidth(), getHeight(), this); }
		 */

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

	// 触发土地事件
	public void event(final Player p) {
		House house = (House) type;
		EventSession session = new EventSession("player", p);
		Const state = MapController.getInstance().getHouseState(p, house);

		if (state == Const.HOUSE_STATE_NULL) {

			final IDialog dialog = new IDialog(500, 400);
			// if (p.getCash() - type.getToll() >= 0) {
			CheckPanel check = new CheckPanel(house.getPrice(), dialog, state);
			dialog.getContentPane().add(check);
			check.btn.addActionListener((e) -> {

				dialog.dispose();
				EventSession response = getInstance().event(type, session);

				final java.util.Timer timer = new java.util.Timer();
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						/*
						 * frame.dispose(); GloVarGUI.frame.map.change(p);
						 * timer.cancel();
						 */
					}
				}, 1000);
			});

		} else if (state == Const.HOUSE_STATE_SELF) {
			/*
			 * if (!(type.getLv() == 6)) { if (p.getCash() - type.getInit() / 2
			 * >= 0) { // 可升级土地情况 MFrame0 frame = new MFrame0(); frame.add(new
			 * PlacePanel(p, frame, 2)); } else { // 新近不够升级土地情况 final MFrame0
			 * frame = new MFrame0(); // if (p.getCash() - type.getToll() >= 0)
			 * { frame.add(new PlacePanel(p, frame, 5)); final java.util.Timer
			 * timer = new java.util.Timer(); timer.schedule(new TimerTask() {
			 * 
			 * @Override public void run() { // TODO Auto-generated method stub
			 * frame.dispose(); GloVarGUI.frame.map.change(p); timer.cancel(); }
			 * }, 1000); } } else { // 土地已达顶级情况 GloVarGUI.frame.map.change(p); }
			 */
		} else {

		}

	}

	class CheckPanel extends JPanel {
		private ImageIcon ico = new ImageIcon("picture/place/土地.jpg");
		private Image im = ico.getImage();
		private ImageIcon ico1 = new ImageIcon("picture/word/文字购买.png");
		private ImageIcon ico2 = new ImageIcon("picture/word/文字购买1.png");
		IButton btn = new IButton(100, 50, ico1, ico2);
		CloseButton close;
		int cost;
		Const state;

		// CloseBt1 jbClose = new CloseBt1(frame, p);
		CheckPanel(int cost, IDialog dialog, Const state) {
			setLayout(null);
			setSize(400, 250);
			add(btn);
			btn.setLocation(250, 150);
			close = new CloseButton(dialog);
			add(close);
			close.setLocation(350, 0);
			this.cost = cost;
			this.state = state;
		}

		protected void paintComponent(Graphics g) {
			// g.setColor(new Color(206, 206, 0));
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			if (state == Const.HOUSE_STATE_NULL) {
				g.setColor(Color.black);
				g.setFont(new Font("华文新魏", Font.PLAIN, 40));
				g.drawString("购买土地?", 50, 60);
				// g.setColor(new Color(206, 206, 0));
				g.setFont(new Font("华文新魏", Font.PLAIN, 40));
				g.drawString("￥" + cost, 70, 120);
				g.setFont(new Font("微软雅黑", Font.PLAIN, 40));
			}

		}
	}
}