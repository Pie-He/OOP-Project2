package view.panel;

import igui.IButton;
import igui.IDialog;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bean.Prop;
import bean.item.Player;

@SuppressWarnings("serial")
public class PropPanel extends JPanel {
	List<PropPanelBar> bars = new ArrayList<PropPanelBar>();
	public PropPerPanel[] props = new PropPerPanel[Prop.values().length];

	private IButton jbF = new IButton(50, 50, new ImageIcon(
			"picture/symbol/道具箭头1.png"), new ImageIcon(
			"picture/symbol/道具箭头10.png"));
	private IButton jbN = new IButton(50, 50, new ImageIcon(
			"picture/symbol/道具箭头2.png"), new ImageIcon(
			"picture/symbol/道具箭头20.png"));
	private int index = 0;

	public PropPanel() {
		for (int i = 0; i < props.length; i += 5) {
			List<PropPerPanel> propList = new ArrayList<PropPerPanel>(5);
			for (int j = i; j < i + 5 && j < props.length; j++) {
				props[j] = new PropPerPanel(Prop.values()[j],
						Prop.values()[j].getPrice() + "点券");
				propList.add(props[j]);
			}
			bars.add(new PropPanelBar(propList
					.toArray(new PropPerPanel[propList.size()])));
		}
		init();
	}

	public PropPanel(JLabel jlDial) {
		for (int i = 0; i < props.length; i += 5) {
			List<PropPerPanel> propList = new ArrayList<PropPerPanel>(5);
			for (int j = i; j < i + 5 && j < props.length; j++) {
				props[j] = new PropPerPanel(Prop.values()[j],
						Prop.values()[j].getPrice() + "点券", jlDial);
				propList.add(props[j]);
			}
			bars.add(new PropPanelBar(propList
					.toArray(new PropPerPanel[propList.size()])));
		}
		init();
	}

	public PropPanel(Player player) {

		for (int i = 0; i < props.length; i += 5) {
			List<PropPerPanel> propList = new ArrayList<PropPerPanel>(5);
			for (int j = i; j < i + 5 && j < props.length; j++) {
				props[j] = new PropPerPanel(Prop.values()[j],
						player.getpropNum(Prop.values()[j]) + "");
				propList.add(props[j]);
			}
			bars.add(new PropPanelBar(propList
					.toArray(new PropPerPanel[propList.size()])));
		}
		init();
	}

	public PropPanel(Player player, JLabel jlDial) {

		for (int i = 0; i < props.length; i += 5) {
			List<PropPerPanel> propList = new ArrayList<PropPerPanel>(5);
			for (int j = i; j < i + 5 && j < props.length; j++) {
				props[j] = new PropPerPanel(Prop.values()[j],
						player.getpropNum(Prop.values()[j]) + "", jlDial);
				propList.add(props[j]);
			}
			bars.add(new PropPanelBar(propList
					.toArray(new PropPerPanel[propList.size()])));
		}
		init();
	}

	private void init() {
		super.setOpaque(false);
		this.setLayout(null);
		this.setSize(850, 150);

		this.show(index);

		add(jbF);
		jbF.setLocation(800, 0);
		jbF.addActionListener((e) -> {
			if (--index < 0)
				index = bars.size() - 1;
			this.show(index);
		});

		jbN.setLocation(800, 80);
		jbN.addActionListener((e) -> {
			if (++index >= bars.size())
				index = 0;
			this.show(index);
		});
		add(jbN);
		bars.stream().forEach(i -> {
			add(i);
			i.setLocation(0, 0);
		});
	}

	private void show(int index) {
		bars.stream().forEach(i -> {
			i.setVisible(false);
		});
		bars.get(index).setVisible(true);
	}

	public class PropButton extends IButton {
		private static final long serialVersionUID = 1L;

		public PropButton(ImageIcon ico0, ImageIcon ico1) {
			super(160, 128, ico0, ico1);
		}
	}

	public class PropPerPanel extends JPanel {
		public PropButton propBtn;
		JLabel l;
		public Prop prop;

		PropPerPanel(Prop prop, String message) {
			super.setOpaque(false);
			this.prop = prop;
			setSize(160, 150);
			this.setLayout(null);
			propBtn = new PropButton(prop.getImage(), prop.getImageSelected());
			add(propBtn);
			propBtn.setLocation(0, 0);
			l = new JLabel(message, JLabel.CENTER);
			l.setForeground(Color.WHITE);
			add(l);
			l.setBounds(0, 130, 160, 20);
		}

		PropPerPanel(Prop prop, String message, JLabel jlDial) {
			this(prop, message);
			propBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					jlDial.setText(prop.getDescription());
					jlDial.repaint();
				}
			});
		}

		public void setText(String text) {
			l.setText(text);
			l.repaint();
		}

		public String getText() {
			return l.getText();
		}
	}

	// 显示可购买道具
	public class PropPanelBar extends JPanel {

		PropPanelBar(PropPerPanel[] prop) {
			super.setOpaque(false);
			setLayout(new GridLayout(1, prop.length));
			setSize(prop.length * 160, 150);
			for (int i = 0; i < prop.length; i++) {
				add(prop[i]);
			}
		}
	}

}
