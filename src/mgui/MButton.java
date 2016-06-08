package mgui;

import java.awt.Cursor;

import javax.swing.Icon;
import javax.swing.JButton;

//定义自己的按钮
public class MButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MButton(){
		super.setOpaque(false);
		super.setBorderPainted(false);
		super.setContentAreaFilled(false);
		//super.addActionListener(new ButtonListener());
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public MButton(int width,int height){
		this();
		setSize(width,height);
	}
	public MButton(Icon ico){
		this();
		super.setIcon(ico);

	}
	public MButton(Icon ico,Icon ico1){
		this();
		super.setIcon(ico);
		super.setRolloverIcon(ico1);
	}
	public MButton(int width,int height,Icon ico,Icon ico1){
		this();
		setSize(width,height);
		super.setIcon(ico);
		super.setRolloverIcon(ico1);
	}
}

