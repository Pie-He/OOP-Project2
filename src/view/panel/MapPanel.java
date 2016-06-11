package view.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.PlayerController;
import view.label.MapLabel;
import view.label.PlayerMessLabel;
import view.label.TimeLabel;

//此类为地图面板
public class MapPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon fateImage = new ImageIcon("picture/background/背景02.jpg");
	private Image fateBackground = fateImage.getImage();

	// private ChangeButton jbtChange = new ChangeButton();
	private mapMess jlMap = new mapMess();
	private TimeLabel time = new TimeLabel();
	private MapLabel map=new MapLabel();
	private List<PlayerMessLabel> playerMess = new ArrayList<PlayerMessLabel>();

	public MapPanel() {
		setSize(1200, 700);
		setLayout(null);

		add(time);
		time.setLocation(880, 50);
		add(jlMap);
		jlMap.setLocation(50, 600);
		
		add(map);
		map.setLocation(0, 0);

	}

	public void init() {
		PlayerController.getInstance().getPlayerList().stream().forEach(i -> {
			PlayerMessLabel pml = new PlayerMessLabel(i);
			playerMess.add(pml);
			pml.setLocation(880, 230);
			pml.setVisible(false);
			this.add(pml);
		});
		playerMess.get(0).setVisible(true);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (fateBackground != null) {
			g.drawImage(fateBackground, 0, 0, getWidth(), getHeight(), this);
		}
	}

	// 用于显示地图各点信息
	class mapMess extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		mapMess() {
			super("信息栏");
			setSize(800, 100);
			setForeground(Color.WHITE);
			setFont(new Font("幼圆", Font.PLAIN, 20));
		}
	}

	class mapListener extends MouseAdapter {
		int i;

		mapListener(int i) {
			this.i = i;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			// jlMap.setText(GloVar.Map[i].type.getIntr());
			jlMap.repaint();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			jlMap.setText("");
			jlMap.repaint();
		}
	}
}
