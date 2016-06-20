package view.map;

import static controller.MapController.getInstance;
import igui.IButton;
import igui.IDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import controller.Session;
import view.button.CloseButton;
import bean.item.Player;

//银行地图
@SuppressWarnings("serial")
public class MapBank extends Map {

	private static final ImageIcon ICON = new ImageIcon("picture/place/美刀.jpg");
	private int money = 0;

	public MapBank() {
		super();
		super.setSize(40, 40);
		this.image = ICON.getImage();
		// type = new Bank();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	// 到达银行触发事件
	public void event(Player p) {
		money = 0;
		IDialog dialog = new IDialog(300, 400);
		PlacePanel jpPlace = new PlacePanel(p, 2, dialog);
		dialog.add(jpPlace);
		dialog.setVisible(true);

		Session session = new Session("player", p);
		session.put("money", money);
		getInstance().event(type, session);

	}

	class PlacePanel extends JPanel {

		private static final long serialVersionUID = 1L;
		private ImageIcon ico = new ImageIcon("picture/place/银行背景.jpg");
		private Image im = ico.getImage();
		private JLabel label = new JLabel(0 + "", JLabel.CENTER);
		private MSlider slSave;
		private MSlider slDraw;
		private CloseButton close;
		private Button jbtSave = new Button(new ImageIcon(
				"picture/word/文字存款.png"), new ImageIcon(
				"picture/word/文字存款1.png"));;
		private Button jbtDraw = new Button(new ImageIcon(
				"picture/word/文字取款.png"), new ImageIcon(
				"picture/word/文字取款1.png"));
		private JDialog dialog;

		PlacePanel(final Player p, int cho, JDialog frame) {
			this.dialog = frame;
			setLayout(null);
			setSize(300, 400);
			label.setForeground(Color.WHITE);
			label.setFont(new Font("幼圆", Font.PLAIN, 40));
			add(label);
			label.setBounds(50, 250, 200, 40);
			slSave = new MSlider(p.getCash());
			add(slSave);
			slSave.setBounds(0, 40, 80, 300);
			slDraw = new MSlider(p.getDeposit());
			add(slDraw);
			slDraw.setBounds(200, 40, 80, 300);
			close = new CloseButton(frame);
			add(close);
			close.setLocation(250, 0);
			add(jbtSave);
			jbtSave.setLocation(20, 340);
			add(jbtDraw);
			jbtDraw.setLocation(200, 340);

		}

		protected void paintComponent(Graphics g) {
			// g.setColor(new Color(206, 206, 0));
			super.paintComponent(g);
			g.setColor(Color.ORANGE);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);

		}

		// 此类选择存取款金额的滑条
		class MSlider extends JSlider {

			MSlider(int max) {
				super(JSlider.VERTICAL);
				super.setMaximum(max);
				super.setValue(0);
				setInverted(true);
				setMaximum(max);
				setPaintLabels(true);
				setPaintTicks(true);
				setMajorTickSpacing(max);
				super.setOpaque(false);
				super.setFont(new Font("幼圆", Font.PLAIN, 15));
				super.setForeground(Color.white);
				addChangeListener((e) -> label.setText(MSlider.this.getValue()
						+ "")// 返回当前滑块值
				);
			}
		}

		class Button extends IButton {

			Button(Icon ico, Icon ico1) {
				super(80, 50);
				super.setIcon(ico);
				super.setRolloverIcon(ico1);
				super.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == jbtSave) {
							money = slSave.getValue();
							dialog.dispose();
						} else if (e.getSource() == jbtDraw) {
							money = -slDraw.getValue();
							dialog.dispose();
						}
					}

				});
			}
		}
	}
}
