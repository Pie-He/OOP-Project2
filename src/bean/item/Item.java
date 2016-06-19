package bean.item;


public class Item {
	private String symbol;
	protected int poi;
	protected Itemable type;

	protected void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getPoi() {
		return poi;
	}

	public void setPoi(int poi) {
		this.poi = poi;
	}

	public Itemable getType() {
		return type;

	}
}
