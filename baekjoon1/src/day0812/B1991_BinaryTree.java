package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991_BinaryTree {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		
		LinkedBinaryTree lbt = new LinkedBinaryTree();
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			char node = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			lbt.makeBinaryTree(node, left, right);
		}
		
		lbt.PreOrder(lbt.root);
		System.out.println();
		lbt.InOrder(lbt.root);
		System.out.println();
		lbt.PostOrder(lbt.root);
		
	}

}

class Node{
	char data;
	Node left;
	Node right;
	
	public Node(char data) {
		this.data = data;
	}
}

class LinkedBinaryTree{
	Node root;
	public void makeBinaryTree(char data, char left, char right) {
		if(root == null) {
			if(data!='.') root = new Node(data);
			if(left!='.') root.left = new Node(left);
			if(right!='.') root.right = new Node(right);
		}else {
			search(root, data, left,right);
		}
		System.out.println(root.data);
	}
	
	
	void search(Node root, char data, char left, char right) {
		if(root == null) 
			return;
		if(root.data == data) {
			if(left!='.')
				root.left = new Node(left);
			if(right!='.')
				root.right = new Node(right);
		}else {
			search(root.left,data,left,right);
			search(root.right,data,left,right);
		}
	}
	
	public void visit(char data) {
//		if(data != null)
			System.out.print(data);
	}
	
	//전위 순회 (PreOrder Traversal)
	public void PreOrder(Node root) {
		visit(root.data);
		if(root.left!=null) PreOrder(root.left);
		if(root.right!=null) PreOrder(root.right);
		//////////////////////////////////////////////////////
		System.out.println(root.data);
	}
	
	//중위 순회 (InOrder Traversal)
	public void InOrder(Node root) {
		if(root.left!=null) InOrder(root.left);
		System.out.print(root.data);
//		visit(node.data);
		if(root.right!=null) InOrder(root.right);
	}
	
	//후위 순회 (PostOrder Traversal)
	public void PostOrder(Node root) {
		if(root.left!=null) PostOrder(root.left);
		if(root.right!=null) PostOrder(root.right);
		System.out.print(root.data);
//		visit(node.data);
	}
}