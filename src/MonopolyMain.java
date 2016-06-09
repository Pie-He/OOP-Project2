import java.io.IOException;

import javax.swing.JFrame;

import view.ViewController;
import view.Window;
import mgui.MFrame;
import bean.Manager;

public class MonopolyMain {

	public static void main(String[] args) throws IOException {
		//Manager.getInstance().start();
		/*Window frame=new Window();
		frame.setTitle("Fate");
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);*/
		ViewController.getInstance().start();
	}
}
