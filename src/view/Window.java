package view;

import java.awt.Image;

import javax.swing.ImageIcon;

import view.panel.ChoosePersonPanel;
import view.panel.MapPanel;
import view.panel.MenuPanel;
import mgui.MFrame;

//此类为游戏的主窗口
public class Window extends MFrame {
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
	
	public void gameInit(){
		map.init();
	}
}
