package wordplay.bll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import utils.FileReader;
import wordplay.bo.Lettre;

public class LettreManager {
	private List<Lettre> s;
	private List<String> m;
	private Lettre[] t;
	
	public LettreManager() {
		init();
	}
	
	public void init() {
		s = new ArrayList<Lettre>();
		s.add(new Lettre('A', 1, 9));
		s.add(new Lettre('B', 3, 2));
		s.add(new Lettre('C', 3, 2));
		s.add(new Lettre('D', 2, 3));
		s.add(new Lettre('E', 1, 15));
		s.add(new Lettre('F', 4, 2));
		s.add(new Lettre('G', 2, 2));
		s.add(new Lettre('H', 4, 2));
		s.add(new Lettre('I', 1, 8));
		s.add(new Lettre('J', 8, 1));
		s.add(new Lettre('K', 10, 1));
		s.add(new Lettre('L', 1, 5));
		s.add(new Lettre('M', 2, 3));
		s.add(new Lettre('N', 1, 6));
		s.add(new Lettre('O', 1, 6));
		s.add(new Lettre('P', 3, 2));
		s.add(new Lettre('Q', 8, 1));
		s.add(new Lettre('R', 1, 6));
		s.add(new Lettre('S', 1, 6));
		s.add(new Lettre('T', 1, 6));
		s.add(new Lettre('U', 1, 6));
		s.add(new Lettre('V', 4, 2));
		s.add(new Lettre('W', 10, 1));
		s.add(new Lettre('X', 10, 1));
		s.add(new Lettre('Y', 10, 1));
		s.add(new Lettre('Z', 10, 1));
		
		m = FileReader.readWords();
	}
	
	public Lettre[] pick(int z) {
		t = new Lettre[z];
		Random rand = new Random();
		for (int i = 0; i < t.length; i++) t[i] = s.get(rand.nextInt(s.size()));
		return t;
	}
	
	public boolean isValid(String s) {
		for (char c : s.toCharArray()) if (!Arrays.asList(t).contains(findLetter(c))) return false;
		return m.contains(s);
	}
	
	public int wordValue(String s) {
		int r = 0;
		for (char c : s.toCharArray()) r += findLetter(c).getV();
		return r;
	}
	
	public Lettre findLetter(char c) {
		for (Lettre l : s) if (l.getL() == Character.toUpperCase(c)) return l;
		return null;
	}
	
	public String botChoice() {
		String r = null;
		int u = 0;
		for (String x : m) {
			if (isValid(x) && wordValue(x) > u) {
				r = x;
				u = wordValue(x);
			}
		}
		return r;
	}
}
