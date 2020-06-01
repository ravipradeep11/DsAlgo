package trees;

public class Tnode implements Comparable<Tnode>{
	public Tnode left = null;
	public Tnode right = null;
	public Tnode nextRight=null;
	public Comparable data;
	boolean isVisited=false;
	Tnode parent=null;
	public int height=0;
	public Tnode(Comparable data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.left=null;
		this.right=null;
	}

	@Override
	public int compareTo(Tnode o) {
		// TODO Auto-generated method stub
		return this.data.compareTo(o.data);
		
	}
public boolean isLeafNode()
{
if(this.left==null&&this.right==null)
	return true;
else
	return false;
}
	
}
