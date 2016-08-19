package ch16;

import java.util.Comparator;

import ch08.Time2;

public class TimeComparator implements Comparator<Time2>{
	@Override
	public int compare(Time2 time1, Time2 time2){
		int dh = time1.getHour() - time2.getHour();
		if (dh ==0){
			int dm = time1.getMinute() - time2.getMinute();
			if (dm == 0) 
				return time1.getSecond() - time2.getSecond();
			return dm;
		}
		return dh;
	} 
}
