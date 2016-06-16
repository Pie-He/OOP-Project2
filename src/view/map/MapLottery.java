package view.map;

import static controller.MapController.getInstance;
import igui.IButton;
import igui.IDialog;

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
import controller.EventSession;
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
		/*
		 * if (type.isPHere) { g.drawImage(image, 0, 0, getWidth(), getHeight(),
		 * this); g.drawImage(p.getIm(), 0, 0, getWidth(), getHeight(), this); }
		 * else { // g.drawImage(pic, 0, 0, getWidth(), getHeight(), this);
		 */// g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			// }
	}

	public void event(final Player p) {

		EventSession session = new EventSession("player", p);

		IDialog id = new IDialog(400,250);
		CheckPanel panel = new CheckPanel(id);
		panel.btn.addActionListener((e) -> {
			System.out.println("yes");
			id.dispose();
			EventSession response = getInstance().event(type, session);
			String message = (String) response.get("message");
			final IDialog dialog = new IDialog(400,250);
			dialog.getContentPane().add(new PlacePanel(message));
			// frame.setLocation(200, 200);
			// dialog.setLocationRelativeTo(GloVarGUI.frame);
				final java.util.Timer timer = new java.util.Timer();
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						dialog.dispose();
						timer.cancel();
					}
				}, 3000);
				dialog.setVisible(true);
			});
		id.getContentPane().add(panel);
		id.setVisible(true);
		//iframe.pack();
		//iframe.repaint();
		//panel.setLocation(0, 0);
	}

	class PlacePanel extends JPanel {
		private ImageIcon ico = new ImageIcon("picture/place/中奖.jpg");
		private Image im = ico.getImage();
		private String message;

		PlacePanel(String message) {
			setLayout(null);
			setSize(400, 250);
			this.message = message;
		}

		protected void paintComponent(Graphics g) {
			// g.setColor(new Color(206, 206, 0));
			g.setColor(Color.GRAY);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			g.setFont(new Font("宋体", Font.PLAIN, 15));
			g.drawString(message, 220, 100);
			// g.setFont(new Font("华文新魏", Font.PLAIN, 20));
			// g.drawString("彩票中奖$" + lottery, 250, 160);
		}
	}

	class CheckPanel extends JPanel {
		private ImageIcon ico = new ImageIcon("picture/place/中奖.jpg");
		private Image im = ico.getImage();
		private ImageIcon ico1 = new ImageIcon("picture/word/文字购买.png");
		private ImageIcon ico2 = new ImageIcon("picture/word/文字购买1.png");
		IButton btn = new IButton(100, 50, ico1, ico2);
		CloseButton close;

		// CloseBt1 jbClose = new CloseBt1(frame, p);
		CheckPanel(IDialog dialog) {
			setLayout(null);
			setSize(400, 250);
			add(btn);
			btn.setLocation(250, 150);
			close=new CloseButton(dialog);
			add(close);
			close.setLocation(350, 0);
		}

		protected void paintComponent(Graphics g) {
			// g.setColor(new Color(206, 206, 0));
			g.setColor(Color.GRAY);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			g.setFont(new Font("宋体", Font.PLAIN, 15));
			g.drawString("是否花费2000元购买彩票？", 220, 100);

		}
	}

}