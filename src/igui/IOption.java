package igui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import util.Const;
import view.button.CloseButton;

@SuppressWarnings("serial")
public class IOption extends IDialog {
	public final static int OK_OPTION = 1;
	public final static int CANCEL_OPTION = 0;
	private final static int PER = 17;
	private final static int I_WIDTH = 26;
	private final static int I_HEIGHT = 16;
	private static int option;
	private String[] message;
	private boolean auto;
	private CheckPanel check;

	public IOption(String[] message, boolean auto) {
		super(PER * I_WIDTH, PER * I_HEIGHT);
		this.auto = auto;
		this.message = message;
		this.check = new CheckPanel();
		this.getContentPane().add(check);
	}

	public IOption(String[] message) {
		this(message, false);
	}

	private class CheckPanel extends JPanel {
		private ImageIcon ico = new ImageIcon("picture/place/option.png");
		private Image im = ico.getImage();
		private ImageIcon ico1 = new ImageIcon("picture/word/文字check.png");
		private ImageIcon ico2 = new ImageIcon("picture/word/文字check1.png");
		private IButton btn = new IButton(90, 45, ico1, ico2);
		private CloseButton close;

		// CloseBt1 jbClose = new CloseBt1(frame, p);
		CheckPanel() {
			setLayout(null);
			// setSize(350, 200);
			if (!auto) {
				add(btn);
				btn.setLocation((IOption.this.getWidth() - btn.getWidth()) / 2,
						IOption.this.getHeight() - 50);
				btn.addActionListener((e) -> {
					IOption.this.dispose();
					option = OK_OPTION;
				});
				close = new CloseButton(IOption.this);
				add(close);
				close.setLocation(IOption.this.getWidth() - close.getWidth(), 0);
				close.addActionListener((e) -> option = CANCEL_OPTION);
			}
		}

		protected void paintComponent(Graphics g) {
			// g.setColor(new Color(206, 206, 0));
			g.setColor(Color.WHITE);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			g.setFont(new Font("华文琥珀", Font.PLAIN, PER));
			int startH = (I_HEIGHT - message.length) / 2;
			for (int i = 0; i < message.length; i++) {
				int width = (I_WIDTH - message[i].length()) / 2 * PER;
				int height = (startH + i) * PER;
				g.drawString(message[i], width, height);
			}

		}
	}

	/*
	 * public static void main(String[] args) {
	 * System.out.println(IOption.showConfirmDialog("是否购买","不是买"));
	 * //IOption.showMessage("dd"); }
	 */

	public static int showConfirmDialog(String... messages) {
		IOption dialog = new IOption(messages);
		dialog.setVisible(true);
		return option;
	}

	public static void showMessage(int time, String... messages) {
		final java.util.Timer timer = new java.util.Timer();
		IOption dialog = new IOption(messages, true);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				dialog.dispose();
				timer.cancel();
			}
		}, time);
		dialog.setVisible(true);
	}

	public static void showMessage(String... messages) {
		final java.util.Timer timer = new java.util.Timer();
		IOption dialog = new IOption(messages, true);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				dialog.dispose();
				timer.cancel();
			}
		}, 2000);
		dialog.setVisible(true);
	}

	public static void showMessage(Const con) {
		showMessage(con.toString());
	}

	public static void showMessage(int time, Const con) {
		showMessage(time, con.toString());
	}
}
