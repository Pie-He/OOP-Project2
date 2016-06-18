package view.button;

import static view.ViewController.getInstance;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;


//此类为骰子的按钮类
@SuppressWarnings("serial")
public class DiceButton extends JButton {
	private ImageIcon[] diceIcon = new ImageIcon[7];
	private Image[] diceIm = new Image[diceIcon.length];
	{
		for (int i = 0; i < diceIcon.length; i++) {
			diceIcon[i] = new ImageIcon("picture/dice/dice" + i + ".png");
			diceIm[i] = diceIcon[i].getImage();
		}
	}

	public DiceButton() {
		setSize(100, 100);
		super.setBorderPainted(false);
		super.setOpaque(false);
		super.setContentAreaFilled(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setIcon(diceIcon[1]);
		super.addActionListener(new ButtonListener());
	}

	private class ButtonListener implements ActionListener {
		Timer timer = new Timer(20, new TimerListener());// 使骰子图标根据所设时间改变
		private int count = 20;

		@Override
		public void actionPerformed(ActionEvent e) {
			count = 20;
			timer.setDelay(20);
			timer.start();
			DiceButton.this.setEnabled(false);
			getInstance().setEnabled(false);
		}

		private class TimerListener implements ActionListener {
			//Timer time = new Timer(400, new StepListener());

			@Override
			public void actionPerformed(ActionEvent e) {

				int dice = (int) (Math.random() * 6 + 1);
				DiceButton.this.setIcon(diceIcon[dice]);
				count++;
				DiceButton.this.repaint();
				if (count == 40) {
					timer.setDelay(50);
				} else if (count == 50) {
					timer.setDelay(100);
				} else if (count == 63) {
					timer.setDelay(200);
				} else if (count == 64) {
					timer.stop();
					dice = 6;
					getInstance().move(dice);
				}

			}
		}

	}
}
