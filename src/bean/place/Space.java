package bean.place;

import bean.PlaceEnum;
import bean.item.Player;

public class Space extends Place {

	public Space() {
		super(PlaceEnum.SPACE.ordinal());
	}

	@Override
	public boolean event(Player p) {
		return super.event(p);
	}
}
