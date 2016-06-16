package view.button;

import igui.IButton;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class CheckButton extends IButton {

	// private Image im1 = ico.getImage();
	private boolean check=false;
	
	CheckButton(Icon ico, Icon ico1) {
		super(ico, ico1);
		setSize(100, 50);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

}

