package util;

import javax.swing.ImageIcon;

public enum PersonType {
	SABER("����������", "1"), SHIROU("����ʿ��", "2"), KIRITSUGU("��������", "3"), RIN(
			"Զ����", "4"), SAKURA("��ͩӣ", "5"), ARCHER("����٤��ʲ", "6"), RIDER("����ɯ",
			"7"), ILLYA("������", "8");

	private String name;
	private ImageIcon icon;
	private ImageIcon iconSelected;
	private ImageIcon image;
	private String iconUrl;
	private String hsUrl;
	private String imageUrl;
	private String TsUrl;
	private String nameUrl;

	PersonType(String name, String iconUrl) {
		this.name = name;
		this.iconUrl = "picture/person/����" + iconUrl + ".png";
		this.hsUrl = "picture/person/����" + iconUrl + "HS.png";
		this.imageUrl = "picture/person/����" + iconUrl + ".jpg";
		this.TsUrl = "picture/person/����" + iconUrl + "TS.png";
		this.icon = new ImageIcon(this.iconUrl);
		this.iconSelected = new ImageIcon("picture/person/����" + iconUrl
				+ "�߿�.png");
		this.image = new ImageIcon(this.imageUrl);
		this.nameUrl="picture/person/����" + iconUrl + "����.png";
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
