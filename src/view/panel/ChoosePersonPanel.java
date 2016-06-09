package view.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//此类为双人对战选人面板（包括一点AI的功能）
public class ChoosePersonPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon Image = new ImageIcon("picture/background/背景01.jpg");
	private Image Background = Image.getImage();
	private ImageIcon[] personImage = new ImageIcon[8];
	private ImageIcon[] personImage1 = new ImageIcon[personImage.length];
	//private Image[] personFace = new Image[personImage.length];
	private String[] person = { "阿尔托莉雅", "卫宫士郎", "卫宫切嗣", "远坂凛", "间桐樱", "吉尔伽美什",
			"美杜莎", "依莉雅" };
	private PersonLabel[] jlP=new PersonLabel[personImage.length];
	{
		for (int i = 0; i < personImage.length; i++) {
			personImage[i] = new ImageIcon("picture/person/人物" + (i + 1) + ".png");
			personImage1[i] = new ImageIcon("picture/person/人物" + (i + 1) + "边框.png");
			jlP[i]=new PersonLabel(new ImageIcon("picture/person/人物" + (i + 1) + ".jpg"));
			
		}
		//for (int i = 0; i < //personFace.length; i++) {
			//personFace[i] = personImage[i].getImage();
		//}
		
	}
	private PersonPanel JPpersonChoose1 = new PersonPanel();
	private PersonPanel JPpersonChoose2 = new PersonPanel();

	private PerLabel per1 = new PerLabel(new ImageIcon("picture/word/文字玩家一人物.png"));
	private PerLabel per2 = new PerLabel(new ImageIcon("picture/word/文字玩家二人物.png"));
	private ButtonPanel jpButton=new ButtonPanel();
	public ChoosePersonPanel() {
		setLayout(null);
		add(jpButton);
		jpButton.setLocation(1050, 450);
		add(JPpersonChoose1);
		JPpersonChoose1.setLocation(30,100);
		add(JPpersonChoose2);
		JPpersonChoose2.setLocation(430, 100);
		// personChoose1.setOpaque(false);
		add(per1);
		per1.setLocation(120, 50);
		add(per2);
		per2.setLocation(520, 50);

		for (int i = 0; i < personImage.length; i++) {
			buttonGroupOppose(JPpersonChoose1.getJrb(i), JPpersonChoose2.jrb, i);
			buttonGroupOppose(JPpersonChoose2.getJrb(i), JPpersonChoose1.jrb, i);
			add(jlP[i]);
			jlP[i].setLocation(900, 50);
			jlP[i].setVisible(false);
			//jlP[i].setmessText(GloVar.intr2[i]);
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Background != null) {
			g.drawImage(Background, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
	private void buttonGroupOppose(final JRadioButton g1,
			final JRadioButton[] g2, final int i) {
		g1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//是两个玩家不能同时选择相同的人
				if (g1.isSelected()) {
					g2[0].setEnabled(true);
					g2[1].setEnabled(true);
					g2[2].setEnabled(true);
					g2[3].setEnabled(true);
					g2[4].setEnabled(true);
					g2[5].setEnabled(true);
					g2[6].setEnabled(true);
					g2[7].setEnabled(true);
					g2[i].setEnabled(false);
				}
						boolean a=false;
						boolean b=false;
						for(int i=0;i<JPpersonChoose1.jrb.length;i++){
							if(JPpersonChoose1.jrb[i].isSelected())
								a=true;
							if(JPpersonChoose2.jrb[i].isSelected())
								b=true;
						}
						if(a&&b)
							jpButton.jbtYes.setEnabled(true);
					}
					
				
			
		});
	}
	//此面板为确认按钮的面板
	class ButtonPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private ChooseButton jbtYes = new ChooseButton(new ImageIcon(
				"picture/word/文字确定.png"));
		private ChooseButton jbtBack = new ChooseButton(new ImageIcon(
				"picture/word/文字返回.png"));
		ButtonPanel(){
			setSize(100,100);
			setLayout(new GridLayout(2,0));
			super.setOpaque(false);
			add(jbtYes);
			add(jbtBack);
			jbtYes.setRolloverIcon(new ImageIcon("picture/word/文字确定1.png"));
			jbtYes.setEnabled(false);
			jbtBack.setRolloverIcon(new ImageIcon("picture/word/文字返回1.png"));
		}
		//此类为确认按钮
		class ChooseButton extends JButton {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			ChooseButton(ImageIcon im) {
				super(im);
				setSize(100, 50);
				super.setOpaque(false);
				super.setBorderPainted(false);
				super.setContentAreaFilled(false);
				super.addActionListener(new ButtonListener());
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			//此监听器为当点击确认是，游戏开始，赋予每个玩家不停角色
			class ButtonListener implements   ActionListener{

				@Override
				public void actionPerformed(ActionEvent e) {
					/*if (e.getSource() == jbtYes) {
						if (JPpersonChoose1.getJrb(0).isSelected() == true) {
							GloVar.p1 = new Saber();
						} else if (JPpersonChoose1.getJrb(1).isSelected() == true) {
							GloVar.p1 = new Shirou();
						} else if (JPpersonChoose1.getJrb(2).isSelected()) {
							GloVar.p1 = new Kiritsugu();
						} else if (JPpersonChoose1.getJrb(3).isSelected()) {
							GloVar.p1 = new Rin();
						} else if (JPpersonChoose1.getJrb(4).isSelected()) {
							GloVar.p1 = new Sakura();
						} else if (JPpersonChoose1.getJrb(5).isSelected()) {
							GloVar.p1 = new Archer();
						} else if (JPpersonChoose1.getJrb(6).isSelected()) {
							GloVar.p1 = new Rider();
						} else if (JPpersonChoose1.getJrb(7).isSelected()) {
							GloVar.p1 = new Illya();
						}
						if (JPpersonChoose2.getJrb(0).isSelected() == true) {
							GloVar.p2 = new Saber();
						} else if (JPpersonChoose2.getJrb(1).isSelected() == true) {
							GloVar.p2 = new Shirou();
						} else if (JPpersonChoose2.getJrb(2).isSelected()) {
							GloVar.p2 = new Kiritsugu();
						} else if (JPpersonChoose2.getJrb(3).isSelected()) {
							GloVar.p2 = new Rin();
						} else if (JPpersonChoose2.getJrb(4).isSelected()) {
							GloVar.p2 = new Sakura();
						} else if (JPpersonChoose2.getJrb(5).isSelected()) {
							GloVar.p2 = new Archer();
						} else if (JPpersonChoose2.getJrb(6).isSelected()) {
							GloVar.p2 = new Rider();
						} else if (JPpersonChoose2.getJrb(7).isSelected()) {
							GloVar.p2 = new Illya();
						}
						GloVarGUI.frame.showMap();
						if(isAI){
							GloVar.p2.isAI=true;
						}
						
						/*GloVar.Map[0].setPHere(GloVar.p2, true);
						GloVar.Map[0].setPHere(GloVar.p1, true);
						GloVarGUI.frame.map.refresh();
						//System.out.println(GloVar.p1);
						GloVar.Map[2].type.setOwner(GloVar.p1);
						//System.out.println(GloVar.Map[2].type.getOwner());*/
						//游戏初始化,并开始
					/*	Main.GloVar.start();
					} else if (e.getSource() == jbtBack){
						GloVarGUI.frame.backMenu();
						/*for(int i=0;i<JPpersonChoose1.jrb.length;i++){
							JPpersonChoose1.jrb[i].setSelected(false);
							JPpersonChoose2.jrb[i].setSelected(false);
						}*/
					//}
				}
			}
		}
	}
	//选人多选按钮
	class PersonButton extends JRadioButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		PersonButton(ImageIcon im) {
			super(im);
			setSize(100, 100);
			setOpaque(false);
			super.setBorderPainted(false);
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
	}
	//选人面板
	class PersonPanel extends JPanel implements MouseListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		PersonButton[] jrb = new PersonButton[personImage.length];
		private ButtonGroup group = new ButtonGroup();

		PersonPanel() {

			setLayout(new GridLayout(0, 4));
			setSize(400, 400);
			for (int i = 0; i < jrb.length; i++) {
				JLabel jlPer = new JLabel(person[i]);
				jlPer.setForeground(Color.WHITE);
				jlPer.setFont(new Font("微软雅黑", Font.BOLD, 15));
				add(jrb[i] = new PersonButton(personImage[i]));
				add(jlPer);
				group.add(jrb[i]);
				jrb[i].setRolloverIcon(personImage1[i]);
				jrb[i].setSelectedIcon(personImage1[i]);
				jrb[i].addMouseListener(this);
			}
			setOpaque(false);		
		}
		PersonButton getJrb(int i) {
			return jrb[i];
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
		//当鼠标移入不同角色按钮，显示不同角色信息
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jrb[0]){
				showMess(0);
			}else if(e.getSource()==jrb[1]){
				showMess(1);
			}else if(e.getSource()==jrb[2]){
				showMess(2);
			}else if(e.getSource()==jrb[3]){
				showMess(3);
			}else if(e.getSource()==jrb[4]){
				showMess(4);
			}else if(e.getSource()==jrb[5]){
				showMess(5);
			}else if(e.getSource()==jrb[6]){
				showMess(6);
			}else if(e.getSource()==jrb[7]){
				showMess(7);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			/*JPChooseDouble.this.jlP[0].setVisible(false);
			JPChooseDouble.this.jlP[1].setVisible(false);
			JPChooseDouble.this.jlP[2].setVisible(false);
			JPChooseDouble.this.jlP[3].setVisible(false);
			JPChooseDouble.this.jlP[4].setVisible(false);
			JPChooseDouble.this.jlP[5].setVisible(false);
			JPChooseDouble.this.jlP[6].setVisible(false);
			JPChooseDouble.this.jlP[7].setVisible(false);*/
		}
		public void showMess(int i){
			/*JPChooseDouble.this.jlP[0].setVisible(false);
			JPChooseDouble.this.jlP[1].setVisible(false);
			JPChooseDouble.this.jlP[2].setVisible(false);
			JPChooseDouble.this.jlP[3].setVisible(false);
			JPChooseDouble.this.jlP[4].setVisible(false);
			JPChooseDouble.this.jlP[5].setVisible(false);
			JPChooseDouble.this.jlP[6].setVisible(false);
			JPChooseDouble.this.jlP[7].setVisible(false);
			JPChooseDouble.this.jlP[i].setVisible(true);*/
		}
	}

	class picLabel extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image im;

		picLabel(Image im) {
			this.im = im;
			setOpaque(false);
			setSize(100, 100);
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
		}
	}

	class PerLabel extends JLabel {
		private static final long serialVersionUID = 1858920048404155611L;
		private Image im;

		PerLabel(ImageIcon im) {
			setSize(200, 50);
			super.setOpaque(false);
			this.im = im.getImage();
		}

		protected void paintComponent(Graphics g) {
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
		}
	}
	class PersonLabel extends JLabel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image im;
		JLabel intr=new JLabel();
		PersonLabel(ImageIcon im){
			setSize(240,400);
			this.im=im.getImage();
			setBorder(BorderFactory.createLineBorder(Color.WHITE));
			intr.setForeground(Color.WHITE);
			intr.setFont(new Font("幼圆", Font.PLAIN, 20));
			intr.setBounds(20, 205, 200, 180);
			add(intr);
		}
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
				g.drawImage(im, 20, 20, 200, 200, this);
		}
		public void setmessText(String str){
			intr.setText(str);
			intr.repaint();
		}
	}
}