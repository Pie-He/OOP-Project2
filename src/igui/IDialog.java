package igui;

import javax.swing.JDialog;

@SuppressWarnings("serial")
public class IDialog extends JDialog {
	public IDialog(int width, int height) {
		this.setModal(true);
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setUndecorated(true);
	}

	public void dispose() {
		super.dispose();
	}
}
