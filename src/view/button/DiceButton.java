package view.button;

import static view.ViewController.getInstance;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import controller.MapController;
import controller.PlayerController;

//此类为骰子的按钮类
public class DiceButton extends JButton {
	private int dice;
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
			// TODO Auto-generated method stub
			count = 20;
			timer.setDelay(20);
			timer.start();
			DiceButton.this.setEnabled(false);
			getInstance().setEnabled(false);
		}

		private class TimerListener implements ActionListener {
			Timer time = new Timer(400, new StepListener());
			int num = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				int dice = (int) (Math.random() * 6 + 1);
				if (count == 63) {
					/*
					 * // 判断是否使用遥控骰子 if (GloVar.who == 1 &&
					 * GloVar.p1.isDiceDIY()) { num = GloVar.dice;
					 * GloVar.p1.setDiceDIY(false); } else if (GloVar.who == 2
					 * && GloVar.p2.isDiceDIY()) { num = GloVar.dice;
					 * GloVar.p2.setDiceDIY(false); } // 判断是否使用乌龟卡 else if
					 * (GloVar.who == 1 && GloVar.p1.getSlowPace() != 0) { num =
					 * 1; GloVar.p1.setSlowPace(GloVar.p1.getSlowPace() - 1); }
					 * else if (GloVar.who == 2 && GloVar.p2.getSlowPace() != 0)
					 * { num = 1; GloVar.p2.setSlowPace(GloVar.p2.getSlowPace()
					 * - 1); }
					 */
				}
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

					
					// 判断是否使用技能（骰子点数*2）
					/*
					 * if ((GloVar.who == 1 && GloVar.p1.isTwoDice()) ||
					 * (GloVar.who == 2 && GloVar.p2.isTwoDice())) { num = num *
					 * 2; GloVar.p1.setTwoDice(false);
					 * GloVar.p2.setTwoDice(false); } GloVar.dice = num;
					 */
					num = dice;
					time.start();
					/*
					 * if (GloVar.who == 1) { GloVar.p1.setStep(GloVar.dice);
					 * GloVar.Map[GloVar.p1.getStep()].setPHere(GloVar.p1,
					 * true); GloVarGUI.frame.map.refresh(); GloVar.who = 2; }
					 * else if (GloVar.who == 2) {
					 * GloVar.p2.setStep(GloVar.dice);
					 * GloVar.Map[GloVar.p2.getStep()].setPHere(GloVar.p2,
					 * true); GloVarGUI.frame.map.refresh(); GloVar.who = 1; }
					 */
				}

			}

			class StepListener implements ActionListener {
				int count = 0;

				@Override
				public void actionPerformed(ActionEvent e) {

					MapController.getInstance().move(
							PlayerController.getInstance().getCurrentPlayer());

					count++;
					getInstance().refresh();
					if (count == num) {
						time.stop();
						count = 0;
						getInstance().setEnabled(true);
						DiceButton.this.setEnabled(true);
						PlayerController.getInstance().nextPlayer();
					}
					// TODO Auto-generated method stub
					/*
					 * if (GloVar.who == 1) { GloVar.p1.setStep(1);
					 * GloVar.Map[GloVar.p1.getStep()].setPHere(GloVar.p1,
					 * true); GloVarGUI.frame.map.refresh(); num++; //
					 * 判断p1是否经过银行或起点 if (num != GloVar.dice &&
					 * (GloVar.Map[GloVar.p1.getStep()].type instanceof Bank ||
					 * GloVar.Map[GloVar.p1 .getStep()].type instanceof Start))
					 * { time.stop();
					 * GloVar.Map[GloVar.p1.getStep()].Cross(GloVar.p1, time);
					 * 
					 * } // 如果走完点数，停止并触发事件 if (num == GloVar.dice) {
					 * time.stop(); GloVarGUI.frame.setEnabled(true); num = 0;
					 * Driven.start(GloVar.p1); } } else if (GloVar.who == 2) {
					 * GloVar.p2.setStep(1);
					 * GloVar.Map[GloVar.p2.getStep()].setPHere(GloVar.p2,
					 * true); GloVarGUI.frame.map.refresh(); num++; // 同p2 if
					 * (num != GloVar.dice &&
					 * (GloVar.Map[GloVar.p2.getStep()].type instanceof Bank ||
					 * GloVar.Map[GloVar.p2 .getStep()].type instanceof Start))
					 * { time.stop();
					 * GloVar.Map[GloVar.p2.getStep()].Cross(GloVar.p2, time); }
					 * if (num == GloVar.dice) { time.stop(); num = 0;
					 * Driven.start(GloVar.p2); } }
					 */
				}
			}
		}

	}
}
