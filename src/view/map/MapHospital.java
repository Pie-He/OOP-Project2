package view.map;

import static controller.MapController.getInstance;
import igui.IOption;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.EventSession;
import bean.item.Player;
import bean.place.Hospital;

//此类定义起点地图
public class MapHospital extends Map {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final ImageIcon ICON = new ImageIcon("picture/place/圣杯.jpg");

	public MapHospital() {
		super.setSize(120, 120);
		this.image = ICON.getImage();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

	public boolean preEvent(Player player) {
		EventSession session = new EventSession("player", player);
		EventSession response = getInstance().event(type, session);
		String message = (String) response.get("message");
		// System.out.println("hospital preevent");
		// System.out.println(message);
		if (message != null) {
			IOption.showMessage(message);
			return false;
		}
		return true;
	}

	public void event(Player p) {
		//IOption.showMessage(2000, "医院");
	}
}