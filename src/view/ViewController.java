package view;

import javax.swing.JFrame;


public class ViewController {
	private static final ViewController CONTROLLER = new ViewController();

	public static ViewController getInstance() {
		return CONTROLLER;
	}

	private Window frame = new Window();

	public void start(){
		frame.setVisible(true);
	}
	public ViewController() {
		frame.setTitle("Fate");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setVisible(true);
	}

	public void showMenu() {
		frame.backMenu();
	}

	public void showChoose() {
		frame.showChoose();
	}
}
