/**
 * ClassName: BST
 * Description:
 * date: 2019/10/25 21:36
 *
 * @author crwen
 * @create 2019-10-25-21:36
 * @since JDK 1.8
 */
public class BST<T extends Comparable<T>> {

	private class Node {
		public T e;
		public Node left, right;

		public Node(T e) {
			this.e = e;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;
	private int size;

	public BST() {
		root = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	// 判断BST是否为空
	public boolean isEmpty() {
		return size == 0;
	}


	public void add(T e) {
		root = add(root, e);
	}

	// 向以node为根的二分搜索书中插入元素e, 递归算法
	//返回插入新节点后二分搜索树的根
	private Node add(Node node, T e) {
		if (node == null) {
			size++;
			return new Node(e);
		}
		if (e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		} else if (e.compareTo(node.e) < 0){
			node.left = add(node.left, e);
		}
		return node;
	}

	// 看二分搜索树中是否包含元素e
	public boolean contains(T e) {
		return contains(root, e);
	}

	public boolean contains(Node node, T e) {
		if (node == null)
			return false;
		if (e.equals(node.e)) {
			return true;
		} else if (e.compareTo(node.e) > 0) {
			return contains(node.right, e);
		} else {
			return contains(node.left, e);
		}
	}

	// 前序遍历
	public void preOrder() {
		preOrder(root);
	}

	public void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.e + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	//中序遍历
	public void inOrder() {
		inOrder(root);
	}

	public void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.e + " ");
		inOrder(node.right);
	}

	// 后序遍历
	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.e + " ");
	}

	private void generateBSTString(Node node, int depth, StringBuilder res) {
		if (node == null) {
			res.append(generateBSTString(depth) + "null\n");
			return;
		}
		res.append(generateBSTString(depth) + node.e + "\n");
		generateBSTString(node.left, depth + 1, res);
		generateBSTString(node.right, depth + 1, res);
	}

	private String generateBSTString(int depth) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			res.append("--");
		}
		return res.toString();
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root, 0, res);
		return res.toString();
	}

	public static void main(String[] args) {
		int[] arr = {30, 28, 32, 13, 29, 31, 40};
		BST bst = new BST();
		for (int i = 0; i < arr.length; i++)
			bst.add(arr[i]);
		bst.preOrder();
		System.out.println();
		bst.inOrder();
		System.out.println();
		bst.postOrder();
		System.out.println();
		//System.out.println(bst);
		//System.out.println(bst.contains(2));
		//System.out.println(bst.contains(28));
	}
}
