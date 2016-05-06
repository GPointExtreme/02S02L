package exceptions.ue.liga;

import java.util.Comparator;

public class ComparatorName implements Comparator<Team>{

	@Override
	public int compare(Team o1, Team o2) {
		int i=o1.getName().compareTo(o2.getName());
		if(i != 0) {
			return i;
		}
		return 0;
	}

}
