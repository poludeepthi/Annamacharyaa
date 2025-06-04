class Node{
	int data;
	Node left;
	Node right;
	Node(int value){
		data=value;
		left=right=null;
    }
}
public class BinaryTree1{
	Node root;
    public BinaryTree1(){
    root=new Node(1);
	root.left=new Node(2);
	root.right=new Node(3);
	root.left.left=new Node(4);
	root.left.right=new Node(5);
	}
	public void printInorder(Node node) {
	    if(node==null)return;
		printInorder(node.left);
		System.out.println(node.data+" ");
		printInorder(node.right);
	}	
	public void printPostorder(Node node) {
	    if(node==null)return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.println(node.data+" ");
	}	
    public static void main(String[] args){
		BinaryTree1 tree=new BinaryTree1();
		System.out.println("Inorder Traversal");
		tree.printInorder(tree.root);
		System.out.println();
        System.out.println("Postorder Traversal");
		tree.printPostorder(tree.root);
		System.out.println(); 
    }					
 }					