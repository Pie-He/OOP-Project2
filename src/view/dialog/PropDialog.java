package view.dialog;

import igui.IDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.PropUse;
import view.ViewController;
import view.button.CloseButton;
import view.panel.PropPanel;
import view.panel.PropPanel.PropPerPanel;
import bean.Prop;
import bean.item.Player;


@SuppressWarnings("serial")
public class PropDialog extends IDialog {
	PlayerPropPanel prop;

	public PropDialog(Player p) {
		super(850, 250);
		prop = new PlayerPropPanel(p);
		add(prop);
		prop.setLocation(0, 0);
	}

	// 显示道具列表
	class PlayerPropPanel extends JPanel {

		CloseButton close = new CloseButton(PropDialog.this);
		private ImageIcon Icon = new ImageIcon(
				"picture/background/我的道具背景.jpg");
		private Image im = Icon.getImage();
		Player player;
		IntrLabel jlIntr = new IntrLabel();
		PropPanel prop;

		PlayerPropPanel(Player player) {
			super.setOpaque(false);
			this.player = player;
			setLayout(null);
			setSize(850, 250);
			prop = new PropPanel(player, jlIntr);
			add(prop);
			prop.setLocation(0, 102);
			add(close);
			close.setLocation(800, 0);
			add(jlIntr);
			jlIntr.setLocation(0, 0);
			PropPerPanel[] props = prop.props;
			for (int i = 0; i < props.length; i++) {
				Prop prop = props[i].prop;
				props[i].propBtn.addActionListener((e) -> {
					PropUse.use(prop, player, PropDialog.this);
					detected();
				});
			}
			detected();

		}

		private void detected() {
			PropPerPanel[] props = prop.props;
			for (int i = 0; i < props.length; i++) {
				Prop prop = props[i].prop;
				if (player.getpropNum(prop) == 0)
					props[i].propBtn.setEnabled(false);
				else
					props[i].propBtn.setEnabled(true);
				props[i].setText(player.getpropNum(prop) + "");
			}
			ViewController.getInstance().refresh();
		}

		protected void paintComponent(Graphics g) {
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
		}

		class IntrLabel extends JLabel {

			IntrLabel() {
				setSize(750, 100);
				setForeground(Color.WHITE);
				setFont(new Font("幼圆", Font.PLAIN, 20));
			}
		}
	}
}
