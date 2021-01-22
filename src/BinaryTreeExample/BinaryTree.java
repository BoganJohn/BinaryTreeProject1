package BinaryTreeExample;

public class BinaryTree {

    Node root;

    public void addNode(int key, String name) {

        // Create a new Node and initialize it
        Node newNode = new Node(key, name);
        // If there is no root this becomes root
        if (root == null) {
            root = newNode;
        } else {
            // Set root as the Node we will start
            // with as we traverse the tree

            Node focusNode = root;

            // Future parent for our new Node

            Node parent;

            while (true) {

                // root is the top parent so we start

                // there

                parent = focusNode;

                // Check if the new node should go on

                // the left side of the parent node

                if (key < focusNode.key) {

                    // Switch focus to the left child

                    focusNode = focusNode.leftChild;

                    // If the left child has no children

                    if (focusNode == null) {

                        // then place the new node on the left of it

                        parent.leftChild = newNode;

                        return; // All Done
                    }
                } else { // If we get here put the node on the right

                    focusNode = focusNode.rightChild;

                    // If the right child has no children

                    if (focusNode == null) {

                        // then place the new node on the right of it

                        parent.rightChild = newNode;

                        return; // All Done

                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(Node focusNode){
        if (focusNode != null){
            inOrderTraverseTree(focusNode.leftChild);

            System.out.println(focusNode);

            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraverseTree(Node focusNode){
        if (focusNode != null){

            System.out.println(focusNode);

            preOrderTraverseTree(focusNode.leftChild);

            preOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode){
        if (focusNode != null){

            postOrderTraverseTree(focusNode.leftChild);

            postOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);
        }
    }

    public Node findNode(int key){
        Node focusNode = root;

        while (focusNode.key != key){

            if ( key < focusNode.key){

                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null){
                return null;
            }

        } return focusNode;
    }


    public static void main(String[] args) {

        BinaryTree theTree = new BinaryTree();

        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vice President");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secretary");
        theTree.addNode(75, "Sales Manager");
        theTree.addNode(85, "Salesman 1");

        System.out.println("Search for 30 ");
        System.out.println(theTree.findNode(30));

    }
}

class Node {

    int key;
    String name;

    Node leftChild;
    Node rightChild;

    Node(int key,String name){
        this.key = key;
        this.name = name;
    }

    public String toString(){
        return name + " has the key " + key;
    }
}