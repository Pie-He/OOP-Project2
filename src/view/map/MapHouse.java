package view.map;

import static controller.MapController.getInstance;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

import javax.swing.ImageIcon;

import util.Const;
import controller.EventSession;
import bean.item.Item;
import bean.item.Player;
import bean.place.House;
import bean.place.Place;
import igui.IOption;

//此类为土地地图类
public class MapHouse extends Map {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient MapLv lv;

	private transient RoundRectangle2D clip = new RoundRectangle2D.Double(0, 0,
			39, 39, 10, 10);
	String[] houseSell = new String[25];
	private House house;

	public MapHouse() {
		super.setSize(40, 40);
		lv = new MapLv();
		// type = new House();
		// type.setLv(0);
		for (int i = 0; i < houseSell.length; i++) {
			houseSell[i] = "1";
		}
		// type.setOwner(GloVar.p1);
	}

	public void paintComponent(Graphics g) {
		if (house != null) {
			this.image = new ImageIcon(house.getOwner() == null ? null : house
					.getOwner().getType().getHsUrl()).getImage();
		}

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

	@Override
	public void setType(Place type) {
		super.setType(type);
		house = (House) type;
	}

	public MapLv getLv() {
		return lv;
	}

	@Override
	public void repaint() {
		super.repaint();
		if (lv != null) {
			lv.setLv(house.getOwner() == null ? 0 : house.getLevel());
			this.lv.repaint();
		}
	}

	// 触发土地事件
	public void event(final Player p) {
		EventSession session = new EventSession("player", p);
		Const state = getInstance().getHouseState(p, house);
		String message = null;
		String cost = null;
		if (state == Const.HOUSE_STATE_OTHERS) {

		} else {
			if (state == Const.HOUSE_STATE_NULL) {
				message = "是否购买土地？";
				cost = "￥" + house.getPrice() + "";
			} else if (state == Const.HOUSE_STATE_SELF) {
				message = "是否升级土地？";
				cost = "￥" + house.getInitialPrice() + "";
			}
			if (IOption.showConfirmDialog(message, cost) != IOption.OK_OPTION)
				return;
		}
		EventSession response = getInstance().event(type, session);
		String[] mess = (String[]) response.get("message");
		IOption.showMessage(mess);
		this.repaint();
	}
}