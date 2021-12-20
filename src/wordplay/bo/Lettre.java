package wordplay.bo;

public class Lettre {
	private char l;
	private int v;
	private int n;
	
	public Lettre(char l, int v, int n) {
		this.l = l;
		this.v = v;
		this.n = n;
	}

	public char getL() {
		return l;
	}

	public void setL(char l) {
		this.l = l;
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}
