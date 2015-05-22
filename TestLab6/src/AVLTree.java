
public class AVLTree {
	private Node root;
	
	private class Node{
		private Pos key;
		private int balance;
		private Node left, right, parent;
	
	public Node(Pos k, Node p)
	{
		key =k;
		parent = p;
	}
	}
	
	public boolean insert(Pos key){
		if(root == null){
			root = new Node(key, null);
		}else{
			Node n = root;
			Node parent;
		while(true){
			if(n.key == key)
				return false;
			
			parent = n;
			boolean goLeft = true;
			//boolean goLeft = n.key > key;
			
			if(n.key.p > key.p)
				goLeft = true;
			else if(n.key.p == key.p){
				if(n.key.q > n.key.q)
					goLeft = true;
			}else goLeft = false;
				
			
			
			n = goLeft? n.left : n.right;
			
			if(n == null){
				if(goLeft){
					parent.left = new Node(key, parent);
				}else{
					parent.right = new Node(key, parent);
				}
				
				rebalance(parent);
				break;
			}
		}
		}
		return true;
			}
	
	public void delete(Pos delKey){
		if(root == null)
			return;
		
		Node n = root;
		Node parent = root;
		Node delNode = null;
		Node child = root;
		
		while(child != null){
			parent = n;
			n = child;
		//	child = delKey >= n.key? n.right:n.left;
			
			if(delKey.p > n.key.p)
				child = n.right;
			else if(delKey.p == n.key.p){
				if(delKey.q >= n.key.q)
					child = n.right;
			}else child = n.left;
			
			
		if(delKey == n.key)
			delNode = n;
		}
		if(delNode != null){
			delNode.key = n.key;
			
			child = n.left != null? n.left : n.right;
			if(root.key == delKey){
				root = child;
			}else{
				if(parent.left == n){
					parent.left = child;
				}else{
					parent.right = child;
				}
				rebalance(parent);
				}
			}
			
		}
	private void rebalance(Node n){
		setBalance(n);
		
		if(n.balance == 2){
			if(height(n.left.left) >= height(n.left.right))
				n = rotateRight(n);
			else
				n =rotateLeftThenRight(n);
		}else if(n.balance == 2){
			if(height(n.right.right) >= height(n.right.left))
				n = rotateRightThenLeft(n);
		}
		if(n.parent != null){
			rebalance(n.parent);
		}else{
			root = n;
		}
	}
	
	private Node rotateLeft(Node a){
		Node b = a.right;
		b.parent = a.parent;
		
		a.right = b.left;
		
		if(a.right != null)
			a.right.parent = a;
		
		b.left = a;
		a.parent =b;
		
		if(b.parent != null){
			if(b.parent.right == a){
				b.parent.right = b;
			}else{
				b.parent.left = b;
			}
		}
		setBalance(a,b);
		
		return b;
	}
	
	private Node rotateRight(Node a){
		Node b = a.left;
		b.parent = a.parent;
		
		a.left = b.right;
		
		if(a.left != null)
			a.left.parent = a;
		
		b.right = a;
		a.parent =b;
		
		if(b.parent != null){
			if(b.parent.right == a){
				b.parent.right = b;
			}else{
				b.parent.left = b;
			}
		}
		setBalance(a,b);
		
		return b;
	}
	
	private Node rotateLeftThenRight(Node n){
		n.left = rotateLeft(n.right);
		return rotateRight(n);
	}
	
	private Node rotateRightThenLeft(Node n){
		n.right = rotateRight(n.right);
		return rotateLeft(n);
	}
	
	private int height(Node n){
		if(n == null)
			return -1;
		return 1 + Math.max(height(n.right),height(n.left));
	}
	
	private void setBalance(Node... nodes){
		for(Node n: nodes)
			n.balance = height(n.right)-height(n.left);
	}
	
	private void printBalance(){
		printBalance(root);
	}
	
	private void printBalance(Node n){
		if(n != null){
			printBalance(n.left);
			System.out.printf("%s", n.balance);
			printBalance(n.right);
		}
	}
	
}
