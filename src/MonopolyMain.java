import java.io.IOException;

import javax.swing.JFrame;

import mgui.MFrame;
import bean.Manager;

public class MonopolyMain {

	public static void main(String[] args) throws IOException {
		//Manager.getInstance().start();
		MFrame frame=new MFrame();
		frame.setTitle("Fate");
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
