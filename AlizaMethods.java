//https://liveexample.pearsoncmg.com/dsanimation13ejava/BSTeBook.html
//Chat GPT

//Extra credit: iteration

public class AlizaMethods {
    DatabaseNode root; //top of tree

    //constructor: will change name later when adding to methods class
    public AlizaMethods() {
        this.root = null;
    }//end constructor

    //print binary search tree using preorder
    //display as an array or linkedlist? mb not neccessary
    //will change get ID to toString method later?
    // 1)Root 2) left subtree 3) right subtree
    /*public void preorder () {
        //1) print root
        DatabaseNode current = root;
        //if empty
        if (root == null) { //might have issues with root value
            System.out.println("Tree is empty");
            return; //end method here
        } else {
            System.out.println(current.getID());
        }
        //2) traverse and print left side
        while(current.left != null) {
            System.out.println(current.left.getID());
            if (current.left.left != null) {
                current = current.left;
            }
        } 
        //go back to parent node when finished
        //3) traverse and print right side
        while(current.right != null) {
            System.out.println(current.right.getID());
            if (current.right.right != null) {
                current = current.right;
            }
        }
    }//end method preorder*/

    //pre-order recursive from geeksforgeeks 
    //https://www.geeksforgeeks.org/binary-search-tree-traversal-inorder-preorder-post-order/ 
    public static void printPreorder(DatabaseNode node)
  {
    if (node == null)
      return;

    // Visit node
    System.out.print(node.getID() + " ");

    // Traverse left subtree
    printPreorder(node.left);

    // Traverse right subtree
    printPreorder(node.right);
  }
}//end class AlizaMethods

//To do:
//-Add exception handling for duplicates