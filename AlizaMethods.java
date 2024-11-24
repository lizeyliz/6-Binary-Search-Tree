//https://liveexample.pearsoncmg.com/dsanimation13ejava/BSTeBook.html
//Chat GPT

//Extra credit: iteration
public class AlizaMethods {
    DatabaseNode root; //top of tree

    //constructor: will change name later when adding to methods class
    public AlizaMethods() {
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

    //print binary search tree using preorder
    //display as an array or linkedlist? mb not neccessary
    //will change get ID to toString method later?
    public void preorder () {
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


        }//end method preorder
}//end class AlizaMethods

//To do:
//-Add exception handling for duplicates