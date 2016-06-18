package view.map;

import static controller.MapController.getInstance;
import igui.IButton;
import igui.IDialog;
import igui.IOption;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.ViewController;
import view.button.CheckButton;
import view.button.CloseButton;
import controller.Session;
import bean.item.Player;
import bean.place.Lottery;

//以下为彩票中奖地图
@SuppressWarnings("serial")
public class MapLottery extends Map {

	private final static ImageIcon ICON = new ImageIcon(
			"picture/place/lottery.png");

	public MapLottery() {
		super.setSize(120, 120);
		this.image = ICON.getImage();
		// type = new Lottery();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public void event(Player p) {

		Session session = new Session("player", p);

		int choice = IOption.showConfirmDialog("是否花费2000元购买彩票？");
		if (choice == IOption.OK_OPTION) {
			Session response = getInstance().event(type, session);
			String message = response.getString("message");
			IOption.showMessage(message);
		}

	}

}