 public class BinaryTree<E> {
	private E root;
	private BinaryTree<E> left, right;
// Constructors
	public BinaryTree(E root, BinaryTree<E> left, BinaryTree<E> right) {
		this.root = root;
		this.left = left;
		this.right = right;
	}
	public BinaryTree(E root) {
		this.root = root;
		this.left = null;
		this.right = null;
	}
// Methods
  	public E getRoot(){
  		return this.root;
  	}
  	public BinaryTree<E> getLeft(){
  		return this.left;
  	}
  	public BinaryTree<E> getRight(){
  		return this.right;
	}
  	public E setRoot(E element){
  		root = element;
  		return root;
  	}
	public BinaryTree<E> setLeft(BinaryTree<E> tree){
		left = tree;
		return left;
	}
	public BinaryTree<E> setRight(BinaryTree<E> tree){
		right = tree;
		return right;
	}
 	public String toString(){
 	    String result = "";
 	    if (root == null)
 	        return "";
 	    if (left != null)
 	    	result += "(" + left.toString() + ")";
 	    result += root.toString();
 	    if (right != null)
 	    result += "(" + right.toString() + ")";
 	    
 	    return result;
 		
 	}
  	public boolean isLeaf(){
  		if (left == null && right == null)
  			return true;
  		else 
  			return false;
  	}
}
	