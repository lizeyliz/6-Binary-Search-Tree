import java.util.Stack;

public class DatabaseMethods {

    DatabaseNode root; //top of tree

    public DatabaseMethods() {
        this.root = null;
    }//end constructor

    //add a node to the binary search tree
    public void add(DatabaseNode newNode) {
        //if tree is empty
        if(root == null) {
            root = newNode;
            return; //end method here if root == null
        }//end if statement

        //starting from the top
        DatabaseNode current = root;
        //while loop for placement if tree is not empty
        while(true){ //loops until break is called
            if (newNode.getID() < current.getID()) {
                if(current.left == null) {
                    current.left = newNode; //insert to the left
                    break;
                } else {
                    current = current.left; //move to next node to the left
                }//end inner if/else 1
            } else if (newNode.getID() > current.getID()) {
                if(current.right  == null) {
                    current.right = newNode; //insert to the right
                    break;
                } else {
                    current = current.right; //move to next node to the right
                }//end inner if/else 2
            } else { //if newNode is equal to current
                //add exception handling here
                System.out.println("Node is a duplicate and cannot be placed.");
                break;
            }//end outer if/else
        }//end while loop
    }//end add method

    //generate random id number for extra credit (make sure there are no multiples)
    //hard code for now
    /*public int generateID(){

    }*/
        //print pre-order using iteration and stack
    public void printPreorder(DatabaseNode root) {
        if (root == null) { //BST empty
            return;
        }//end if 
        //creating a stack to hold tree values
        Stack<DatabaseNode> preorder = new Stack<>();
        //put the root in the stack
        preorder.push(root);

        while(!preorder.isEmpty()){
            //remove current node from stack (so no repeats) and print it
            DatabaseNode current = preorder.pop();
            System.out.print(current.getID() + " ");
            //do right subtree first (bc stacks are read opposite way they are added to)
            if(current.right != null) { 
                preorder.push(current.right); //adding right side values to stack
            }//end if statement 

            //left subtree
            if (current.left != null){
                preorder.push(current.left);//adding left side values to stack
            }//end if statement
        }//end while loop
    }//end printPreorder

    //pre-order recursive from geeksforgeeks 
    //https://www.geeksforgeeks.org/binary-search-tree-traversal-inorder-preorder-post-order/ 
    //use stack for iterative version?
    /*public static void printPreorder(DatabaseNode node) {
    if (node == null)
      return;//base case

    // Visit node
    System.out.print(node.getID() + " ");

    // Traverse left subtree
    printPreorder(node.left);

    // Traverse right subtree
    printPreorder(node.right);
  }*/

    public void modifyID(int iD) {

    }//end modify method

    public void printInOrder (DatabaseNode node) {
        if (node == null)
        return;
    
        //left tree
        printInOrder(node.left);
        System.out.print(node.getID() + " ");
    
        //right tree
        printInOrder(node.right);
    }//end inOrder method

    public void postOrder() {

    }//end postOrder method
}
