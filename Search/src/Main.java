
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={2, 4, 8, 12, 14};
		int element = 8;
		//System.out.println("the index is "+Search.binarySearch(array, element));
		BinarySearchTree tree = new BinarySearchTree();
		tree.createBinaryTreeNode(array);
		BinaryTreeNode p = tree.binaryTreeSearch(element);
		System.out.println("search element "+p.data);
	}

}
