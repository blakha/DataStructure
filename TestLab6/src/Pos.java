
public class Pos implements Comparable<Pos>{

	private int p;
	private int q;
	
	Pos(int p , int q){
		this.p = p;
		this.q = q;
	}
	
	public int compareTo(Pos pos){
		if(this.p > pos.p) { return 1; }
		else if(this.p == pos.p){
			if(this.q == pos.q) { return 0; }
			else if(this.q > pos.q ) { return 1; }
		}
			return -1; 
		}
}
