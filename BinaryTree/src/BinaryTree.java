/**
 * BinaryTree
 * variables contains a root and the getter
 * Methods:create binary tree and get specified order
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree<T> {

	private BinaryTreeNode<T> root = new BinaryTreeNode<>();	
	
	public BinaryTreeNode<T> getRoot(){
		return this.root;
	}
/**
 * create a binary tree, this tree is a complete binary tree
 * the elements are ordered as array's order
 * 
 * @param array, the T type array
 * @return BinaryTreeNode, the root
 */
	public BinaryTreeNode<T> createBinaryTree(T[] array){
		Queue<BinaryTreeNode<T>> queue = new LinkedList<>();//queue to store nodes
		queue.add(this.root);
		int count = 1;//count to decide how many nodes should be created
		for(int i=0; i<array.length; i++){
			BinaryTreeNode<T> pNode = queue.poll();
			pNode.data = array[i];
			if(count < array.length){
				if(count == (array.length-1)){
					BinaryTreeNode<T> lNode = new BinaryTreeNode<>();
					pNode.lChild = lNode;
					queue.add(lNode);
					count++;
				}
				else{
					BinaryTreeNode<T> lNode = new BinaryTreeNode<>();
					BinaryTreeNode<T> rNode = new BinaryTreeNode<>();
					pNode.lChild = lNode;
					pNode.rChild = rNode;
					queue.add(lNode);
					queue.add(rNode);
					count+=2;
				}
			}
		}
		
		return this.root;
	}
	
	/**
	 * use recursive method to get the pre order list
	 * @param treeRoot
	 * @return ordered list
	 */
	public ArrayList<T> preOrderRecu(BinaryTreeNode<T> treeRoot){
		ArrayList<T> preOrderList = new ArrayList<>();
		preOrderRecuInside(treeRoot, preOrderList);
		return preOrderList;
	}
	private void preOrderRecuInside(BinaryTreeNode<T> treeRoot, ArrayList<T> preOrderList){
		BinaryTreeNode<T> tmp = treeRoot;
		if(tmp == null) return;
		else{
			preOrderList.add(tmp.data);//visit the element
			preOrderRecuInside(tmp.lChild, preOrderList);//recurse traverse the left subtree
			preOrderRecuInside(tmp.rChild, preOrderList);//recurse traverse the right subtree
		}
	}
	
/**
 * non-recursive method to implement pre order
 * @param treeRoot
 * @return ordered list
 */
	public ArrayList<T> preOrder(BinaryTreeNode<T> treeRoot){
		ArrayList<T> preOrderList = new ArrayList<>();
		BinaryTreeNode<T> tmp = treeRoot;
		Stack<BinaryTreeNode<T>> stack = new Stack<>();//stack to store nodes
		while((tmp!=null) || (!stack.empty())){
			while(tmp != null){
				preOrderList.add(tmp.data); //visit element
				stack.push(tmp);//push this node to stack
				tmp = tmp.lChild;//go to left subtree
			}
			if(!stack.empty()){
			tmp = stack.pop();//pop one node 
			tmp = tmp.rChild;//go to right subtree
			}
		}
		return preOrderList;
	}
	
	/**
	 * recursive method to get in ordered list
	 * @param treeRoot
	 * @return list
	 */
	public ArrayList<T> inOrderRecu(BinaryTreeNode<T> treeRoot){
		ArrayList<T> inOrderList = new ArrayList<>();
		inOrderRecuInside(treeRoot, inOrderList);
		return inOrderList;
	}
	private void inOrderRecuInside(BinaryTreeNode<T> treeRoot, ArrayList<T> inOrderList){
		BinaryTreeNode<T> tmp = treeRoot;
		if(tmp == null) return;
		else{
			
			inOrderRecuInside(tmp.lChild, inOrderList);
			inOrderList.add(tmp.data);//visit element
			inOrderRecuInside(tmp.rChild, inOrderList);
		}
	}
	
	/**
	 * non-recursive method to implement in ordered list
	 * @param treeRoot
	 * @return
	 */
	public ArrayList<T> inOrder(BinaryTreeNode<T> treeRoot){
		ArrayList<T> inOrderList = new ArrayList<>();
		BinaryTreeNode<T> tmp = treeRoot;
		Stack<BinaryTreeNode<T>> stack = new Stack<>();
		
		while((tmp != null) || (!stack.empty())){
			while(tmp != null){
				stack.push(tmp);//push the node
				tmp = tmp.lChild;//go to the left subtree 
			}
			if(!stack.empty()){
				tmp = stack.pop();//pop a node
				inOrderList.add(tmp.data);//visit
				tmp = tmp.rChild;//go to the right subtree
			}
		}
		
		return inOrderList;
	}
	
	/**
	 * recursive method to implement post order
	 * @param treeRoot
	 * @return
	 */
	public ArrayList<T> postOrderRecu(BinaryTreeNode<T> treeRoot){
		ArrayList<T> postOrderList = new ArrayList<>();
		postOrderRecuInside(treeRoot, postOrderList);
		return postOrderList;
	}
	private void postOrderRecuInside(BinaryTreeNode<T> treeRoot, ArrayList<T> postOrderList){
		BinaryTreeNode<T> tmp = treeRoot;
		if(tmp == null) return;
		else{
			postOrderRecuInside(tmp.lChild, postOrderList);
			postOrderRecuInside(tmp.rChild, postOrderList);
			postOrderList.add(tmp.data);//visit element
		}
	}
	
	/**
	 * non-recursive method to implement post order list
	 * @param treeRoot
	 * @return
	 */
	public ArrayList<T> postOrder(BinaryTreeNode<T> treeRoot){
		ArrayList<T> postOrderList = new ArrayList<>();
		BinaryTreeNode<T> tmp = treeRoot;
		BinaryTreeNode<T> pre = null;//store the last visited node
		Stack<BinaryTreeNode<T>> stack = new Stack<>();
		stack.push(tmp);//first push the root node
		while(!stack.empty()){
			tmp = stack.peek();//obtain the top of stack, but not remove this node from stack
			if(((tmp.lChild==null)&&(tmp.rChild==null))
					||((pre==tmp.lChild)||(pre==tmp.rChild))){//this node no child OR childs have been visited
				//the reason why we use || because the following we first push rchild and then lchild
				postOrderList.add(tmp.data);
				stack.pop();
				pre = tmp;
			}
			else{
				if(tmp.rChild!=null) stack.push(tmp.rChild);//first push right child
				if(tmp.lChild!=null) stack.push(tmp.lChild);//then push left child
				//so if pre is tmp left child, next would be tmp right child OR null 
			}
		}
		return postOrderList;
	}

	/**
	 * level traverse a tree
	 * @param treeRoot
	 * @return
	 */
	public ArrayList<T> levelTraverse(BinaryTreeNode<T> treeRoot){
		Queue<BinaryTreeNode<T>> queue = new LinkedList<>();//just use a queue to store the nodes
		ArrayList<T> leveList = new ArrayList<>();
		BinaryTreeNode<T> tmp = treeRoot;
		queue.add(tmp);
		while(!queue.isEmpty()){
			tmp = queue.poll();
			leveList.add(tmp.data);
			if(tmp.lChild !=null) queue.add(tmp.lChild);
			if(tmp.rChild !=null) queue.add(tmp.rChild);
		}
		
		return leveList;
	}
}
