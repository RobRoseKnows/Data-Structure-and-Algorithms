


public class BinarySearchTree {
	private BinaryTreeNode root;
	public BinaryTreeNode getRoot() {
		return this.root;
	}
	public BinaryTreeNode initBinarySearchTree(){
		root = new BinaryTreeNode();
		return root;
	}
	
	/**
	 * if find this element, return the reference of this node
	 * else return the final reference of this node, which is also where should be insert
	 * @param element
	 * @return
	 */
	public BinaryTreeNode binaryTreeSearch(int element){
		BinaryTreeNode tmp = root;/*tmp to store the current node*/
		BinaryTreeNode parent = tmp;
		
		while(tmp != null){
			if(tmp.data == element) return tmp; /*find the element, return this reference*/
			else{
				parent = tmp;
				if(element<tmp.data) tmp = tmp.lChild;/*less than this data, go to left child*/
				else tmp = tmp.rChild;/*greater than this data, go to right child*/
			}
		}
		return parent;/*finally, not found, return the parent reference*/
	}
	public void insertBinaryTreeNode(int element){
		BinaryTreeNode tmp = binaryTreeSearch(element);
//		if(tmp.data == element) intert(); for now not consider repeated
		BinaryTreeNode newNode = new BinaryTreeNode();
		newNode.data = element;
		if(element < tmp.data) tmp.lChild = newNode;
		else if(element > tmp.data) tmp.rChild = newNode;
	}
	
	public void createBinaryTreeNode(int[] array){
		initBinarySearchTree();
		for(int element:array){
			insertBinaryTreeNode(element);
		}
	}
}
