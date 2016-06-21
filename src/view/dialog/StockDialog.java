package view.dialog;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import view.ViewController;
import bean.item.Player;
import bean.other.Stock;

//股票窗口
@SuppressWarnings("serial")
public class StockDialog extends JDialog {

	public StockDialog(Player player) {
		this.setModal(true);
		setSize(500, 525);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.add(new StockPanel(player));

	}

	class StockPanel extends JPanel {
		StockChart chart;

		StockPanel(Player player) {
			// this.setLayout(null);
			// this.setLayout(new GridLayout(0, 1));
			this.setLayout(null);
			chart = new StockChart(Stock.values()[0]);
			add(chart);
			chart.setLocation(0, 0);
			StockTable table = new StockTable(player);
			JScrollPane scroll = new JScrollPane(table);
			add(scroll);
			scroll.setBounds(0, 300, 500, 185);
		}

		class StockChart extends JPanel {
			Stock stock;

			StockChart(Stock stock) {
				this.setSize(500, 300);
				this.stock = stock;
			}

			public BufferedImage get() {
				XYDataset xydataset = createDataset();
				JFreeChart jfreechart = ChartFactory.createXYLineChart("股票走势图",
						"", "价格", xydataset, PlotOrientation.VERTICAL, true,
						true, true);
				XYPlot xyplot = (XYPlot) jfreechart.getPlot();
				NumberAxis numberaxis = (NumberAxis) xyplot.getDomainAxis();
				numberaxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12)); // 垂直标题
				numberaxis.setAutoRange(true);
				ValueAxis rangeAxis = xyplot.getRangeAxis();// 获取柱状
				rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
				rangeAxis.setLowerBound(stock.getLow() - 5);
				jfreechart.getLegend().setItemFont(
						new Font("黑体", Font.BOLD, 15));
				jfreechart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体
				BufferedImage image = jfreechart.createBufferedImage(500, 300,
						BufferedImage.TYPE_INT_RGB, null);
				return image;
			}

			public void reset(Stock stock) {
				this.stock = stock;
				this.repaint();
			}

			// private void

			private XYDataset createDataset() {
				XYSeries series = new XYSeries(stock.name());
				List<Integer> l = stock.getHistoryPrice();
				for (int i = 0; i < l.size(); i++) {
					series.add(i, l.get(i));
				}
				XYSeriesCollection xySeriescollection = new XYSeriesCollection();
				xySeriescollection.addSeries(series);
				return xySeriescollection;
			}

			public void paintComponent(Graphics g) {
				g.drawImage(this.get(), 0, 0, getWidth(), getHeight(), this);
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
						int row = StockTable.this.getSelectedRow();
						Stock stock = Stock.values()[row];
						if (e.getClickCount() == 2) {// 点击几次，这里是双击事件，//双击购买
							System.out.println(stock);
							stock.buyStock(player, 1);
							refresh(player, row);
						}
						if (e.isMetaDown()) {// 右键卖出

							stock.sellStock(player, 1);
							refresh(player, row);
						}

						chart.reset(stock);

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
}
