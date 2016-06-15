package igui;

import java.awt.Cursor;

import javax.swing.Icon;
import javax.swing.JButton;

//定义自己的按钮
public class IButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IButton(){
		super.setOpaque(false);
		super.setBorderPainted(false);
		super.setContentAreaFilled(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public IButton(int width,int height){
		this();
		setSize(width,height);
	}
	public IButton(Icon ico){
		this();
		super.setIcon(ico);

	}
	public IButton(Icon ico,Icon ico1){
		this();
		super.setIcon(ico);
		super.setRolloverIcon(ico1);
	}
	public IButton(int width,int height,Icon ico,Icon ico1){
		this();
		setSize(width,height);
		super.setIcon(ico);
		super.setRolloverIcon(ico1);
	}
}

