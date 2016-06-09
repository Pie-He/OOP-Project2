package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import view.panel.ChoosePersonPanel;
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
	public MenuPanel menu = new MenuPanel();
	public ChoosePersonPanel choose=new ChoosePersonPanel();
	
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
	}
	

	public void showChoose() {
		menu.setVisible(false);
		choose.setVisible(true);
	}

	public void showMap() {
		/*map.setVisible(true);
		chooseD.setVisible(false);
		menu.setVisible(false);
		chooseS.setVisible(false);*/
	}

	public void backMenu() {
		choose.setVisible(false);
		//map.setVisible(false);
		menu.setVisible(true);
	}
}
