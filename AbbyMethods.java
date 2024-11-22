public class AbbyMethods {
    DatabaseNode root; //top of tree
    
    //start at root, print all left nodes then backtrack and print right
    public void preOrder() {
        if (root == null) {
            System.out.println("Empty Database");
        } else {
            DatabaseNode current = root;
            DatabaseNode parent = null;
            System.out.print("Pre-order: " + root.getID());
            //print all left nodes
            while (current.left != null) {
                System.out.print( " " + current.getID());
                parent = current;
                current = current.left;
            }//end while loop
            while (parent.right != null) {

            }//end while loop
        }//end if/else statement
    }//end preOrder method
}
