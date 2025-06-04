class Node{
	int data;
	Node left;
	Node right;
	Node(int value){
		data=value;
		left=right=null;
    }
}
public class BinaryTree2{
	Node root;
    public BinaryTree2(){
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
	public static void main(String[] args){
		BinaryTree2 tree=new BinaryTree2();
		int totalNodes=tree.countNodes(tree.root);
		System.out.println("total number of nodes:"+totalNodes);
	}
}