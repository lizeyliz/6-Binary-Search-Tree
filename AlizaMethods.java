public class AlizaMethods {
    DatabaseNode root; //top of tree

    //constructor: will change later
    public AlizaMethods() {
        this.root = null;
    }//end constructor

    //from textbook
    /*public void add (int value) {
        DatabaseNode overallRoot = add(overallRoot, value);
    }
    public DatabaseNode add(DatabaseNode root, int value){
        if(root == null) {
            root = new DatabaseNode(value);
        } else if (root.idNum > value) {
            root.left = add(root.left, value)
        } else if(root.idNum < value) {
            root.right = add(root.right, value);
        }
        return root;
    }*/
    
    //left side smaller, right side bigger
    //slide 34 chapter 17 binary search trees
    //start with recursion then change to iteration
    /*public void add(DatabaseNode node) {
        if(root == null) {
            root = node;
        } else if (node < current) { 
            //start at top
            DatabaseNode current = root;
            //if left is empty, add node 
        
        } else if (node > current) {
            //start at top
            DatabaseNode current = root;

        } else {
            //invalid if # is same as one in tree
        }

    }//end add*/
}
