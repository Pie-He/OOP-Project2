package view.map;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import bean.item.Player;
import bean.place.Place;


//���е�ͼ���͵ĸ���
public class MapJLabel extends Map implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public transient Player p = new Player();
	// Player p2=GloVar.p2;
	protected Image image;
	protected List<Image> imageItems = new ArrayList<Image>();

	protected Place type;
	// ���·�����ʾ����������

	public void putImage(Image image) {
		this.imageItems.add(image);
	}

	public void event(Player p) {
	};

	@Override
	public MapLv getLv() {
		return null;
	}

	@Override
	public void setLv(int i) {
	}

	// public void houseEvent(Player p){}
	public void sellHS(Player p) {
	}

	public void changeOwner(Player p, int i) {
	}

	public void showSell(final Player p, String[] s) {
	};

	public void Cross(Player p, Timer time) {
	}
}