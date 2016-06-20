package view.dialog;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import view.ViewController;
import bean.Stock;
import bean.item.Player;

//股票窗口
@SuppressWarnings("serial")
public class StockDialog extends JDialog {

	public StockDialog(Player player) {
		this.setModal(true);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(new StockPanel(player));

	}

	class StockPanel extends JPanel {

		StockPanel(Player player) {

			this.setLayout(new BorderLayout());
			StockTable table = new StockTable(player);
			JScrollPane scroll = new JScrollPane(table);
			add(scroll, BorderLayout.SOUTH);
		}
	}

	class StockTable extends JTable {
		final String[] title = { "股票名", "成交价", "涨跌幅", "持有量" };
		String[][] stocks = new String[Stock.values().length][title.length];

		StockTable(Player player) {
			// this.setOpaque(false);
			// this.setSize(200, 275);
			for (int i = 0; i < stocks.length; i++) {
				Stock[] st = Stock.values();
				stocks[i][0] = st[i].toString();
				stocks[i][1] = st[i].getPrice() + "";
				stocks[i][2] = st[i].getRiseAllFall() + "";
				stocks[i][3] = player.getStockAmount(st[i]) + "";
			}
			this.setModel(new DefaultTableModel(stocks, title));
			this.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			this.setFont(new Font("幼圆", Font.PLAIN, 13));
			this.setBorder(BorderFactory.createEtchedBorder());
			this.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {// 点击几次，这里是双击事件，//双击购买
						int row = StockTable.this.getSelectedRow();
						Stock.values()[row].buyStock(player, 1);
						refresh(player, row);
					}
					if (e.isMetaDown()) {//右键卖出
						int row = StockTable.this.getSelectedRow();
						Stock.values()[row].sellStock(player, 1);
						refresh(player, row);
					}
				}
			});
		}

		private void refresh(Player player, int i) {
			Stock[] st = Stock.values();
			stocks[i][0] = st[i].toString();
			stocks[i][1] = st[i].getPrice() + "";
			stocks[i][2] = st[i].getRiseAllFall() + "";
			stocks[i][3] = player.getStockAmount(st[i]) + "";
			this.getModel().setValueAt(stocks[i][3], i, 3);
			ViewController.getInstance().refresh();
			this.updateUI();
		}

		public boolean isCellEditable(int row, int column) {
			super.isCellEditable(row, column);
			return false;
		}
	}
}
