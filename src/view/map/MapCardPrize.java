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
import bean.place.CardPrize;

//½±ÀøµÀ¾ßµã
public class MapCardPrize extends MapJLabel{
	private final static ImageIcon ICON=new ImageIcon("picture/place/Ê¥½£.png");
	static String[] pName = { "ÖÍÁô¿¨", "ÎÚ¹ê¿¨", "×ªÏò¿¨", "²ðÇ¨¿¨", "¹ºµØ¿¨", "²éË°¿¨", "ÂÓ¶á¿¨",
		"Ò£¿Ø÷»×Ó", "¸£Éñ¿¨", "²ÆÉñ¿¨", "ÍÁµØ¿¨", "¹ÖÊÞ¿¨", "¶ñÄ§¿¨", "¾ù¸»¿¨" };
	public MapCardPrize(){
		super.setSize(120, 120);
		this.image=ICON.getImage();
		type=new CardPrize();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
/*		if (type.isPHere) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(p.getIm(), 0, 0, getWidth(), getHeight(), this);
		} else {*/
			// g.drawImage(pic, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		//}

	}
	public void event(final Player p){
		/*
		final MFrameP frame=new MFrameP();
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
		}, 2000);*/
		
	}
	/*class PlacePanel extends JPanel{
		private ImageIcon ico = new ImageIcon("picture/µÀ¾ß½±Àø.jpg");
		private Image im = ico.getImage();
		private Person p;
		private int prize;
		PlacePanel(Person p){
			this.p=p;
			setLayout(null);
			setSize(400, 200);
			prize=type.returnEvent(p);
		}
		protected void paintComponent(Graphics g){
			//g.setColor(new Color(206, 206, 0));
			g.setColor(Color.BLACK);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			g.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 40));
			g.drawString("¹§Ï²£¡", 50, 60);
			g.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
			g.drawString("»ñµÃµÀ¾ß" + pName[prize], 20, 120);
		}
	}*/
}
/*class MFrameP extends JFrame{
	MFrameP(){
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		GloVarGUI.frame.setEnabled(false);
	}
	public void dispose(){
		GloVarGUI.frame.setEnabled(true);
		super.dispose();
	}
}*/