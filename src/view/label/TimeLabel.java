package view.label;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import static controller.TimeController.getInstance;

//����Ϊ��ʾ��Ϸʱ����Ϣlabel
public class TimeLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TitledBorder border = new TitledBorder(
			BorderFactory.createLineBorder(Color.WHITE), "��Ϸ��Ϣ");
	private dateLabel jlDate;

	public TimeLabel() {
		jlDate = new dateLabel(getInstance().getTime(), JLabel.CENTER);
		setSize(300, 150);
		setLayout(new GridLayout(1, 1));
		border.setTitleColor(Color.WHITE);
		setBorder(border);
		jlDate.setSize(getSize());
		add(jlDate);
	}

	class dateLabel extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		dateLabel(String s, int alignment) {
			super(s, alignment);
			setForeground(Color.WHITE);
			setFont(new Font("����", Font.PLAIN, 30));
		}
	}

	public void refresh() {
		String time = getInstance().getTime();
		jlDate.setText(time);
		jlDate.repaint();
	}
}
