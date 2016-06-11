package view.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import bean.item.Player;
import bean.place.Lottery;

//以下为彩票中奖地图
public class MapLottery extends MapJLabel {

	private final static ImageIcon ICON = new ImageIcon("picture/place/lottery.png");

	public MapLottery() {
		super.setSize(120, 120);
		this.image=ICON.getImage();
		type = new Lottery();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
/*		if (type.isPHere) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(p.getIm(), 0, 0, getWidth(), getHeight(), this);
		} else {
			// g.drawImage(pic, 0, 0, getWidth(), getHeight(), this);
*/			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		//}
	}

	public void event(final Player p) {

		/*final MFrame frame = new MFrame();
		frame.add(new PlacePanel(p));
		//frame.setLocation(200, 200);
		//dialog.setLocationRelativeTo(GloVarGUI.frame);
		final java.util.Timer timer = new java.util.Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				frame.dispose();
				timer.cancel();
				GloVarGUI.frame.map.change(p);
			}
		}, 3000);*/
	}

	/*class PlacePanel extends JPanel {
		private ImageIcon ico = new ImageIcon("picture/中奖.jpg");
		private Image im = ico.getImage();
		private Person p;
		private int lottery;

		PlacePanel(Person p) {
			this.p = p;
			setLayout(null);
			setSize(400, 250);
			lottery = type.returnEvent(p);
		}

		protected void paintComponent(Graphics g) {
			// g.setColor(new Color(206, 206, 0));
			g.setColor(Color.ORANGE);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			g.setFont(new Font("华文新魏", Font.PLAIN, 40));
			g.drawString("恭喜！", 250, 100);
			g.setFont(new Font("华文新魏", Font.PLAIN, 20));
			g.drawString("彩票中奖$" + lottery, 250, 160);
		}
	}*/
}
/*class MFrame extends JFrame{
	MFrame(){
		setSize(400, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		GloVarGUI.frame.setEnabled(false);
	}
	public void dispose(){
		GloVarGUI.frame.setEnabled(true);
		super.dispose();
	}
}*/