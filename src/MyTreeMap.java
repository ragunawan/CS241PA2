/**
 *	TreeMap implemented as Binary Search Tree
 */
public class MyTreeMap<K extends Comparable<K>,V> implements MyMap<K,V> {
	private BinaryTree<Element> map;
	private java.util.Set<K> keys; 
	private int size;
		
	public boolean containsKey(K key){
		if(map.getRoot().search(new Element(key, null), map) != null)
			return true;
		else
			return false;
	}
	public V put(K key, V value){
		Element elem = new Element(key, value);
		elem.insert(elem);
		return value;
	}
	public V get(K key){
		if(this.containsKey(key))
			return map.getRoot().search(new Element(key, null), map).value;
		else
			return null;
	}
	public V remove(K key){
		if (this.containsKey(key)){
			Element elem = new Element(key, null);	
			return (map.getRoot().delete(map, elem, null)).value;
		} else
			return null;
	}
	public int size(){
/*
 		if tree is null, size is 0, height is -1
 		s = { 0 if tree = null
 			{ 1 + s(left) + s(right)
*/
		   BinaryTree<Element> y = map;
		    if (y == null) {
		        return 0;
		    } else {
		        map = y.getLeft();
		        int left = size();
		        map = y.getRight();
		        int right = size();
		        map = y;
		        return 1 + left + right;
		    }
			
	}	
	public int height()	{
/*
	height of a tree = calls left and right sizes then adds 1
	h = { -1 if Tree = null
		{ max(h(left), h(right)) + 1
*/
		/*
		BinaryTree<Element> left = map.getLeft();
		BinaryTree<Element> right = map.getRight();
		int leftH = 0, rightH = 0;
	       if (left == null && right == null) {
	            return 0;
	        } else {
	        	left = map.getLeft();
	        	leftH = height();
	            right = map.getRight();
	            rightH = height();
	            return Math.max(leftH,rightH) + 1;
	        }
	        */
		return map.getRoot().height(map);
	}
	public String toString(){
		return map.toString();
	}
	public java.util.Set<K> keySet(){
	// updates 'keys' to inorder key variables
		if (map!= null){
			keys = new java.util.TreeSet<K>();
			map.getRoot().inorder(map);
			return keys;
		}
		else
			return null;
	}

// private Element class
	private class Element {
		K key; V value;
		
		public Element(K key, V value){
			this.key = key;
			this.value = value;
		}	 
		public int compareTo(Element that){
			return this.key.compareTo(that.key);
		}
		public String toString(){
			return "(" + key + "," + value + ")";
		}	
	// private methods implementing BST operations search, insert, delete, inorder
	// reference: Wikipedia article on Binary Search Tree
	//
		private Element search(Element element, BinaryTree<Element> tree){
			if(tree == null)
				return null;			
			Element r = tree.getRoot();
		    if(element.compareTo(r) == 0)
				return tree.getRoot();
			else if(element.compareTo(r) < 0)
				return search(element, tree.getLeft());
			else
				return search(element, tree.getRight());		
		}	
		private Element insert(Element element){
			if (map == null){
				map = new BinaryTree<Element>(element);
				return null;
			}
			else
				 return insert(element, map);		
		}
		private Element insert(Element element, BinaryTree<Element> tree){
			Element r = tree.getRoot();
			
			if (element.compareTo(r) == 0) {
				tree.setRoot(element);
				return r;
			} else if (element.compareTo(r) < 0) {
				// if e < r : e is before r alphabetically
				if (tree.getLeft() == null) {
					tree.setLeft(new BinaryTree<>(element));
					return null;
				} else {
					return insert(element, tree.getLeft());
				}
			} else {
				// if e > r : e is after r alphabetically
				if (tree.getRight() == null) {
					tree.setRight(new BinaryTree<>(element));
					return null;
				} else {
					return insert(element, tree.getRight());
				}
			}
		}
		private Element delete(BinaryTree<Element> tree, Element e, BinaryTree<Element> parent){
			// step 1
			if (tree == null) {
				return null;
			} else {
				// step 2
				Element r = tree.getRoot();		
				// step 3
				if (e.compareTo(r) < 0) {
					return delete(tree.getLeft(), e, tree);
				// step 4
				} else if (e.compareTo(r) > 0) {
					return delete(tree.getRight(), e, tree);
				// step 5
				} else {
					// step 5.1	
					if (tree.isLeaf()){
						parent.setLeft(null);
						// step 5.2		
					} else if ((tree.getLeft() != null && tree.getRight() == null) || (tree.getLeft() == null && tree.getRight() != null)){
						if (tree.getLeft() != null){
							// if x child is left
							delete(tree.getLeft(), e, tree);
							promote(tree, parent, tree.getLeft());
						}	else {
							// if x child is right
							delete(tree.getRight(), e, tree);
							promote(tree, parent, tree.getRight());
						}
					// step 5.3		
					} else {
						// find inorder successor node 's' of 'x' with element 'f'			
						BinaryTree<Element> s = tree.getRight();
						BinaryTree<Element> s_parent = tree;
						while (s.getLeft() != null){
							s_parent = s;
							s = s.getLeft();	
						}
						Element f = s.getRoot();
						// set element at 'x' to 'f'
						tree.setRoot(f);
						// delete 's' and promote its only child
						delete(s, f, s_parent);
					}
					// step 5.4	
					return r;
				}
			}
		}
// make newChild the appropriate (left or right) child of parent, if parent exists
	private void promote(BinaryTree<Element> tree, BinaryTree<Element> parent, BinaryTree<Element> newChild){
		if(newChild.getRoot().compareTo(parent.getRoot()) < 0)
			parent.setLeft(newChild);
		else
			parent.setRight(newChild);
	}
	private void inorder(BinaryTree<Element> tree) {
		if (tree != null) {
			if(tree.getLeft() != null)
				inorder(tree.getLeft());

			keys.add(tree.getRoot().key);			
			if(tree.getRight() != null)
				inorder(tree.getRight());	
		}
	}
	private int height(BinaryTree<Element> tree){
		if (tree == null)
			return -1;
		else {
			int lHeight = height(tree.getLeft());
			int rHeight = height(tree.getRight());
			return Math.max(lHeight, rHeight) + 1;
		}

	}
	}
}