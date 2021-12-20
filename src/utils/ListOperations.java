package utils;

import java.util.ArrayList;
import java.util.List;

public class ListOperations {

	public int find(List<String> a, String b) {
		for (int i = 1; i < a.size(); i++) if (a.get(i).equals(b)) return i;
		return -1;
	}
	
	public List<String> sort(List<String> a, boolean c) {
		List<String> r = new ArrayList<String>();
		while (!a.isEmpty()) {
			String p = c ? min(a) : max(a);
			r.add(p);
			a.remove(p);
		}
		return r;
	}
	
	public String min(List<String> a) {
		String r = a.get(0);
		for (String c : a) if (c.compareTo(r) < 0) r = c;
		return r;
	}
	
	public String max(List<String> a) {
		String r = a.get(0);
		for (String c : a) if (c.compareTo(r) > 0) r = c;
		return r;
	}
}
