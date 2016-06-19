package bean.item;

import javax.swing.ImageIcon;

public enum BlockType implements Itemable {
	RoadBlock("picture/prop/barrage.png");

	String conUrl;

	BlockType(String path) {
		this.conUrl = path;
	}

	@Override
	public ImageIcon getIcon() {
		return new ImageIcon(conUrl);
	}

}
