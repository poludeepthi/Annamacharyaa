class Node{
	int data;
	Node left;
	Node right;
	Node(int value){
		data=value;
		left=right=null;
    }
}
public class BinaryTree3{
	Node root;
    public BinaryTree3(){
    root=new Node(1);
	root.left=new Node(2);
	root.right=new Node(3);
	root.left.left=new Node(4);
	root.left.right=new Node(5);
	}
	public int countNodes(Node node){
		if(node==null)return 0;
		return 1+countNodes(node.left)+countNodes(node.right);
	}
	public int countLeafNodes(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }
	public static void main(String[] args) {
        BinaryTree3 tree = new BinaryTree3();
        int totalNodes = tree.countNodes(tree.root);
        System.out.println("Total number of nodes: " + totalNodes);
        int totalLeafNodes = tree.countLeafNodes(tree.root);
        System.out.println("Total number of leaf nodes: " + totalLeafNodes);
    }
}