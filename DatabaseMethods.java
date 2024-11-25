public class DatabaseMethods {

    DatabaseNode root; //top of tree

    //constructor: will change name later when adding to methods class
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

    public void modifyID(int iD) {

    }//end modify method

    public void preOrder() {

    }//end preOrder method

    public void inOrder() {

    }//end inOrder method

    public void postOrder() {

    }//end postOrder method
}
