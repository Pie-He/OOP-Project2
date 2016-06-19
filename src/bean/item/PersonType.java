package bean.item;

import javax.swing.ImageIcon;

public enum PersonType implements Itemable{
	SABER("阿尔托莉雅", "1"), SHIROU("卫宫士郎", "2"), KIRITSUGU("卫宫切嗣", "3"), RIN(
			"远坂凛", "4"), SAKURA("间桐樱", "5"), ARCHER("吉尔伽美什", "6"), RIDER("美杜莎",
			"7"), ILLYA("依莉雅", "8");

	private String name;
	private ImageIcon icon;
	private ImageIcon iconSelected;
	private ImageIcon image;
	private ImageIcon tsImage;
	private ImageIcon nameImage;
	private String iconUrl;
	private String hsUrl;
	private String imageUrl;
	private String TsUrl;
	private String nameUrl;

	PersonType(String name, String iconUrl) {
		this.name = name;
		this.iconUrl = "picture/person/人物" + iconUrl + ".png";
		this.hsUrl = "picture/person/人物" + iconUrl + "HS.png";
		this.imageUrl = "picture/person/人物" + iconUrl + ".jpg";
		this.TsUrl = "picture/person/人物" + iconUrl + "TS.png";
		this.icon = new ImageIcon(this.iconUrl);
		this.iconSelected = new ImageIcon("picture/person/人物" + iconUrl
				+ "边框.png");
		this.image = new ImageIcon(this.imageUrl);
		this.nameUrl = "picture/person/人物" + iconUrl + "名字.png";
		this.tsImage = new ImageIcon(this.TsUrl);
		this.nameImage = new ImageIcon(this.nameUrl);
	}

	public String getName() {
		return name;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public ImageIcon getIconSelected() {
		return iconSelected;
	}

	public ImageIcon getImage() {
		return image;
	}

	public ImageIcon getTsImage() {
		return this.tsImage;
	}

	public ImageIcon getNameImage() {
		return this.nameImage;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public String getHsUrl() {
		return hsUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getTsUrl() {
		return TsUrl;
	}

	public String getNameUrl() {
		return nameUrl;
	}

}
