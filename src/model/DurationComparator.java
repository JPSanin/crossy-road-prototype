package model;

import java.util.Comparator;

public class DurationComparator implements Comparator<Player>{

	@Override
	public int compare(Player p1, Player p2) {
		return p1.getGameDuration()-p2.getGameDuration();
	}

}
