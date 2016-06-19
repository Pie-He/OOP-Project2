package view;

import igui.IFrame;

import java.awt.Image;

import javax.swing.ImageIcon;

import bean.item.Player;
import view.panel.ChoosePersonPanel;
import view.panel.MapPanel;
import view.panel.MenuPanel;

//此类为游戏的主窗口
public class Window extends IFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageIcon Icon0 = new ImageIcon("picture/StayNight.png");
	private Image Icon = Icon0.getImage();
	private MenuPanel menu = new MenuPanel();
	private ChoosePersonPanel choose = new ChoosePersonPanel();
	private MapPanel map = new MapPanel();

	public Window() {
		setSize(1200, 700);
		setResizable(false);
		setIconImage(Icon);
		setLayout(null);
		add(menu);
		menu.setBounds(0, 0, getWidth(), getHeight());
		add(choose);
		choose.setBounds(0, 0, getWidth(), getHeight());
		choose.setVisible(false);
		add(map);
		map.setVisible(false);
	}

	public void showChoose() {
		menu.setVisible(false);
		choose.setVisible(true);
	}

	public void showMap() {
		map.setVisible(true);
		choose.setVisible(false);
		menu.setVisible(false);
	}

	public void backMenu() {
		choose.setVisible(false);
		map.setVisible(false);
		menu.setVisible(true);
	}

	public void gameInit() {
		map.init();
	}

	public void mapRefresh() {
		map.refresh();
	}

	public void event(Player player) {
		map.event(player);
	}

	public void show(Player player) {
		map.show(player);
	}

	public void timeRefresh() {
		map.timeRefresh();
	}

	public boolean preEvent(Player player) {
		return map.preEvent(player);

	}

	public void setButtonEnable(boolean b) {
		map.setButtonEnable(b);

	}

	public void playerRefresh() {
		map.playerRefresh();
	}
}
