package view.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import bean.item.Player;
import bean.place.News;

//����Ϊ������ʾ
public class MapNews extends Map {
	private static final ImageIcon ICON = new ImageIcon("picture/place/����.png");


	public MapNews() {
		super.setSize(120, 120);
		image=ICON.getImage();
		//type = new News();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
/*		if (type.isPHere) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(p.getIm(), 0, 0, getWidth(), getHeight(), this);
		} else {*/
			// g.drawImage(pic, 0, 0, getWidth(), getHeight(), this);
			//g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		//}
	}

	public void ebent(final Player p) {
			/*final MFrameN frame = new MFrameN();
			frame.add(new PlacePanel(p));
			final java.util.Timer timer = new java.util.Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					frame.dispose();
					timer.cancel();
					GloVarGUI.frame.map.change(p);
				}
			}, 4000);*/
	}

	/*class PlacePanel extends JPanel {
		private ImageIcon ico = new ImageIcon("picture/����ͷ��.jpg");
		private Image im = ico.getImage();
		private Person p;
		private int choice;
		private int rewards;
		private Person pRewa;
		private String[] prop;
		PlacePanel(Person p) {
			// ���0~4�����
			this.p = p;
			setLayout(null);
			setSize(600, 300);
			choice = (int) (Math.random() * 5);
			//�����ҷ�����ȣ��򲻲���ǰ��������
			if (p.getHousePP() == p.rival.getHousePP()) {
				choice = (int) (Math.random() * 3 + 2);
			}
			//choice=2;
			if (choice == 0) {
				if (p.getHousePP() > p.rival.getHousePP()) {
					pRewa = p;
				} else {
					pRewa = p.rival;
				}
				rewards = News.New0(pRewa);
			} else if (choice == 1) {
				if (p.getHousePP() < p.rival.getHousePP()) {
					pRewa = p;
				} else {
					pRewa = p.rival;
				}
				rewards = News.New0(pRewa);
			} else if (choice == 2) {
				News.New2();
			} else if (choice == 3) {
				News.New3();
			} else if (choice == 4) {
				prop=News.New4();
			}
		}

		protected void paintComponent(Graphics g) {
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			g.setColor(Color.BLACK);
			g.setFont(new Font("��Բ", Font.BOLD, 30));
			g.drawString("����ͷ����", 40, 60);
			g.setFont(new Font("��Բ", Font.BOLD, 20));
			//���ݲ�ͬ������ʾ��ͬ��Ϣ
			if (choice == 0) {
				g.drawString("����������һ����" + pRewa.getName() + "$" + rewards, 20,
						80);
			} else if (choice == 1) {
				g.drawString("������������������" + pRewa.getName() + "$" + rewards, 20,
						80);
			} else if (choice == 2) {
				g.drawString("���мӷ��������ÿ���˵õ����10%", 20, 80);
			} else if (choice == 3) {
				g.drawString("�����˽��ɲƲ�˰10%", 20, 80);
			}else if(choice==4){
				g.drawString("ÿ���˵õ�һ�ſ�Ƭ", 25, 80);
				g.drawString(GloVar.p1.getName()+"���  "+prop[0], 20, 100);
				g.drawString(GloVar.p2.getName()+"���  "+prop[1], 20, 120);
			}

		}
	}*/
}

/*class MFrameN extends JFrame {
	MFrameN() {
		setSize(600, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		GloVarGUI.frame.setEnabled(false);
	}

	public void dispose() {
		GloVarGUI.frame.setEnabled(true);
		super.dispose();
	}
}*/